package chapter12;
import java.util.stream.IntStream;
public class Sect12_Ex3 
{
    public static void main(String[] args)
    {
        int sum = IntStream.of(1,2,3,4)
                           .sum();
        System.out.println(sum);    
    }
}