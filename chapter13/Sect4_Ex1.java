package chapter13;
import java.util.concurrent.*;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        try {
         System.out.println(
         CompletableFuture.completedFuture("RED") // CompletableFuture<String>
                          .get());                // String
        } catch (InterruptedException
                |ExecutionException e) {}        
    }
}