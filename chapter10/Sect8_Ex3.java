package chapter10;
import java.util.*;
import java.text.NumberFormat;
public class Sect8_Ex3 
{
    public static void main(String[] args)
    {
        final int NUM_STUDENTS = 1000;
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumIntegerDigits(3);
        Student[] studentBody = new Student[NUM_STUDENTS];
        for (int i = 0; i < NUM_STUDENTS; ++i)
            studentBody[i] = new Student("S" + fmt.format(i), i, 0.0);

        int index = Arrays.binarySearch(studentBody,
                                        new Student("S647",0,0.0),
                                        Comparator.comparing(x -> x.name));

        System.out.println("index = " + index + " " 
                         + studentBody[index]);
    }
}