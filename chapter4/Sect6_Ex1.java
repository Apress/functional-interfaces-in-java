package chapter4;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.function.ToDoubleFunction;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        ToIntFunction<String> ti     = x -> Integer.parseInt(x);
        ToLongFunction<Double> tl    = x -> x.longValue();
        ToDoubleFunction<Integer> td = x -> (new Integer(x)).doubleValue();

        System.out.println(ti.applyAsInt("5"));
        System.out.println(tl.applyAsLong(5.1));
        System.out.println(td.applyAsDouble(7));
    }
}
