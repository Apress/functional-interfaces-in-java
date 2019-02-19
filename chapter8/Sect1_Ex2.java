package chapter8;
import java.util.*;
public class Sect1_Ex2 
{
    public static void main(String[] args)
    {
        List<Car> cars = Arrays.asList(
            new Car("Nissan"   , "Sentra" ),
            new Car("Chevrolet", "Vega"   ),
            new Car("Hyundai"  , "Elantra")
        );

        cars.iterator().forEachRemaining(x -> System.out.println(x));
    }
}
