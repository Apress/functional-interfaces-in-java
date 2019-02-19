package chapter1;
public class TestStringProcessor 
{
    public static void main(String[] args)
    {
        NamedStringProcessor namedSP = new NamedStringProcessor();

        StringProcessor anonSP = new StringProcessor() {
            @Override 
            public String process(String x)
            {
                return x.toUpperCase();
            }
        };

        System.out.println(namedSP.process("hello"));
        System.out.println(anonSP.process("hello"));
    }
}
