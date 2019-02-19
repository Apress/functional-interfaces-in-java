package chapter12;
import java.util.stream.*;
public class Sect12_Ex1 
{
    public static void main(String[] args)
    {
        IntStream ints =
            Stream.of(new Car("Buick"  ,"Regal"  ,25),
                      new Car("Hyundai","Elantra",27),
                      new Car("Buick"  ,"Skylark",26), 
                      new Car("Hyundai","Accent" ,30))  // Stream<Car>
                  .mapToInt(x -> x.mpg);                // IntStream

        ints.max()
            .ifPresent(x -> System.out.println(x));     

        LongStream.of(1,2,3,4)
                  .min()
                  .ifPresent(x -> System.out.println(x)); 
    }
}