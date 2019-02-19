package chapter5;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        IntBinaryOperator    ibo = (x,y) -> x + y + 5;
        LongBinaryOperator   lbo = (x,y) -> (x + y)/ 3L;
        DoubleBinaryOperator dbo = (x,y) -> x * y * 0.5;
    
        System.out.println(ibo.applyAsInt(4,2));
        System.out.println(lbo.applyAsLong(9L,3L));
        System.out.println(dbo.applyAsDouble(4.0,6.0));       
    }
}
