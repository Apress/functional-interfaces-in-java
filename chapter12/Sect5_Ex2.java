package chapter12;
import static chapter10.Sect1_Ex1.removeVowels;
import java.util.stream.Stream;
public class Sect5_Ex2 
{
    public static void main(String[] args)
    {
        Stream.of("Kyle", "Jaquiline", "Jimmy")
              .sorted( (x,y) -> 
                  removeVowels(x).compareTo(removeVowels(y)))
              .forEach(x -> System.out.println(x));
    }
}