package chapter10;
import java.util.Comparator;
public class Sect1_Ex3 
{
    public static void main(String[] args)
    {
        Comparator<Integer> byIntDifference = (x,y) -> x - y;   
        
        System.out.println(byIntDifference.compare(1000,1002));
    }
}
