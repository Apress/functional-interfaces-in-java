package chapter14;
import java.util.concurrent.atomic.AtomicReference;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        AtomicReference<String> ref = new AtomicReference<>("R");
        for (int i=0; i < 5; ++i)
        {
            System.out.println(ref.accumulateAndGet(Integer.toString(i),
                                                    (x,y) -> x + y));
        }
    }
}