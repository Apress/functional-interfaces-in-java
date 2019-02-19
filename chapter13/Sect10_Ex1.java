package chapter13;
import java.util.function.BiFunction;
import java.util.concurrent.CompletableFuture;
public class Sect10_Ex1 
{
    public static void main(String[] args)
    {
        CompletableFuture<String> cf4 
            = CompletableFuture.supplyAsync( () -> "RED");
        CompletableFuture<String> cf5 
            = CompletableFuture.supplyAsync( () -> "GREEN");
        CompletableFuture<String> cf6 
            = CompletableFuture.supplyAsync( () -> "BLUE");

        BiFunction<String,String,String> bi = (x,y) -> x + "," + y;

        System.out.println(cf4.thenCombine(cf5, bi)
                              .thenCombine(cf6, bi)
                              .join());
    }
}