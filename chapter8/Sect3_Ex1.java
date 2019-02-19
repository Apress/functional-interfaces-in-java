package chapter8;
import java.util.*;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {
        List<Car> cars = Arrays.asList(
            new Car("Nissan", "Sentra"),
            new Car("Chevrolet", "Vega"),
            new Car("Hyundai"  , "Elantra"),
            new Car("Buick"    , "Regal")
        );

        Spliterator<Car> firstHalf = cars.spliterator();
        Spliterator<Car> secondHalf = firstHalf.trySplit();

        firstHalf.forEachRemaining (x -> 
                          System.out.println("In 1st half: " + x));
        secondHalf.forEachRemaining(x -> 
                          System.out.println("In 2nd half: " + x));        
    }
}
