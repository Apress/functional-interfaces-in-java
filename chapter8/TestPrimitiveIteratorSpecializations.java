package chapter8;
import java.util.function.*;
public class TestPrimitiveIteratorSpecializations 
{
    public static void main(String[] args)
    {
        IntIterator iit = new IntIterator(1, 2, 3, 4, 5);

        iit.forEachRemaining((IntConsumer)x -> 
                             System.out.println(x));
        
        System.out.println();
        LongIterator lit = new LongIterator(6, 7, 8, 9, 10);
        lit.forEachRemaining((LongConsumer)x ->
                             System.out.println(x));
        
        System.out.println();
        DoubleIterator dit = new DoubleIterator(
                                 20.1, 21.2, 22.3, 23.4, 24.5);
        dit.forEachRemaining((DoubleConsumer)x ->
                             System.out.println(x));
    }
}
