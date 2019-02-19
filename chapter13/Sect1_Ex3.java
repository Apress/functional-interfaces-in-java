package chapter13;
import java.util.concurrent.Callable;
public class Sect1_Ex3 
{
    public static void main(String[] args)
    {
        Callable<String> c1 = () -> "GREEN";
        
        try {
            String s1 = c1.call();
            System.out.println(s1);
        } catch (Exception e) {}
    }
}