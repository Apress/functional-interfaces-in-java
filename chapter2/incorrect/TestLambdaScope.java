package chapter2.incorrect;
public class TestLambdaScope 
{
    private static int myField = 2;
    public static void main(String[] args)
    {
        int myLocal = 7;
        myLocal++;

        FIVoid lambdaVoid 
           = x -> System.out.println(             // ERROR: local variables used
                          x + myField + myLocal); //        in lambdas must be
                                                  //        final or effectively
                                                  //        final        
    } 
}
