package chapter6;
import java.util.function.*;
public class ConsumerSpecials 
{
    private static int    a = 0;
    private static long   b = 0;
    private static double c = 1.0;
    public static void main(String[] args)
    {
        IntConsumer    ic = x -> a = x + 3;
        LongConsumer   lc = x -> b = x / 2L;
        DoubleConsumer dc = x -> c = x * c;
        
        ic.andThen(x -> System.out.println(a))
          .accept(2);
        lc.andThen(x -> System.out.println(b))
          .accept(6L);
        dc.andThen(x -> System.out.println(c))
          .accept(4.0);
    }
}
