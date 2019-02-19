package chapter13;
import java.util.function.Supplier;
import java.util.concurrent.*;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        Supplier<Integer> s1 = () -> {
            try { Thread.sleep(5);
            } catch (InterruptedException e) {}
            return 4;
        };

        Supplier<Integer> s2 = () -> {
            try { Thread.sleep(2);
            } catch (InterruptedException e) {}
            return 5;
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        CompletableFuture<Integer> cf1 
            = CompletableFuture.supplyAsync(s1,exec);
        CompletableFuture<Integer> cf2 
            = CompletableFuture.supplyAsync(s2,exec);

        CompletableFuture<Void> cf3 
            = cf1.acceptEitherAsync(cf2, 
                                    x ->System.out.println(x),exec);
    }
}