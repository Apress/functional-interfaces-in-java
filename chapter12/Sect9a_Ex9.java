package chapter12;
import java.util.stream.*;
public class Sect9a_Ex9 
{
    public static void main(String[] args)
    {
        Integer sum =
            Stream.of(new Car("Buick"  ,"Regal"  ,25),
                      new Car("Hyundai","Elantra",27),
                      new Car("Buick"  ,"Skylark",26), 
                      new Car("Hyundai","Accent" ,30))      
                  .collect(Collectors.summingInt(x -> x.mpg));
 
        System.out.println("sum of mpg = " + sum);
    }
}