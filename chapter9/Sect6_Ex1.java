package chapter9;
import java.util.function.BiFunction;
import java.util.*;
class MyClass
{
    int i1;
    int i2;
    String s;
    public MyClass(int x, int y, String z)
    {
        i1 = x;
        i2 = y;
        s  = z;
    }
    @Override
    public String toString() { return i1 + " " + i2 + " " + s; }
}
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {        
        Map<String,MyClass> m = new TreeMap<>();
        m.put("k1",new MyClass(1, 2, "Dog"));

        BiFunction<MyClass,MyClass,MyClass> changeI2 =
            (ov,nv) -> new MyClass(ov.i1, nv.i2, ov.s);

        BiFunction<MyClass,MyClass,MyClass> changeS =
            (ov,nv) -> new MyClass(ov.i1, ov.i2, nv.s);

        System.out.println(m.merge("k1", new MyClass(0, 5, null  ),
                                   changeI2));
        System.out.println(m.merge("k1", new MyClass(0, 0, "Cat" ),
                                   changeS));
        System.out.println(m.merge("k2", new MyClass(6, 7, "Bird"),
                                   changeS));

        System.out.println();
        m.forEach( (x,y) -> System.out.println(x + " " + y));
    }
}