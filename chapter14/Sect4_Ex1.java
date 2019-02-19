package chapter14;
import java.util.concurrent.atomic.AtomicIntegerArray;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        final int ARRAY_SIZE = 4; 
        AtomicIntegerArray arr = new AtomicIntegerArray(ARRAY_SIZE);

        for (int i=0; i < ARRAY_SIZE; ++i)
        {
            System.out.println(i + ": " 
                             + arr.accumulateAndGet(i, i, 
                                                    (x,y) -> x + 2*y));
        }
    }
}