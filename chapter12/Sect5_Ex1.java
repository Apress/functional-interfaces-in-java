package chapter12;
import java.util.stream.Stream;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        Stream.of("Kyle", "Jaquiline", "Jimmy")
              .sorted()
              .forEach(x -> System.out.println(x));   
    }
}