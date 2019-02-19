package chapter4;
import java.util.function.Function;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        Function<String,String> f = Function.identity();
        System.out.println(f.apply("HELLO WORLD"));
    }
}
