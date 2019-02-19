package chapter10;
import static chapter10.Sect1_Ex1.removeVowels;
import java.util.*;
public class Sect9_Ex2 
{
    public static void main(String[] args)
    {
        Comparator<String> byConsonants = (x,y) ->
                removeVowels(x).compareTo(removeVowels(y));

        TreeMap<String,String> pets = new TreeMap<>(byConsonants);

        pets.put("gerbil", "small cute rodents");
        pets.put("guinea pig", "rodents, not pigs");
        pets.put("cat", "have nine lives");
        pets.put("chicken", "more populous than people");
        
        Comparator<Map.Entry<String,String>> cmap =
            Map.Entry.comparingByKey();
        
        Map.Entry<String,String> cat = pets.ceilingEntry("cat");
        Map.Entry<String,String> chicken = pets.ceilingEntry("chicken");

        System.out.println(cmap.compare(cat, chicken));
    }
}