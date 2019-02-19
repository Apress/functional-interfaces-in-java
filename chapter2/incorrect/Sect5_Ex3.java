package chapter2.incorrect;
public class Sect5_Ex3 
{
    public static void main(String[] args)
    {
        int z = 2;
        FIVoid LambdaLocalBad = x -> {
            int z =4;                   // ERROR: z already defined 
            System.out.println(x + z);
        };
    }
}
