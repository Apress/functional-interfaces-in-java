package chapter7;
import java.util.function.*;
import java.util.Random;
public class TestSpecials 
{
    public static Random rand = new Random();
    public static void main(String[] args)
    {
        BooleanSupplier genBol = () -> 
            (rand.nextInt(2) == 1)? true:false;
        IntSupplier     genInt = () -> rand.nextInt();
        LongSupplier    genLng = () -> rand.nextLong();
        DoubleSupplier  genDbl = () -> rand.nextDouble();
        
        System.out.println(genBol.getAsBoolean());
        System.out.println(genInt.getAsInt());
        System.out.println(genLng.getAsLong());
        System.out.println(genDbl.getAsDouble());
    }
}
