package chapter14;
import java.util.concurrent.atomic.AtomicInteger;
public class Sect1c_Ex1 
{
    public static void main(String[] args)
    {
        AtomicInteger a = new AtomicInteger(0);
        for (int i=0; i<9; ++i)
        {
             a.updateAndGet(x -> x + 10);
             a.compareAndExchange(50,0);
             System.out.println(a.get());
        }
    }
}