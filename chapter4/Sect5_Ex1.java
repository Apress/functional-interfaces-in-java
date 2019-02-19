package chapter4;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.DoubleFunction;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        IntFunction<String> fi = x -> (new Integer(x)).toString();
        DoubleFunction<Boolean> fd = x -> x > 5.0? true : false;
        LongFunction<Integer> fl = x -> (int)x;

        System.out.println(fi.apply(5));
        System.out.println(fd.apply(4.5));
        System.out.println(fl.apply(20L));
    }
}
