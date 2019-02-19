package chapter9;
import java.util.function.IntToDoubleFunction;
import java.util.*;
public class Sect2_Ex3 
{
    public static void main(String[] args)
    {
        IntToDoubleFunction i2d = x -> (new Random()).nextFloat();
        double[] darr = new double[4];
        Arrays.setAll(darr, i2d);
        for (double d : darr)
            System.out.println(d);
    }
}
