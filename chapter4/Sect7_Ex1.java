package chapter4;
import java.util.function.*;
public class Sect7_Ex1 
{
    public static void main(String[] args)
    {
        DoubleToIntFunction  di = x -> (new Double(x)).intValue();
        DoubleToLongFunction dl = x -> (new Double(x)).longValue();
        IntToDoubleFunction  id = x -> (new Integer(x)).doubleValue();
        IntToLongFunction    il = x -> (new Integer(x)).longValue();
        LongToDoubleFunction ld = x -> (new Long(x)).doubleValue();
        LongToIntFunction    li = x -> (new Long(x)).intValue();
        
        System.out.println(di.applyAsInt(4.1));	
        System.out.println(dl.applyAsLong(5.2));	
        System.out.println(id.applyAsDouble(6));	
        System.out.println(il.applyAsLong(7));
        System.out.println(ld.applyAsDouble(8));
        System.out.println(li.applyAsInt(9));	
    }
}
