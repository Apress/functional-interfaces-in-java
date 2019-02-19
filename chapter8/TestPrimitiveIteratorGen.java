package chapter8;
import java.util.*;
import java.util.function.*;
class IntIteratorGen implements PrimitiveIterator<Integer,IntConsumer>
{
    private int[] array;
    private int cursor;
    public IntIteratorGen(int... a)
    {
        cursor = 0;
        array = Arrays.copyOf(a,a.length);
    }
    @Override
    public void forEachRemaining(IntConsumer c)
    {
        while (hasNext())
        {
            c.accept(array[cursor]);
            cursor++;
        }
    }
    @Override
    public boolean hasNext() { return cursor < array.length; }




    @Override
    public Integer next() 
    { 
        int i = 0;

        if (hasNext())
        {
            i = array[cursor];  
            cursor++;
        }
        return i;
    }
}
public class TestPrimitiveIteratorGen
{
    public static void main(String[] args)
    {
        IntIteratorGen it = new IntIteratorGen(1, 2, 3, 4, 5);
        it.forEachRemaining((IntConsumer)x -> System.out.println(x));
    }
}
