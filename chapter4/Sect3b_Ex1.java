package chapter4;
import java.util.function.Function;
public class Sect3b_Ex1 
{
    public static void main(String[] args)
    {
        Function<Boolean, Integer> fbi = x -> x==true? 1:0;
        Function<String, Boolean>  fsb = x -> Boolean.parseBoolean(x);
        System.out.println(fbi.compose(fsb)    // Function<String, Boolean>
                              .apply("true")); // Function<Boolean, Integer>
    }
}
