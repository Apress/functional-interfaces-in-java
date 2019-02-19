package chapter12;
import java.util.stream.*;
public class Sect9a_Ex1 
{
    public static void main(String[] args)
    {
        Stream.of('1', 'a' , 'b', '2')
              .collect(Collectors.toList())
              .forEach(x -> System.out.println(x));    
    }
}