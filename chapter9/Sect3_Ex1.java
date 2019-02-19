package chapter9;
import java.util.function.UnaryOperator;
import java.util.*;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(16,12,8,4);
        UnaryOperator<Integer> div4 = x -> x / 4;

        list.replaceAll(div4);
        list.forEach(x -> System.out.println(x));
    }
}
