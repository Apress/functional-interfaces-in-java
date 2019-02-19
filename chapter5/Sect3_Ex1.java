package chapter5;
import java.util.function.BinaryOperator;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {
        BinaryOperator<String>  concat   = (x,y) -> x + y;
        BinaryOperator<Integer> subtract = (x,y) -> x - y;
        BinaryOperator<Long>    multiply = (x,y) -> x * y;

        System.out.println(concat.apply("AB", "CD"));
        System.out.println(subtract.apply(4, 1));
        System.out.println(multiply.apply(4L, 3L)); 
    }
}
