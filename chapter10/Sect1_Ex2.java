package chapter10;
import java.util.Comparator;
public class Sect1_Ex2 
{
    public static void main(String[] args)
    {
        Comparator<Integer> byIntCompareTo = (x,y) -> x.compareTo(y);   

        System.out.println(byIntCompareTo.compare(1000,1002));
    }
}
