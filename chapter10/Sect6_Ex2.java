package chapter10;
import java.util.Comparator;
public class Sect6_Ex2 
{
    public static void main(String[] args)
    {
        Comparator<Student> byName = Comparator.comparing(x -> x.name);

        Student s7 = new Student("Robert", 1008, 3.86);
        Student s8 = new Student("Robert", 1009, 3.69);

        System.out.println(byName.thenComparingDouble( x-> x.gpa )
                                 .compare(s7,s8));      
    }
}