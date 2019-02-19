package chapter13;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.Scanner;
public class MySentence
{
    private static Semaphore sem = new Semaphore(0);
    private static String word = "";
    public static void main(String[] args)
    {
        Supplier<String> keyboard = () -> {
            Scanner scan = new Scanner(System.in);
            while (!word.equals("."))
            {
                System.out.print(
                      "Enter a word (or . when finished):");
                word = scan.nextLine();
                sem.release();
            }
            return null;
        };
        Supplier<String> concatenator = () -> {
            String sentence = "";
            while (!word.equals("."))
            {

                try {
                    sem.acquire();
                } catch (InterruptedException e) {}
                if (!word.equals(".") && sentence.length() > 0)
                    sentence += " ";
                sentence += word;
            }
            return sentence;
        };

        CompletableFuture<String> keyboardFuture 
            = CompletableFuture.supplyAsync(keyboard);
        CompletableFuture<String> concatFuture 
            = CompletableFuture.supplyAsync(concatenator);
                
        BiFunction<String,String,String> bi = (x,y) -> y;
        
        System.out.println(keyboardFuture
                          .thenCombine(concatFuture, bi)
                          .join());
    }
}