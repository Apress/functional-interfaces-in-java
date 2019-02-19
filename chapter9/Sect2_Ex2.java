package chapter9;
import java.util.function.IntToLongFunction;
import java.util.Arrays;
public class Sect2_Ex2 
{
    public static void main(String[] args)
    {
        IntToLongFunction gen5 = x -> 5;
        long[] larr = new long[4];
        Arrays.setAll(larr, gen5);
        for (long l : larr)
            System.out.println(l);
    }
}
