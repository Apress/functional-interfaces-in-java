package chapter11;
import java.util.Optional;
public class Sect3_Ex2 
{
    public static void main(String[] args)
    {
        Optional<String> o4 = Optional.ofNullable("Hello");
        Optional<String> o5 = Optional.empty();
 
        if (o4.isPresent())
            System.out.println(o4.get());
        if (o5.isPresent())
            System.out.println(o5.get());
        else
            System.out.println("o5 is null");
    }
}