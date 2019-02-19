package chapter10;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;
public class Sect4_Ex1 
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Larry", 1000, 3.82);
        Student s2 = new Student("Libby", 1001, 3.76);
        
        ToDoubleFunction<Student> gpaKey2 = x -> x.gpa;
        System.out.println(Comparator.comparingDouble(gpaKey2)
                                     .compare(s1, s2));
    }
}