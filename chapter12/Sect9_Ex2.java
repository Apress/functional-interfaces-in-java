package chapter12;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;
public class Sect9_Ex2
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
        
        BiConsumer<List<Character>,List<Character>> comb2 = (x,y) -> 
                      x.addAll(y);
        
        Stream.of('1','a','b','2')
              .collect(supp, acc, comb2)
              .forEach(x -> System.out.println(x));
    }
}