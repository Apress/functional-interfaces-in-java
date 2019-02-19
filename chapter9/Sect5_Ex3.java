package chapter9;
import java.util.function.Function;
import java.util.*;
public class Sect5_Ex3 
{
    public static void main(String[] args)
    {
        Function<String,Integer> fi = v -> v.length();

        Map<String,Integer> map = new TreeMap<>();
        map.put("RED", 2);
        map.put("GREEN", null);
        System.out.println(map.computeIfAbsent("RED", fi));
        System.out.println(map.computeIfAbsent("GREEN", fi));
        System.out.println(map.computeIfAbsent("YELLOW", fi));
        
        System.out.println();
        map.forEach( (x,y) -> System.out.println(x + " " + y));
    }
}
