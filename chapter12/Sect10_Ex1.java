package chapter12;
import java.util.stream.*;
public class Sect10_Ex1 
{
    public static void main(String[] args)
    {
        Stream.Builder<String> bld = Stream.builder();

        bld.accept("RED");
        bld.accept("GREEN");
        bld.accept("BLUE");

        Stream<String> st = bld.build();
        st.forEach(x -> System.out.println(x));        
    }
}