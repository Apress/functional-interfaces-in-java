package chapter14;
import java.util.concurrent.atomic.AtomicInteger;
public class Sect1b_Ex2 
{
    public static void main(String[] args)
    {
        AtomicInteger a2 = new AtomicInteger(10);
        System.out.println(a2.getAndUpdate(x -> x * 2));
        System.out.println(a2.getAndUpdate(x -> x - 5));
        System.out.println(a2.get());
    }
}