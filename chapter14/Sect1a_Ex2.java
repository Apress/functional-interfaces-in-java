package chapter14;
import java.util.concurrent.atomic.AtomicInteger;
public class Sect1a_Ex2 
{
    public static void main(String[] args)
    {
        AtomicInteger a2 = new AtomicInteger(4);
        System.out.println(a2.getAndAccumulate(2, (x,y) -> x * y));
        System.out.println(a2.getAndAccumulate(7, (x,y) -> x + y/2));
        System.out.println(a2.get());        
    }
}