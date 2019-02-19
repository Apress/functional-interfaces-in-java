package chapter11;
import java.util.Optional;
public class Sect7_Ex2 
{
    public static void main(String[] args)
    {
        Optional<Integer> o1 = Optional.of(2);
        o1.ifPresent(x -> ++x);
        o1.ifPresent(x -> System.out.println(x)); // Prints 2        
    }
}