package chapter2;
public class Sect5_Ex6 
{
    public static void main(String[] args)
    { 
        FIVoid LambdaOddSum = x -> {
            int oddSum = 0;
            for (int i = 0; i <= x; ++i) {
                if ( i%2 != 0)
                    oddSum += i; 
            }
            System.out.println(oddSum);
        };
        
        LambdaOddSum.method1(7);
    }
}
