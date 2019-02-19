package chapter8;
import java.util.*;
import java.util.function.*;
class DoubleIterator implements PrimitiveIterator.OfDouble
{
    private double[] array;
    private int cursor;
    public DoubleIterator(double... a)
    {
        cursor = 0;
        array = Arrays.copyOf(a,a.length);
    }
    @Override
    public boolean hasNext() { return cursor < array.length; }
    @Override
    public double nextDouble() 
    { 
        double d = 0;
        if (hasNext())
        {
            d = array[cursor];  
            cursor++;
        }
        return d;
    }
}
