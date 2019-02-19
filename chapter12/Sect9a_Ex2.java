package chapter12;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;
public class Sect9a_Ex2 
{
    public static void main(String[] args)
    {
        Supplier<List<Character>> supp = () -> new ArrayList<Character>();

        BinaryOperator<List<Character>> comb1 = (x,y) -> {
            x.addAll(y); 
            return x; 
        };

        BiConsumer<List<Character>,Character> accc2 = (x,y) -> {
            if (Character.isAlphabetic(y))
               x.add(0,y);
            else
               x.add(y);
        };

        Function<List<Character>,String> fins2 = x -> {
            String t=""; 
            for (Character c : x)
                t += c;
            return t;
        };
        
        String t = 
          Stream.of('1','a','b','2')                     // Stream<Character>
                .collect(Collectors.collectingAndThen(
                       Collector.of(supp, accc2, comb1), // List<Character>
                       fins2));                          // String
        System.out.println(t);                           // Prints ba12
    }
}