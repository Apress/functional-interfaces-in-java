package chapter14;
import java.util.concurrent.*;
public class Unsafe
{
    static int num = 0;
    public static void main(String[] args)
    {
        CompletableFuture<Integer> cf1 = 
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < 10000; ++i)
            {
                int x = num;
                num += 10;
                if (num != (x+10))
                    System.out.println("cf1 THREAD READ ERROR: x= "
                                     + x +" num= " + num);
            }
            return num;
        });

        CompletableFuture<Integer> cf2 =
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < 10000; ++i)
            {
                int x = num;
                num -= 10;
                if (num != (x-10))
                    System.out.println("cf2 THREAD READ ERROR: x= "
                                     + x +" num= " + num);
            }
            return num;
        });
        
        CompletableFuture.allOf(cf1, cf2)
                         .join();
    }
}