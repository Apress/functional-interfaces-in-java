package chapter14;
import java.util.function.BinaryOperator;
import java.util.concurrent.atomic.AtomicReference;
class IntAndString
{
    int i;
    String s;
    public IntAndString(int x, String y) { i=x; s=y; }
    @Override
    public String toString() { return i + " " + s; }
}

public class Sect5_Ex2 
{
    public static void main(String[] args)
    {
        AtomicReference<IntAndString> refis =
            new AtomicReference<>(new IntAndString(2,"HI"));
        for (int i=0; i < 5; ++i)
        {
            BinaryOperator<IntAndString> bi =
                (x,y) -> new IntAndString(x.i + y.i,null);
            System.out.println(
                refis.accumulateAndGet(new IntAndString(i,null), bi));
        }
    }
}