package chapter10;
import java.util.*;
public class Sect7_Ex1 
{
    public static void main(String[] args)
    {        
        List<Student> students = Arrays.asList(
                new Student("Joseph"  , 1623, 3.54),
                new Student("Annie"   , 1923, 2.94),
                new Student("Sharmila", 1874, 1.86),
                new Student("Harvey"  , 1348, 1.78),
                new Student("Grace"   , 1004, 3.90),
                new Student("Annie"   , 1245, 2.87) 
        );

        Comparator<Student> byGpaCeil = 
            Comparator.comparing( x -> x.gpa,
                                 (x,y) -> (int)(Math.ceil(x) 
                                              - Math.ceil(y)));

        students.sort(byGpaCeil);
        students.forEach(x-> System.out.println(x));
    }
}