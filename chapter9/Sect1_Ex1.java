package chapter9;
import java.util.*;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Super");
        list.add("Random");
        list.add("Silly");
        list.add("Strings");
        
        list.removeIf(x -> x.charAt(0) == 'S');
        list.forEach(x -> System.out.println(x));
    }
}
