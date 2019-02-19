package chapter10;
import java.util.Comparator;
public class Sect5_Ex2 
{
    public static void main(String[] args)
    {
        Comparator<Student> byName = Comparator.comparing(x -> x.name);
        Comparator<Student> byGpa  = Comparator.comparing(x -> x.gpa);

        Student s1 = new Student("Joseph", 1000, 3.82);
        Student s2 = new Student("Joseph", 1002, 3.82);

        System.out.println(byName.thenComparing(byGpa)
                                 .compare(s1, s2));        
    }
}