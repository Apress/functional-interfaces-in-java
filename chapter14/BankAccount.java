package chapter14;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.function.*;
enum TRANS { DEP, WITH }
class AccountBalance
{
    double balance;
    public AccountBalance(double d) { balance = d; }
    @Override
    public String toString() { return Double.toString(balance); }
}
public class BankAccount 
{
    static AtomicReference<AccountBalance> b =
        new AtomicReference(new AccountBalance(500.0));
    static void accumulate(double value, BinaryOperator op)
    {
        b.accumulateAndGet(new AccountBalance(value), op);
    }
    public static void main(String[] args)
    {
        TRANS[] p1Trans =
         {TRANS.DEP, TRANS.WITH, TRANS.DEP, TRANS.WITH, TRANS.WITH};
        TRANS[] p2Trans =
         {TRANS.WITH, TRANS.WITH, TRANS.WITH, TRANS.DEP, TRANS.WITH};

        BinaryOperator<AccountBalance> deposit    = (x,y) -> 
            new AccountBalance(x.balance + y.balance);
        
        BinaryOperator<AccountBalance> withdrawal = (x,y) -> 
            new AccountBalance(x.balance - y.balance);

        CompletableFuture<AccountBalance> p1 =
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < p1Trans.length && b.get().balance > 0;
                 ++i)
            {
                if (p1Trans[i] == TRANS.DEP)
                    accumulate(50.0, deposit);
                else 
                    accumulate(70.50, withdrawal);
                System.out.println("p1: " + b.get().balance);
            }
            return null;
        });

        CompletableFuture<AccountBalance> p2 =
          CompletableFuture.supplyAsync( () -> {
            for (int i=0; i < p2Trans.length && b.get().balance > 0;
                 ++i)
            {
                if (p2Trans[i] == TRANS.DEP)
                    accumulate(20.0, deposit);
                else 
                    accumulate(120.50, withdrawal);
                System.out.println("p2: " + b.get().balance);
            }
            return null;
        });

        CompletableFuture.allOf(p1,p2)
                         .join();
    }
}