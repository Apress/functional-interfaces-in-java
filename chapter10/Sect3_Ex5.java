package chapter10;
import java.util.Comparator;
public class Sect3_Ex5 
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Larry", 1000, 3.82);
        Student s2 = new Student("Libby", 1001, 3.76);
        
        Comparator<Student> byGpaCeil = 
           Comparator.comparing(  x -> x.gpa,
                                 (x,y) -> (int)(Math.ceil(x) 
                                              - Math.ceil(y)));

        System.out.println(byGpaCeil.compare(s1,s2));        
    }
}