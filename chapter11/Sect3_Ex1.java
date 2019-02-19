package chapter11;
import java.util.*;
public class Sect3_Ex1 
{
    public static void main(String[] args)
    {
        Optional<String> o5 = Optional.empty();

        try {
            o5.get();
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
    }
}