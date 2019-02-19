package chapter11;
import java.util.Optional;
public class Sect7_Ex4 
{
    public static void main(String[] args)
    {        
        Optional.of("4")                                 // Optional("4")
                .flatMap(x -> 
                     Optional.of(Integer.parseInt(x)))   // Optional(4)
                .ifPresent(x -> System.out.println(x));  // Prints 4
    }
}