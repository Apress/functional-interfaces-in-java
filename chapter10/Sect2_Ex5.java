package chapter10;
import static chapter10.Sect1_Ex1.removeVowels;
import java.util.Comparator;
public class Sect2_Ex5 
{
    public static void main(String[] args)
    {
        Comparator<String> byConsonants = (x,y) -> 
                  removeVowels(x).compareTo(removeVowels(y));
        
        System.out.println(byConsonants.reversed()
                                       .compare("Larry", "Libby"));
    }
}
