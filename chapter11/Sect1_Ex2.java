package chapter11;
import java.util.Optional;
public class Sect1_Ex2 
{
    public static void main(String[] args)
    {
        Optional<String> o3 = Optional.ofNullable(null);
        System.out.println("OK");

        Optional<String> o4 = Optional.ofNullable("Hello");
        System.out.println("OK");      
    }
}