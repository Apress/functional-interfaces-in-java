package chapter11;
import java.util.Optional;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        Optional.of("Hello")                            // Optional(Hello)
                .filter(x -> x.charAt(0) == 'H')        // Optional(Hello)
                .filter(x -> x.length() > 2)            // Optional(Hello)
                .filter(x -> x.charAt(1) == 'e')        // Optional(Hello) 
                .ifPresent(x -> System.out.println(x)); // Prints "Hello"
    }
}