package chapter12;
import java.util.function.*;
import java.util.stream.*;
public class Sect9_Ex3 
{
    public static void main(String[] args)
    {
        Supplier<StringBuilder> supps = () -> new StringBuilder();
        BiConsumer<StringBuilder,String> accs = (x,y) -> 
                  x.append(y.replaceAll("[aeiou]",""));

        BinaryOperator<StringBuilder> combs = (x,y) -> {
            x.append(y); 
            return x; 
        };
        
        Function<StringBuilder,String> fins = x -> x.toString();
        
        String s = Stream.of("Joe","Kalpana","Christopher")
                         .collect(Collector.of(supps, accs, combs, fins));
        System.out.println(s);       
    }
}