package chapter7;
import java.util.function.Supplier;
import java.util.Random;
import java.util.Scanner;
public class TestSupplier 
{
    public static void main(String[] args)
    {
        Supplier<Integer> generateInteger = () -> 
        {
            Random rand = new Random();
            return rand.nextInt(100);
        };
        Supplier<String> generateString = () ->
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a string:");
            return scan.nextLine();
        };

        System.out.println(generateInteger.get());
        System.out.println(generateInteger.get());
        System.out.println(generateString.get());
        System.out.println(generateString.get());
    }
}
