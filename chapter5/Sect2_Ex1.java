package chapter5;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.DoubleUnaryOperator;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        IntUnaryOperator    iuo = x -> x + 5;
        LongUnaryOperator   luo = x -> x / 3L;
        DoubleUnaryOperator duo = x -> x * 2.1;

        System.out.println(iuo.applyAsInt(4));		
        System.out.println(luo.applyAsLong(9L));		
        System.out.println(duo.applyAsDouble(4.1));	
    }
}
