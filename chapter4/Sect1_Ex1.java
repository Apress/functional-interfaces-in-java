package chapter4;
import java.util.function.Function;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        Function<String, Integer> f;
        f = x -> Integer.parseInt(x);
        
        Integer i = f.apply("100");
        System.out.println(i);
    }
}
