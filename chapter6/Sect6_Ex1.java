package chapter6;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ObjDoubleConsumer;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        ObjIntConsumer<String> oic    = (x,y) -> 
            System.out.println(x + " = " + y);
        ObjLongConsumer<String> olc   = (x,y) -> 
            System.out.println(Long.parseLong(x) + y);
        ObjDoubleConsumer<String> odc = (x,y) -> 
            System.out.println(x + (new Double(y)).toString());
        
        oic.accept("Value", 4);
        olc.accept("7", 2L);
        odc.accept("DBL", 4.1);
    }
}
