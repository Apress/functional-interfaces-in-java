package chapter10;
import java.util.function.ToIntFunction;
import java.util.Comparator;
public class Sect4_Ex2 {
    public static void main(String[] args)
    {
        Student s1 = new Student("Larry", 1000, 3.82);
        Student s2 = new Student("Libby", 1001, 3.76);
        
        ToIntFunction<Student> idKey2 = x -> x.id;
        System.out.println(Comparator.comparingInt(idKey2)
                                     .compare(s1, s2));
    }
}