package chapter12;
import java.util.stream.Stream;
public class Sect10_Ex2 
{
    public static void main(String[] args)
    {
        Stream.builder()
              .add("RED")
              .add("GREEN")
              .add("BLUE")
              .build()
              .forEach(x -> System.out.println(x));  
    }
}