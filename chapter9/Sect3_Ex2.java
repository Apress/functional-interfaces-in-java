package chapter9;
import java.util.function.BiFunction;
import java.util.*;
public class Sect3_Ex2 
{
    public static void main(String[] args)
    {
        Map<String,String> map = new TreeMap<>();
        map.put("Smith", "Robert");
        map.put("Jones", "Alex");
        BiFunction<String,String,String> bi = (k,v) -> "Mr. " + v;
        
        map.replaceAll(bi);
        map.forEach( (x,y) -> System.out.println(y + " " + x));
        
    }
}
