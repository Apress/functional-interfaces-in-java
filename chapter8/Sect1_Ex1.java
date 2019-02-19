package chapter8;
import java.util.*;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        List<Car> cars = Arrays.asList(
            new Car("Nissan"   , "Sentra" ),
            new Car("Chevrolet", "Vega"   ),
            new Car("Hyundai"  , "Elantra")
        );

        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
