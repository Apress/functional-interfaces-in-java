package chapter12;
import java.util.Optional;
public class Sect4_Ex2 
{
    public static void main(String[] args)
    {    
        Optional.of("RED")
                .stream()
                .forEach(x -> System.out.println(x));
    }
}