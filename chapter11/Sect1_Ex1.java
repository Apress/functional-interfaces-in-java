package chapter11;
import java.util.Optional;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {        
        try {
            Optional<String> o1 = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        Optional<String> o2 = Optional.of("Hello");
        System.out.println("OK");
    }
}