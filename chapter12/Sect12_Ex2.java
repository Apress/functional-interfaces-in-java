package chapter12;
import java.util.stream.DoubleStream;
public class Sect12_Ex2 
{
    public static void main(String[] args)
    {
        DoubleStream.of(1.1,2.2,3.3,4.4)
                    .average()
                    .ifPresent(x -> System.out.println(x));
    }
}