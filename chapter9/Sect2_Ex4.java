package chapter9;
import java.util.function.IntFunction;
import java.util.Arrays;
public class Sect2_Ex4 
{
    public static void main(String[] args)
    {
        IntFunction<String> is = x -> {
            String s = "";
            for (int i=0; i<=x; ++i)
                s += "S";
            return s;
        };

        String[] sarr = new String[4];
        Arrays.setAll(sarr, is);
        for (String s : sarr)
            System.out.println(s);
    }
}
