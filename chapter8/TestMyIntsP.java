package chapter8;
import java.util.*;
import java.util.function.*;
class MyIntsP implements Iterable<Integer>
{
    private int[] array;


    public MyIntsP(int... a)
    {
        array = Arrays.copyOf(a,a.length);
    }
    public PrimitiveIterator.OfInt iterator() 
    {
        return new IntIterP();
    }

    private class IntIterP implements PrimitiveIterator.OfInt
    {
        int cursor;
        public IntIterP()
        {
            cursor = 0;
        }
        @Override
        public boolean hasNext() { return cursor < array.length; }
 


        @Override
        public int nextInt() 
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

public class TestMyIntsP
{
    public static void main(String[] args)
    {
        MyIntsP my = new MyIntsP(1, 2, 3, 4, 5);
        my.forEach(x -> System.out.println(x));
    }
}
