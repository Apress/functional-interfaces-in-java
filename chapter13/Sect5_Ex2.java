package chapter13;
import java.util.concurrent.CompletableFuture;
public class Sect5_Ex2 
{
    public static void main(String[] args)
    {
        CompletableFuture
         .supplyAsync( () -> "RED")              // CompletableFuture<String>
         .thenApply(x -> 
              x.equals("RED")? "GREEN":"BLUE")   // CompletableFuture<String>
         .thenAccept(x -> System.out.println(x));// CompletableFuture<Void>
    }
}