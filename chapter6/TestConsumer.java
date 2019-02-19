package chapter6;
import java.util.function.Consumer;
public class TestConsumer 
{
    private static int sum = 0;
    public static void main(String[] args)
    {
        Consumer<Integer> con = x -> sum += x;
        con.accept(4);
        con.accept(5);
        System.out.println(sum);
    }
}
