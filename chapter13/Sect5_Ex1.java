package chapter13;
import java.util.concurrent.CompletableFuture;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        CompletableFuture<Integer> cf1 = CompletableFuture
           .supplyAsync( () -> "3")             // CompletableFuture<String>
           .thenApply(x -> Integer.parseInt(x)) // CompletableFuture<Integer>
           .thenApply(x -> ++x);                // CompletableFuture<Integer>
        
        System.out.println(cf1.join());         
    }
}