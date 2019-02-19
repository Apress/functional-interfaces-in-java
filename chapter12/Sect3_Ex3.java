package chapter12;
import java.util.stream.Stream;
public class Sect3_Ex3 
{
    public static void main(String[] args)
    {
        Stream.of("RED", "GREEN", "BLUE", "RED")
              .filter(x -> x.equals("RED"))
              .forEach(x -> System.out.println(x));   
    }
}