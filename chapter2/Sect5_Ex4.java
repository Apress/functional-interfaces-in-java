package chapter2;
public class Sect5_Ex4 
{
    public static void main(String[] args)
    {
        int z = 2;
        FIVoid LambdaLocalGood = x -> { 
            int y =4;                   // OK
            System.out.println(x + y);
        };

        LambdaLocalGood.method1(8);
    }
}
