package chapter4;
import java.util.function.Function;
import java.util.ArrayList;
public class NumberParser 
{
    private static <Y extends Number> Y parse(String x, 
                                              Function<String, Y> f)
    {
        return f.apply(x);
    }
    public static void main(String[] args)
    {
        ArrayList< Function<String,? extends Number> > list 
            = new ArrayList<>();
        list.add(x -> Byte.parseByte(x));
        list.add(x -> Short.parseShort(x));
        list.add(x -> Integer.parseInt(x));
        list.add(x -> Long.parseLong(x));
        list.add(x -> Float.parseFloat(x));
        list.add(x -> Double.parseDouble(x));

        String[] numbers = {"10", "20", "30", "40", "50", "60"};
        Number[] results = new Number[numbers.length];

        for (int i=0; i < numbers.length; ++i)
        {
            results[i] = parse(numbers[i], list.get(i));
            System.out.println(results[i]);
        }
    }
}
