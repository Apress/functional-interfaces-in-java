package chapter10;
import java.util.Comparator;
import java.util.function.BinaryOperator;
public class Sect10_Ex1 
{
    public static void main(String[] args)
    {
        Comparator<Integer> abscompare = 
            Comparator.comparing(x -> Math.abs(x));

        BinaryOperator<Integer> bigint   =
            BinaryOperator.maxBy(abscompare);
        BinaryOperator<Integer> smallint =
            BinaryOperator.minBy(abscompare);

        System.out.println(bigint.apply(2,-5));
        System.out.println(smallint.apply(2,-5));
    }
}