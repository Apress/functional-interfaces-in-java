package chapter13;
import java.util.concurrent.CompletableFuture;
public class Sect4_Ex2 
{
    public static void main(String[] args)
    {
        System.out.println(
        CompletableFuture.completedFuture("BLUE") // CompletableFuture<String>
                         .join());                // String
    }
}