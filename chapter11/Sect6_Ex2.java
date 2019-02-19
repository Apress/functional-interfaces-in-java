package chapter11;
import java.util.Optional;
public class Sect6_Ex2 
{
    public static void main(String[] args)
    {
        Optional.of("Hello")                            // Optional(Hello)
                .filter(x -> x.charAt(0) == 'i')        // Optional(null)
                .filter(x -> x.length() > 2)            // doesn’t execute
                .filter(x -> x.charAt(1) == 'e')        // doesn’t execute
                .ifPresent(x -> System.out.println(x)); // doesn’t execute
    }
}