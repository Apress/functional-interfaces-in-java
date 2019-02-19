package chapter13;
import java.io.*;
import java.util.concurrent.Callable;
public class Sect1_Ex4 
{
    public static void main(String[] args)
    {
        Callable<String> c2 = () -> {
            BufferedReader br = new BufferedReader(
                                     new FileReader("my.txt"));
            return br.readLine();
        };
        try {
            String s1 = c2.call();
            System.out.println(s1);
        } catch (Exception e) { System.out.println(e.getClass());}
    }
}