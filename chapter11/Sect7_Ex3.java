package chapter11;
import java.util.Optional;
public class Sect7_Ex3 
{
    public static void main(String[] args)
    {
        Optional.of(2)                                  // Optional(2)
                .map(x -> ++x)			          // Optional(3)		
                .ifPresent(x -> System.out.println(x)); // Prints 3
    }
}