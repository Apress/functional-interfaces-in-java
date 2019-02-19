package chapter2;
public class Sect5_Ex7 
{
    public static void main(String[] args)
    {
        int[] array = {11,12,13,14,15};
        FIVoid LambdaSubscript = x -> {
            try {
                int value = array[x];
                System.out.println(value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + x + " is out of bounds.");
            }
        };
        
        LambdaSubscript.method1(5);
        LambdaSubscript.method1(4);
    }
}
