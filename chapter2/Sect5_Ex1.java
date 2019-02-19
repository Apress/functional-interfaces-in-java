package chapter2;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        FIVoid LambdaBlock = x -> {
            x++;
            System.out.println(x);
        };

        LambdaBlock.method1(5);      
    }
}
