package chapter9;
import java.util.function.IntUnaryOperator;
import java.util.Arrays;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        IntUnaryOperator iop = x -> x;
        int[] iarr = new int[4];
        Arrays.setAll(iarr, iop);
        for (int i : iarr)
            System.out.println(i);
    }
}
