package chapter4;
import java.util.function.Function;
public class Sect3a_Ex1 
{
    public static void main(String[] args)
    {        
        Function<String, Boolean> fsb = x -> Boolean.parseBoolean(x);
        System.out.println(
            fsb.andThen(x -> x==true? 1:0) // Function<Boolean, Integer>
               .apply("true"));            // Function<String, Boolean>
    }
}
