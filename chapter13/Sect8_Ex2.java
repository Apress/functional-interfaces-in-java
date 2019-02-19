package chapter13;
import java.util.concurrent.*;
import java.util.function.Supplier;
public class Sect8_Ex2 
{
    public static void main(String[] args)
    {
        Supplier<Integer> s = () -> {
            try { Thread.sleep(10000); 
            } catch (InterruptedException e) {}
            return 5;
        };

        CompletableFuture<Integer> cf1 
            = CompletableFuture.supplyAsync(s);
        
        cf1.cancel(true);

        try {
            System.out.println(cf1.join());
        } catch (CancellationException e) { 
            System.out.println("Cannot join cancelled future."); 
        }
    }
}