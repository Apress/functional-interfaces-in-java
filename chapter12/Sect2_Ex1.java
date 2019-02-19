package chapter12;
import java.util.stream.Stream;
import java.util.Random;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {        
        Stream<Integer> tenRandomNumbers =
            Stream.generate( () -> (new Random()).nextInt(100))
                  .limit(10);
        
        tenRandomNumbers.forEach(x -> System.out.println(x));
    }
}