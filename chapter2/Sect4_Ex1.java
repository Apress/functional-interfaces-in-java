package chapter2;
@FunctionalInterface
interface FI2 
{
    String method1(String x, int y);
}

public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        FI2 FI2Lambda1 = (a, b) -> a + Integer.toString(b);
        FI2 FI2Lambda2 = (String c, int d) -> c + Integer.toString(d+1);

        System.out.println(FI2Lambda1.method1("Hello",1));
        System.out.println(FI2Lambda2.method1("Hello",1));        
    }
}
