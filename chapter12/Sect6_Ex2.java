package chapter12;
import static chapter10.Sect1_Ex1.removeVowels;
import java.util.stream.Stream;
public class Sect6_Ex2 
{
    public static void main(String[] args)
    {
        Stream.of("Kyle", "Jaquiline", "Jimmy")
              .max( (x,y) ->                              // Stream<String>
                removeVowels(x).compareTo(removeVowels(y)))
              .ifPresent(x -> System.out.println(x));     // Optional<String>
    }
}