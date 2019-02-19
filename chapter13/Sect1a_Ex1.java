package chapter13;
import java.util.Optional;
public class Sect1a_Ex1 
{
    public static void main(String[] args)
    {
        String s = null;
        Optional.ofNullable(s)
                .ifPresentOrElse(x  -> System.out.println(x),
                                 () -> System.out.println("empty"));                                                
    }
}