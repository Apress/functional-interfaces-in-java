package chapter9;
import java.util.function.BiFunction;
import java.util.*;
public class Sect5_Ex2 
{
    public static void main(String[] args)
    {
        BiFunction<String,Integer,Integer> bi = (k,v) -> v / 4;

        Map<String,Integer> map = new TreeMap<>();
        map.put("RED", 8);
        map.put("GREEN", null);
        System.out.println(map.computeIfPresent("RED", bi));
        System.out.println(map.computeIfPresent("GREEN", bi));
        System.out.println(map.computeIfPresent("YELLOW", bi));
        
        System.out.println();
        map.forEach( (x,y) -> System.out.println(x + " " + y));
    }
}
