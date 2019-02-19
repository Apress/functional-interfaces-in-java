package chapter8;
import java.util.*;
import java.util.function.*;
class LongIterator implements PrimitiveIterator.OfLong
{
    private long[] array;
    private int cursor;
    public LongIterator(long... a)
    {
        cursor = 0;
        array = Arrays.copyOf(a,a.length);
    }
    @Override
    public boolean hasNext() { return cursor < array.length; }
    @Override
    public long nextLong() 
    { 
        long l = 0;
        if (hasNext())
        {
            l = array[cursor];  





            cursor++;
        }
        return l;
    }
}
