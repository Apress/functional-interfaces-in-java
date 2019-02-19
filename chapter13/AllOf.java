package chapter13;
import java.util.concurrent.CompletableFuture;
public class AllOf 
{
    static String color1=null;
    static String color2=null;
    static String color3=null;
    public static void main(String[] args)
    {
        CompletableFuture<String> cf1 
            = CompletableFuture.supplyAsync( () -> {
                color1 = "RED"; return null;});
        CompletableFuture<String> cf2 
            = CompletableFuture.supplyAsync( () -> {
                color2 = "GREEN"; return null;});


        CompletableFuture<String> cf3 
            = CompletableFuture.supplyAsync( () -> {
                color3 = "BLUE"; return null;});
        
        CompletableFuture
           .allOf(cf1,cf2,cf3) // CompletableFuture<Void>
           .join();            // Void
        
        System.out.println(color1 + "," + color2 + "," + color3);
    }
} 
