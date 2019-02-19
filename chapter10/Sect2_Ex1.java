package chapter10;
import java.util.Comparator;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        Comparator<String> natural = Comparator.naturalOrder();
        
        System.out.println(natural.compare("Larry", "Libby"));
    }
}
