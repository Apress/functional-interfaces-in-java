package chapter11;
import java.util.function.Supplier;
import java.util.*;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        Supplier<Optional<String> > supplier = () -> {
            System.out.print("Enter a string:");
            return Optional.of((new Scanner(System.in)).nextLine());
        };
        
        String s = null;
        Optional.ofNullable(s)
                .or(supplier)
                .ifPresent(x -> System.out.println(x));
    }
}