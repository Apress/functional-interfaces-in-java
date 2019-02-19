package chapter4;
import java.util.function.Function;
public class Transformer 
{
    private static <X,Y> Y transform(X x, Function<X, Y> f)
    {
        return f.apply(x);
    }

    public static void main(String[] args)
    {
        Function<String , Integer> fsi = x -> Integer.parseInt(x);
        Function<Integer, String>  fis = x -> Integer.toString(x);

        Integer i = transform("100", fsi);
        String  s = transform(200  , fis);
        System.out.println(i);
        System.out.println(s);
    }
}
