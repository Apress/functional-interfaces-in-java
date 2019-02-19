package chapter10;
import java.util.Comparator;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        Comparator<Student> byGpa  = Comparator.comparing(x -> x.gpa);
        Student s5 = new Student("Kaitlyn", 1006, 3.69);
        Student s6 = new Student("Jane"   , 1007, 3.69);

        System.out.println(byGpa.thenComparingInt( x-> x.id )
                                .compare(s5,s6));        
    }
}