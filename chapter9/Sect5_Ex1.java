package chapter9;
import java.util.function.BiFunction;
import java.util.*;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        BiFunction<String,Integer,Integer> bin =
            (k,v) -> v == null? null : v / 4;

        Map<String,Integer> map = new TreeMap<>();
        map.put("RED", 32);
        map.put("GREEN", null);
        System.out.println(map.compute("RED", bin));
        System.out.println(map.compute("GREEN", bin));
        System.out.println(map.compute("YELLOW", bin));

        System.out.println();
        map.forEach( (x,y) -> System.out.println(x + " " + y));
    }
}
