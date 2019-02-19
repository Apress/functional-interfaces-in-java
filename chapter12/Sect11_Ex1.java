package chapter12;
import java.util.stream.Stream;
public class Sect11_Ex1 
{
    public static void main(String[] args)
    {
        Stream.of(1,2,3,4)
              .peek(x -> System.out.println(x) )
              .reduce( (x,y) -> x += y)
              .ifPresent(x -> System.out.println(x));         
    }
}