package chapter14;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
public class Safe 
{
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args)
    {

        CompletableFuture<Integer> cf1 =
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < 10000; ++i)
            {
                int x = num.addAndGet(10);
            }
            return num.get();
        });

        CompletableFuture<Integer> cf2 =
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < 10000; ++i)
            {
                int x = num.addAndGet(-10);
            }
            return num.get();
        });
        
        CompletableFuture.allOf(cf1, cf2)
                         .join();
    }
}