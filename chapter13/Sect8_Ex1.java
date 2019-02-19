package chapter13;
import java.util.function.Supplier;
import java.util.concurrent.CompletableFuture;
public class Sect8_Ex1 
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
        
        if (cf1.cancel(true))
            System.out.println("Future cf1 cancelled."); 
    }
}