package chapter12;
import java.util.stream.*;
class Car
{
    String manu;
    String model;
    int mpg;
    public Car(String ma, String mo, int mp)
    {
        manu = ma;
        model = mo;
        mpg = mp;
    }
    public String toString() 
    { 
        return manu + " " + model + " gets " + mpg + " mpg"; 
    }
}

public class Sect9a_Ex6 
{
    public static void main(String[] args)
    {
        Stream.of(new Car("Buick"  ,"Regal"  ,25),
                  new Car("Hyundai","Elantra",27),
                  new Car("Buick"  ,"Skylark",26), 
                  new Car("Hyundai","Accent" ,30))   // Stream<Car>
              .collect(
                  Collectors.groupingBy(x -> x.manu))// Map<String,List<Car>>
              .forEach( (x,y) -> 
                  System.out.println(x + ": " +y ));        
    }
}