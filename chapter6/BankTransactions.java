package chapter6;
import java.util.function.*;
import java.util.*;
class BankAccount
{
    String name;
    int    id;
    double balance;
    public BankAccount(String n, int i, double b)
    {
        name = n;
        id = i;
        balance = b;
    }
    @Override 
    public boolean equals(Object ba) 
    { 
        return id == ((BankAccount)ba).id; 
    }
    @Override
    public String toString() 
    { 
        return "name = " + name + " id = " + id 
             + " balance = " + balance; 
    }
}
public class BankTransactions 
{
    private static ArrayList<BankAccount> accounts 
         = new ArrayList<>();
    private static int numAccounts = 0;
    private static double prevBalance = 0.0;
    private static Scanner scan = new Scanner(System.in);
    public static String promptTransaction()
    {
        System.out.println("Enter Transaction Type:");
        System.out.println("OPENACCOUNT");
        System.out.println("DEPOSIT");
        System.out.println("WITHDRAWAL");
        System.out.println("CLOSEACCOUNT");
        System.out.print("QUIT:");
        return scan.nextLine();
    }
    public static double promptAmount()
    {
        System.out.print("Enter amount:");
        return Double.parseDouble(scan.nextLine());
    }
    public static String promptName()
    {
        System.out.print("Enter name:");
        return scan.nextLine();
    }
    public static int promptId()
    {
        System.out.print("Enter id:");
        return Integer.parseInt(scan.nextLine());
    }
    public static BankAccount findBankAccount(int id)
    {
        int index = accounts.indexOf(new BankAccount(null,id,0.0));
        return (index > -1) ? accounts.get(index) : null;
    }
    public static void main(String[] args)
    {
        BiConsumer<String,Double> open = (x,y) -> {
            numAccounts = accounts.size();
            Random generator = new Random();
            accounts.add(new BankAccount(x, 
                         generator.nextInt(10000), y));
        };

        BiConsumer<String,Double> openVerification = (x,y) -> {
            if ( accounts.size() == (numAccounts + 1) 
             &&  accounts.get(numAccounts).name.equals(x) )
                 System.out.println("ACCOUNT for " + x 
                                  + " OPENED SUCCESSFULLY.\n"
                                    + accounts.get(numAccounts));
            else
                System.out.println("COULD NOT OPEN ACCOUNT for " 
                                 + x);
        };


        BiConsumer<Integer,Double> deposit = (x,y) -> {
            BankAccount account = findBankAccount(x);
            if (account != null)
            {
                prevBalance = account.balance;
                account.balance += y;
            }
        };
        
        BiConsumer<Integer,Double> depositVerification = (x,y) -> {
            BankAccount account = findBankAccount(x);
            if (account != null 
             && account.balance == (prevBalance + y) )
                System.out.println("DEPOSIT OF $" + y 
                                 + " INTO ACCOUNT " + x 
                                   + " SUCCESSFUL\n" + account);
            else
                System.out.println("ACCOUNT " + x + "NOT FOUND");
        };
        
        BiConsumer<Integer,Double> withdraw = (x,y) -> {
            BankAccount account = findBankAccount(x);
            if (account != null)
            {
                prevBalance = account.balance;
                if ((account.balance - y) >= 0.0)
                    account.balance -= y;
            }
        };

        BiConsumer<Integer,Double> withdrawVerfication = (x,y) -> {
            BankAccount account = findBankAccount(x);
            if (account != null)
            {
                if (account.balance == (prevBalance - y))
                    System.out.println("WITHDRAW OF $" + y 
                                     + " FROM ACCOUNT " + x 
                                     + " SUCCESSFUL\n" + account);
                else
                    System.out.println("INSUFFICIENT FUNDS TO" 
                                     + " WITHDRAW $" + y 
                                     + " FROM ACCOUNT " + x + "\n"
                                     + account); 
            }
            else
                System.out.println("ACCOUNT " + x + "NOT FOUND");
        };
        
        Consumer<Integer> close = x -> {
            numAccounts = accounts.size();
            BankAccount account = findBankAccount(x);
            if (account != null)
                accounts.remove(account);
        };
         
        Consumer<Integer> closeVerification = x -> {
            if (accounts.size() == (numAccounts - 1) )
                System.out.println("ACCOUNT " + x + 
                                   " SUCCESSFULLY CLOSED");
            else
                System.out.println("COULD NOT CLOSE ACCOUNT " + x);
        };

        boolean done = false;
        while (!done)
        {
            String transactionSelected = promptTransaction();
            switch (transactionSelected)
            {
                case "OPENACCOUNT":
                    open.andThen(openVerification)
                        .accept(promptName(), promptAmount());
                    break;
                case "DEPOSIT":
                    deposit.andThen(depositVerification)
                           .accept(promptId(), promptAmount());
                    break;
                case "WITHDRAWAL":
                    withdraw.andThen(withdrawVerfication)
                            .accept(promptId(), promptAmount());
                    break;
                case "CLOSEACCOUNT":
                    close.andThen(closeVerification)
                         .accept(promptId());
                    break;

                case "QUIT":
                    done = true;
                    break;
                default: 
                    System.out.println("Invalid selection");
            }
        }
    }
}
