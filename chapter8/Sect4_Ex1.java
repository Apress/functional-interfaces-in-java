package chapter8;
import java.util.*;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        List<Car> cars = Arrays.asList(
            new Car("Nissan"   , "Sentra" ),
            new Car("Chevrolet", "Vega"   ),
            new Car("Hyundai"  , "Elantra")
        );
        cars.forEach(x -> System.out.println(x));
    }
}
