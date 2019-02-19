package chapter6;
import java.util.function.Consumer;
public class ComputePolynomial
{
    private static int fx = 0;
    public static void main(String[] args)
    {
        Consumer<Integer> poly = x -> fx += 5 * (int)Math.pow(x, 4);

        poly.andThen(x -> fx += 7 * (int)Math.pow(x, 3))
            .andThen(x -> fx += 4 * (int)Math.pow(x, 2))
            .andThen(x -> fx += 3 * x)
            .andThen(x -> fx += 8)
            .andThen(x -> System.out.println(fx))
            .accept(2);
    }
}
