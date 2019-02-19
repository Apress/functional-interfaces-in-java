package chapter11;
import java.util.Optional;
public class Sect7_Ex1 
{
    public static void main(String[] args)
    {
        Optional.of("4")                                // Optional("4")
                .map(x -> Integer.parseInt(x))          // Optional(4)
                .filter(x -> x > 2)                     // Optional(4)
                .filter(x -> (x%2) == 0)                // Optional(4)
                .ifPresent(x -> System.out.println(x)); // Prints 4
    }
}