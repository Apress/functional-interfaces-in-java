package chapter1;
import java.util.*;
public class Pet
{
    String name;
    String animal;
    String breed;
    String color;
    double price;
    static List<Pet> pets = new ArrayList<>();
    public Pet(String n, String a, String b, String c, double p)
    {
        name   = n;
        animal = a;
        breed  = b;
        color  = c;
        price  = p;
    }
    @Override 
    public String toString()
    {
        return name + ":" + " a " + color + " " + breed 
             + " " + animal + " for $" + price;
    }

    @Override 
    public boolean equals(Object o)
    {
        Pet p = (Pet)o;
        return animal.equals(p.animal) && breed.equals(p.breed);
    }
}
