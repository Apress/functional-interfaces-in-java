package chapter14;
import java.util.concurrent.atomic.AtomicInteger;
public class Sect1a_Ex1 
{
    public static void main(String[] args)
    {
        AtomicInteger a1 = new AtomicInteger(4);
        System.out.println(a1.accumulateAndGet(2, (x,y) -> x * y));
        System.out.println(a1.accumulateAndGet(7, (x,y) -> x + y/2));
    }
}