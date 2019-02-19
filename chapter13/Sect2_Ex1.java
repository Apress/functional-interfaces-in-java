package chapter13;
import java.util.concurrent.*;
import java.util.Random;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        Callable<Integer> c = () -> (new Random()).nextInt(100);
        Runnable r = () -> System.out.println("Runnable");

        FutureTask<Integer> fc = new FutureTask(c);
        FutureTask<Integer> fr = new FutureTask(r,-1);
        
        fc.run();
        fr.run();
        
        try {
            int i = fc.get();
            int j = fr.get();
            System.out.println(i + " " + j);
        } catch(InterruptedException|ExecutionException e) {}
    }
}