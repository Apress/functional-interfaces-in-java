package chapter10;
import java.util.Comparator;
public class Sect3_Ex2 
{
    public static void main(String []args)
    {
        Student s1 = new Student("Larry", 1000, 3.82);
        Student s2 = new Student("Libby", 1001, 3.76);
        
        Comparator<Student> byId = Comparator.comparing(x -> x.id);
        System.out.println(byId.compare(s1,s2));      
    }
}