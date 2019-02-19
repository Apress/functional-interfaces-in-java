package chapter14;
import java.util.concurrent.atomic.AtomicInteger;
public class Sect1b_Ex1 
{
    public static void main(String[] args)
    {
        AtomicInteger a1 = new AtomicInteger(10);
        System.out.println(a1.updateAndGet(x -> x * 2));
        System.out.println(a1.updateAndGet(x -> x - 5));
    }
}