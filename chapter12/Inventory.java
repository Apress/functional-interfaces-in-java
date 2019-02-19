package chapter12;
import java.util.stream.*;
import java.util.*;
import java.util.function.*;
class Item
{
    String model;
    int quantity;
    double price;
    public Item(String m, int q, double p)
    {
        model = m;
        quantity = q;
        price = p;
    }

    @Override
    public String toString() 
    { 
        return model + ":" + quantity + " $" + price; 
    }
}

class Part
{
    String name;
    String manu;
    int hoursToInstall;
    List<Item> models;
    public Part(String n, String m, int h, Item... it) 
    {
        name = n;
        manu = m;
        hoursToInstall = h;
        models = new ArrayList<>();
        for (Item i : it)
            models.add(i);
    }
    @Override
    public String toString()
    {
        return manu + " " + hoursToInstall + "hrs " + models;
    }
}
public class Inventory 
{
    static String partName = null;
    static int quantity=0;
    static double price = 0.0;
    static int timeLimit = 0;

    public static void main(String[] args)
    {
        List<Part> parts = Arrays.asList(
           new Part("tires","Goodyear",2,
                  new Item("RX2041",4,75.25),
                  new Item("SX3355",2,90.50)),
           new Part("brakes","EBC",1,
                  new Item("EX8426",2,125.35)),
           new Part("tires","Firestone",1,
                   new Item("FS2112",3,60.47),
                   new Item("FS2479",5,85.20)),
           new Part("brakes","Acme",3,
                  new Item("AC25",1,90.74),
                  new Item("AC26",4,130.22))
        );
        Supplier<Integer> selectOperation = () -> {
            Scanner userInput = new Scanner(System.in);
            int operation = -1;
            while (operation < 0 || operation > 5)
            {
                System.out.println("Please select an operation:");
                System.out.println(
                        "    0 - List inventory");
                System.out.println(
                        "    1 - Find item by quantity and price");
                System.out.println(
                        "    2 - List items by price");
                System.out.println(
                        "    3 - Count items by part name");
                System.out.println(
                        "    4 - Find items by installation time");
                System.out.print  (
                        "    5 - End program:");
                operation = Integer.parseInt(userInput.nextLine());
                if (operation < 0 || operation > 5)
                    System.out.println("Invalid operation");
            }
            return operation;
        };
        Supplier<String> selectPartName = () -> 
            (new Scanner(System.in)).nextLine();
        Supplier<Integer> selectQuantity = () -> 
            Integer.parseInt((new Scanner(System.in)).nextLine());
        Supplier<Double> selectPrice = () -> 
            Double.parseDouble((new Scanner(System.in)).nextLine());
        Supplier<Integer> selectTimeLimit = () ->
            Integer.parseInt((new Scanner(System.in)).nextLine());
        
        System.out.println(
             "Welcome to Discount Dave's Inventory Program.");
        boolean done = false;
        while (!done)
        {
            switch (selectOperation.get())
            {
                case 0:
                    parts.stream()
                         .collect(Collectors.groupingBy(x -> x.name))
                         .forEach( 
                          (x,y) -> System.out.println(x + ": " + y));
                    break;
                    
                case 1:
                    System.out.print("Select a part name:");
                    partName = selectPartName.get();
                    System.out.print("Select a minimum quantity:");
                    quantity = selectQuantity.get();
                    System.out.print("Select a price limit:");
                    price = selectPrice.get();

                    parts.stream()                      
                         .filter(x -> x.name.equals(partName))
                         .peek(x -> System.out.println(
                                 x.name + " by " + x.manu + ":"))
                         .flatMap(x -> x.models.stream()) 
                         .filter(x -> x.price <= price)
                         .filter(x -> x.quantity >= quantity)
                         .forEach(x -> System.out.println(x));
                    break;
                    
                case 2:
                    System.out.print("Select a part name:");
                    partName = selectPartName.get();

                    parts.stream()                   
                         .filter(x -> x.name.equals(partName))
                         .flatMap(x -> x.models.stream())    
                         .sorted( Comparator.comparing(x -> x.price))
                         .forEach(x -> System.out.println(x));
                    break;
                    
                case 3:
                    System.out.print("Select a part name:");
                    partName = selectPartName.get();

                    Integer i = 
                      parts.stream()
                           .filter(x -> x.name.equals(partName))
                           .flatMap(x -> x.models.stream())  
                           .reduce(0,
                                  (x,z) -> x + z.quantity,
                                  (x,y) -> x += y);
                    System.out.println(i);
                    break;
                    
                case 4:
                    System.out.print("Select a part name:");
                    partName = selectPartName.get();
                    System.out.print(
                         "Select installation time limit:");
                    timeLimit = selectTimeLimit.get();

                    parts.stream()                     
                         .filter(x -> x.name.equals(partName))
                         .filter(x -> x.hoursToInstall < timeLimit)
                         .forEach(x -> System.out.println(x));
                    break;
                    
                default: // 5
                    System.out.println("Bye Bye.");
                    done = true;
            }
        }
    }
}
