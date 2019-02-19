package chapter12;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;
public class Sect9_Ex1 
{
    public static void main(String[] args)
    {
        Supplier<List<Character>> supp = () -> new ArrayList<Character>();
        BiConsumer<List<Character>, Character> acc = (x,y) -> {
            System.out.print("acc: x=" + x + " y=" + y+ " result=");
            if (Character.isAlphabetic(y))
               x.add(0,y);
            else
               x.add(y);
            x.forEach(z -> System.out.print(z));
            System.out.println();
        };
        
        BinaryOperator<List<Character>> comb1 = (x,y) -> {
            x.addAll(y); 
            return x; 
        };
        
        Stream.of('1','a','b','2')                     // Stream<Character>
              .collect(Collector.of(supp, acc, comb1)) // List<Character>
              .forEach(x -> System.out.println(x));
    }
}