package chapter13;
import java.util.function.Supplier;
import java.util.concurrent.CompletableFuture;
public class Sect7_Ex1 
{
    public static void main(String[] args)
    {
        Supplier<Integer> s1 = () ->
        {
            try { Thread.sleep(3000);
            } catch (InterruptedException e) {}
            return 4;
        };

        CompletableFuture<Integer> cf1 
            = CompletableFuture.supplyAsync(s1);

        CompletableFuture<String> cf2 = cf1.thenCompose( x -> {
            CompletableFuture<String> c = new CompletableFuture();
            c.complete("HI" + Integer.toString(x));
            return c;
        });

        System.out.println(cf2.join());
    }
}