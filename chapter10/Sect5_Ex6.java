package chapter10;
import static chapter10.Sect1_Ex1.removeVowels;
import java.util.Comparator;
public class Sect5_Ex6 
{
    public static void main(String[] args)
    {
        Comparator<Student> byNameConsonants 
                = Comparator.comparing( x -> x.name,
                                       (x,y) ->
                            removeVowels(x).compareTo(removeVowels(y)));

        Comparator<Integer> byDifference = (x,y) -> x - y;

        Comparator<Double> byCeil = 
                (x,y) -> (int)(Math.ceil(x) - Math.ceil(y));
        
        Student s3 = new Student("Jean", 1003, 3.86);
        Student s4 = new Student("Jen" , 1005, 3.69);

        System.out.println(byNameConsonants.thenComparing(x -> x.id,
                                                          byDifference)
                                           .thenComparing(x -> x.gpa,
                                                          byCeil)
                                           .compare(s3, s4));
    }
}