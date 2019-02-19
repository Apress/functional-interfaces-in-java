package chapter14;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
public class ShareAnInt
{
    public static void main(String[] args)
    {
        AtomicInteger num = new AtomicInteger(0);
        CompletableFuture<Integer> cf1 =
          CompletableFuture.supplyAsync( () -> {
            int x = num.get();
            for (int i=0; i<20; ++i)
            {
                x = num.updateAndGet(z -> z + 10);
                if (num.compareAndSet(100, 0))
                {
                    System.out.println("cf1 resets atomic variable");
                    x = num.get();
                }
                System.out.println("cf1 a = " + x);
            }
            return x;
        });

        CompletableFuture<Integer> cf2 =
          CompletableFuture.supplyAsync( () -> {
            int x = num.get();
            for (int i=0; i<20; ++i)
            {
                x = num.updateAndGet(z -> z + 10);
                if (num.compareAndSet(80, 0))
                {
                    System.out.println("cf2 resets atomic variable");
                    x = num.get();
                }
                System.out.println("cf2 a = " + x);
            }
            return x;
        });

        CompletableFuture.allOf(cf1,cf2) 
                         .join();
    }
}