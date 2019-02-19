package chapter8;
import java.util.*;
import java.util.function.Consumer;
class Employee
{
    String name;
    double baseSalary;
    double bonus;
    double multiplier;
    public Employee(String n, double bs, double bn, double m)
    {
        name = n;
        baseSalary = bs;
        bonus = bn;
        multiplier = m;
    }
    @Override
    public String toString() { 
        return name + ": base salary = " + baseSalary
             + " bonus = " + bonus;
    }
}

class MomAndPop implements Iterable<Employee>
{
    static int NUM_EXECS = 2;
    static double profit;
    Employee CEO;
    Employee vicePresident;
    List<Employee> districtManagers;
    List<Employee> programmers;
    public MomAndPop()
    {
        CEO = new Employee("Mr. Bucks", 1000000.0, 75000.0, 0.15);

        vicePresident = new Employee("Highly Mobile", 750000.0,
                                     25000.0, 0.15);
        districtManagers = Arrays.asList(
            new Employee("Joe Johnston", 200000.0, 10000.0, 0.15),
            new Employee("Sarah Smith" , 210000.0,  9000.0, 0.15 ));
        programmers = Arrays.asList(
            new Employee("Javier Rodriguez", 150000.0, 2000.0, 0.10),
            new Employee("Kalpana Patel"   , 155000.0, 1500.0, 0.10),
            new Employee("Cyndy Altavera"  , 140000.0, 1200.0, 0.10),
            new Employee("Sam Jones"       , 130000.0, 1300.0, 0.10)
        );
    }
    public Iterator<Employee> iterator() 
    { 
        return new EmployeeIterator(); 
    }

    private class EmployeeIterator implements Iterator<Employee>
    {
        private int cursor;
        private final int limit;
         public EmployeeIterator()
        {
            cursor = 0;
            limit = NUM_EXECS + districtManagers.size() 
                  + programmers.size();
        }
        @Override
        public boolean hasNext() { return cursor < limit; }
        @Override
        public Employee next() 
        { 
            Employee emp = null; 
            if (hasNext())
            {
                if (cursor == 0)
                    emp = CEO;
                else if (cursor == 1)
                    emp = vicePresident;
                else if (cursor < (NUM_EXECS 
                                 + districtManagers.size()))
                    emp = districtManagers.get(cursor - NUM_EXECS);
                else if (cursor < (NUM_EXECS 
                                 + districtManagers.size() 
                                 + programmers.size()))
                    emp = programmers.get(cursor - NUM_EXECS 
                                        - districtManagers.size());
                cursor++;
            }
            return emp;
        }
    }
}

public class Payroll {
    public static void main(String[] args)
    {
        Consumer<Employee> applyProfit = x -> 
             x.bonus += MomAndPop.profit * x.multiplier;

        MomAndPop company = new MomAndPop();
        MomAndPop.profit = 120000.0; // 40% PRG 30%MGR 15% VP 15% CEO

        company.forEach(applyProfit
                        .andThen(x -> System.out.println(x)));
    }
}

