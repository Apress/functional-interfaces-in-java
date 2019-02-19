package chapter7;
import java.util.function.Supplier;
import java.util.Scanner;
public class Sect2_Ex1 
{
    public static void main(String[] args)
    {
        Supplier<Integer> selectOperation = () -> {        
            int operation = 0;
            Scanner userInput = new Scanner(System.in);
            
            while (operation < 1 || operation > 4)
            {
                System.out.println("Select an operation:");
                System.out.println("    1: Operation 1");
                System.out.println("    2: Operation 2");
                System.out.println("    3: Operation 3");
                System.out.println("    4: Quit");
                operation = Integer.parseInt(userInput.nextLine());
                if (operation < 1 || operation > 4)
                    System.out.println("Invalid operation");
            }
            return operation;
        };

        boolean done = false;
        while (!done)
        {
            switch (selectOperation.get())
            {
                case 1:  System.out.println("Performing Operation 1");
                         break;
                case 2:  System.out.println("Performing Operation 2");
                         break;
                case 3:  System.out.println("Performing Operation 3");
                         break;
                default: done = true;
            }
        }
    }
}
