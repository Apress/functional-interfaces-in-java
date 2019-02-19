package chapter2.version2;
@FunctionalInterface
public interface StringProcessor
{
    String process(String s);

    static boolean isLowerCase(String s)
    {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i)
            result &= Character.isLowerCase(s.charAt(i));
        return result;
    }

    static boolean isUpperCase(String s)
    {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i)
            result &= Character.isUpperCase(s.charAt(i));
        return result;
    }
}
