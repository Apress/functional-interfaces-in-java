package chapter4;
import java.util.function.Function;
import java.util.function.BiFunction;
public class Sect9_Ex1 
{
    public static void main(String[] args)
    {
        BiFunction<Integer,Character,String> bi = (x, z) -> {
            if (Character.isUpperCase(z))
                return (x%2)==0? "EVEN" : "ODD";
            return (x%2)==0? "even" : "odd";
        };

        Function<String,Double> bi2 = x -> 
            x.equalsIgnoreCase("even")? 3.0 : 4.0;

        Double d = bi.andThen(bi2)  // Function<String,Double>
                     .apply(4,'U'); // BiFunction<Integer,Character,String>

        System.out.println(d);	 
    }
}
