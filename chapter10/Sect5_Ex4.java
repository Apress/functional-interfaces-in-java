package chapter10;
import java.util.Comparator;
public class Sect5_Ex4 
{
    public static void main(String[] args)
    {
        Comparator<Student> byName = Comparator.comparing(x -> x.name);
        Comparator<Student> byId   = Comparator.comparing(x -> x.id);
        Comparator<Student> byGpa  = Comparator.comparing(x -> x.gpa);
        
        Student s1 = new Student("Joseph", 1000, 3.82);
        Student s2 = new Student("Joseph", 1002, 3.82);
                
        System.out.println(byName.thenComparing(byGpa)
                                 .thenComparing(byId)
                                 .compare(s1, s2));
    }
}