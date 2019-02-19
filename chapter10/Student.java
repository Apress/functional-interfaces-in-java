package chapter10;
public class Student
{
    String  name;
    Integer id;
    Double  gpa;
    public Student(String n, int i, double g) 
    { 
        name = n; 
        id   = i;
        gpa  = g;
    }
    @Override
    public String toString() { return name + " " + id + " " + gpa; } 
}