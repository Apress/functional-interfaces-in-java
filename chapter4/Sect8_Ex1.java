package chapter4;
import java.util.function.BiFunction;
public class Sect8_Ex1 
{
    public static void main(String[] args)
    {
        BiFunction<Integer,Character,String> bi = (x, z) -> {
            if (Character.isUpperCase(z))
                return (x%2)==0? "EVEN" : "ODD";
            return (x%2)==0? "even" : "odd";
        };

        System.out.println(bi.apply(4,'U'));	
    }
}
