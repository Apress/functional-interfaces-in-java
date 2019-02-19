package chapter10;
import java.util.*;
public class Sect8_Ex2 
{
    public static void main(String[] args)
    {
        Student[] students = {
                new Student("Joseph"  , 1623, 3.54),
                new Student("Annie"   , 1923, 2.94),
                new Student("Sharmila", 1874, 1.86),
                new Student("Harvey"  , 1348, 1.78),
                new Student("Grace"   , 1004, 3.90),
                new Student("Annie"   , 1245, 2.87) 
        };
        Student[] studentsCopy = Arrays.copyOf(students, students.length);
        
        Arrays.sort(studentsCopy, 2, 5,
                    Comparator.comparing(x -> x.name));

        for (Student s : studentsCopy)
            System.out.println(s);
    }
}