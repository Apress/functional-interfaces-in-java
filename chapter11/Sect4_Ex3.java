package chapter11;
import java.util.Optional;
public class Sect4_Ex3 
{
    public static void main(String[] args)
    {
        try {
            String s = null;
            String opt = Optional.ofNullable(s)
                                 .orElseThrow();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}