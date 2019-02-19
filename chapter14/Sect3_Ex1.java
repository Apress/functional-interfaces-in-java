package chapter14;
import java.util.concurrent.atomic.AtomicBoolean;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {
        AtomicBoolean bool = new AtomicBoolean(true);
        System.out.println(bool.get());
        bool.compareAndExchange(true,false);
        System.out.println(bool.get());
        bool.set(true);
        System.out.println(bool.get());
    }
}