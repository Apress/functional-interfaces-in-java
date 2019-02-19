package chapter10;
import java.util.Comparator;
public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        Comparator<Student> byName = Comparator.comparing(x -> x.name);

        Student s1 = new Student("Joseph", 1000, 3.82);
        Student s2 = new Student("Joseph", 1002, 3.82);

        System.out.println(byName.compare(s1, s1));        
    }
}