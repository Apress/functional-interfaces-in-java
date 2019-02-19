package chapter13;
import java.util.concurrent.*;
public class Sect8_Ex3 
{
    public static void main(String[] args)
    {
        CompletableFuture<Integer> cf2 
            = CompletableFuture.completedFuture(6);

        if (cf2.cancel(true))
            System.out.println("Future cf2 cancelled.");

        try {
            System.out.println(cf2.join());
        } catch (CancellationException e) { 
            System.out.println("Cannot join cancelled future."); 
        }
    }
}