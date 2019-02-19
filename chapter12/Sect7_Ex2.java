package chapter12;
import java.util.stream.Stream;
import chapter10.Student;
public class Sect7_Ex2 
{
    public static void main(String[] args)
    {        
        Stream.of(
            new Class("Biology",
                new Student("Joe" ,1001,3.81),
                new Student("Mary",1002,3.91)),
            new Class("Physics",
                new Student("Kalpana",1003,3.61),
                new Student("Javier" ,1004,3.71))) // Stream<Class>
              .map(x -> x.students)                // Stream<List<Student>>
              .forEach(x -> System.out.println(x));
    }
}