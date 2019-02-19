package chapter11;
import java.util.Optional;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {        
        Optional<String> o5 = Optional.empty();

        if (o5.isPresent())
            System.out.println("o4 is non-null");
    }
}