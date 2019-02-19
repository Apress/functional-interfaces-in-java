package chapter12;
import java.util.stream.Stream;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {        
        Stream.of("RED", "GREEN", "BLUE", "RED")
              .filter(x -> x.equals("YELLOW"))
              .forEach(x -> System.out.println(x));
    }
}