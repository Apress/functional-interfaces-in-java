package chapter2.version2;
public class Sect6_Ex2 
{
    public static void main(String[] args)
    {
        StringProcessor toLowerCase = x -> x.toLowerCase();

        String s = toLowerCase.process("FUNCTIONALINTERFACES");
        System.out.println(s);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(s));        

        StringProcessor toUpperCase = x -> x.toUpperCase();

        String t = toUpperCase.process(s);
        System.out.println("\n" + t);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(t));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(t));
    }
}
