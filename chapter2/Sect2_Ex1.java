package chapter2;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        StringProcessor lambdaSP = x -> x;
        System.out.println(lambdaSP.process("Hello"));
    }
}
