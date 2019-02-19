package chapter12;
import java.util.stream.Stream;
public class Sect8_Ex1 
{
    public static void main(String[] args)
    {
        Stream.of(1, 2, 3, 4, 5)                      // Stream(Integer)
              .reduce( (x,y) -> x * y)                // Optional(Integer)
              .ifPresent(x -> System.out.println(x)); // Prints 120      
    }
}