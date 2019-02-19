package chapter8;
import java.util.TreeMap;
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        TreeMap<String, Double> employeeSalaries = new TreeMap<>();
        employeeSalaries.put("Joe Smith", 100000.0);
        employeeSalaries.put("Maggie Jones", 110000.0);
        employeeSalaries.put("Larry Rodriguez", 105000.0);
        
        employeeSalaries.forEach( (x,y) -> 
                    System.out.println(x + " makes $" + y + " annually."));
    }
}
