package chapter11;
import java.util.Optional;
public class Sect2_Ex2 {
    public static void main(String[] args)
    {
        Optional<String> imNull = Optional.ofNullable(null);
        if (imNull.isEmpty())
            System.out.println("Empty");        
    }
}