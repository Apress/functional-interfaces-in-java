package chapter6;
import java.util.function.Consumer;
public class TestConsumerAndThen 
{
    private static int sum  = 0;
    private static int prod = 1;
    public static void main(String[] args)
    {
        Consumer<Integer> consum  = x -> sum  += x;
        Consumer<Integer> conprod = x -> prod *= x;

        consum.andThen(conprod)
              .accept(4);
        consum.andThen(conprod)
              .accept(5);
        
        System.out.println("sum = " + sum + " prod =" + prod);
    }
}
