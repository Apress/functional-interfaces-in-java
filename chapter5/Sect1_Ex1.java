package chapter5;
import java.util.function.UnaryOperator;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        UnaryOperator<String>  concat = x -> x + x;
        UnaryOperator<Integer> increment = x -> ++x;
        UnaryOperator<Long>    decrement = x -> --x;

        System.out.println(concat.apply("My"));	
        System.out.println(increment.apply(4));	
        System.out.println(decrement.apply(4L));	
        
        UnaryOperator<String> sident = UnaryOperator.identity();
        System.out.println(sident.apply("My"));	
    }
}
