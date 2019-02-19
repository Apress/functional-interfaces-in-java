package chapter2;
public class TestLambdaScope
{
    private static int myField = 2;
    public static void main(String[] args)
    {
        int myLocal = 7;
        FIVoid lambdaVoid = x -> System.out.println(
                                   x + myField + myLocal);
        
        lambdaVoid.method1(5);
    }
}
