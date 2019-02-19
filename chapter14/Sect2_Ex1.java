package chapter14;
import java.util.concurrent.atomic.AtomicLong;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        AtomicLong l = new AtomicLong(10L);
        System.out.println(l.accumulateAndGet(2, (x,y) -> x / y));
        l.compareAndExchange(5,3);
        System.out.println(l.get());
    }
}