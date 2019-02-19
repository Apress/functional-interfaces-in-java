package chapter12;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class Sect3_Ex4 
{
    public static void main(String[] args)
    {
        Predicate<String> isRed = x -> x.equals("RED");

        Stream.of("RED", "GREEN", "BLUE", "RED")
              .filter(isRed.or(x -> x.indexOf("R") > -1))
              .forEach(x -> System.out.println(x));     
    }
}