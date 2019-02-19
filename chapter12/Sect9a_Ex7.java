package chapter12;
import java.util.stream.*;
public class Sect9a_Ex7 
{
    public static void main(String[] args)
    {
        Stream.of(new Car("Buick"  ,"Regal"  ,25),
                  new Car("Hyundai","Elantra",27),
                  new Car("Buick"  ,"Skylark",26), 
                  new Car("Hyundai","Accent" ,30))// Stream<Car>
              .collect(Collectors.groupingBy(x ->// Map<String,List<Integer>>
                  x.manu,
                  Collectors.mapping(x -> x.mpg, 
                          Collectors.toList())))  // List<Integer>>
              .forEach( (x,y) -> 
                       System.out.println(x + ": " +y ));       
    }
}