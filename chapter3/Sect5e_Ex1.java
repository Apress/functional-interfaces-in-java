package chapter3;
import java.util.function.Predicate;
public class Sect5e_Ex1 
{
    public static void main(String[] args)
    {
        Predicate<Integer> p1 = x -> x > 7;
        System.out.println(p1.and(Predicate.not(x -> x%2 == 1))
                             .test(8) );
    }
}
