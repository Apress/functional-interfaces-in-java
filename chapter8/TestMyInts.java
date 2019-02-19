package chapter8;
import java.util.*;
import java.util.function.*;
class MyInts implements Iterable<Integer>
{
    private int[] array;
    public MyInts(int... a)
    {
        array = Arrays.copyOf(a,a.length);
    }
    public PrimitiveIterator<Integer,IntConsumer> iterator() 
    {
        return new IntIter();
    }

    private class IntIter implements
           PrimitiveIterator<Integer,IntConsumer>
    {
        private int cursor;
        public IntIter()
        {
            cursor = 0;
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
}

public class TestMyInts
{
    public static void main(String[] args)
    {
        MyInts my = new MyInts(1, 2, 3, 4, 5);
        my.forEach(x -> System.out.println(x));
        System.out.println();
        my.iterator().forEachRemaining((IntConsumer)x ->
              System.out.println(x));
    }
}
