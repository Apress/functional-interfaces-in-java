package chapter6;
import java.util.function.BiConsumer;
public class TestBiConsumer 
{
    private static int sum = 0;
    private static String components = "";
    public static void main(String[] args)
    {
        BiConsumer<Integer,String> bi = (x,y) -> {
            sum += x; 
            components += y;
        };
        
        bi.andThen( (x,y) -> System.out.println(x + " " + y))
          .accept(6, "Term 1");

        bi.andThen( (x,y) -> System.out.println("add " + x + " " + y 
                           + " result = " + sum + " " + components))
          .accept(7, ",Term 2");
    }
}
