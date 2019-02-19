package chapter12;
import java.util.function.*;
import java.util.stream.Stream;
class TwoInts
{
    Integer i1;
    Integer i2;
    public TwoInts(int z1, int z2) { i1=z1; i2=z2;}
}

public class Sect8_Ex2 
{
    public static void main(String[] args)
    {
        Stream<TwoInts> two = Stream.of(new TwoInts(1,2),new TwoInts(8,9));

        BiFunction<Integer,TwoInts,Integer> accumulator = (x,y) -> x + y.i2;

        BinaryOperator<Integer> combiner = (x,y) -> x += y;
        Integer j = two.reduce(0,accumulator,combiner);
        System.out.println(j); 
    }
}