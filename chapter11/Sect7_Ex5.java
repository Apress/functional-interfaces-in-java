package chapter11;
import java.util.Optional;
class Resource
{
    static int count = 3;
    public Resource()
    {
        count--;

        System.out.println("Resource consumed, " + count 
                         + " remaining.");
    }
}

public class Sect7_Ex5 
{
    public static void main(String[] args)
    {
        Optional.of(new Resource())        // Resource.count = 2
                .filter(x -> x.count > 0)
                .map(x -> new Resource())  // Resource.count = 1 
                .filter(x -> x.count > 0)
                .map(x -> new Resource())  // Resource.count = 0
                .filter(x -> x.count > 0)  // Optional(null)
                .map(x -> new Resource()); // doesn't execute        
    }
}