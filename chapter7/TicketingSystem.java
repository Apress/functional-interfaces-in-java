package chapter7;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.function.BooleanSupplier;

abstract class Ticket implements Comparable<Ticket>
{
    String customerName;
    int id;
    String description;
    LocalDate dueDate;
    LocalDate servicedDate;

    public Ticket(String cn, int i, String d, int due)
    {
        customerName = cn;
        id = i;
        description = d;
        dueDate = LocalDate.now().plusDays(due);
        servicedDate = LocalDate.now().minusDays(1);
    }






    @Override
    public String toString() 
    { 
        return "NAME:           " + customerName 
             + "\nID:             " + id 
             + "\nDESCRIPTION:    " + description  
             + "\nDUE DATE:       " + dueDate 
             + "\nSERVICED DATE:  " + servicedDate;
    }
    @Override 
    public int compareTo(Ticket t) 
    { 
        return dueDate.compareTo(t.dueDate); 
    }
}

class HardwareTicket extends Ticket
{
    String device;
    String model;
    String serialNumber;
    public HardwareTicket(String cn, int i, String d, int due, 
                          String dev, String mod, String sn)
    {
        super(cn, i, d, due);
        device = dev;
        model = mod;
        serialNumber = sn;
    }
    @Override
    public String toString()
    {
        return super.toString() 
             + "\nDEVICE:         " + device 
             + "\nMODEL:          " + model 
             + "\nSERIAL NUMBER:  " + serialNumber;
    }
}

enum Domain {WEB_HOSTED, PHONE_HOSTED}


class SoftwareTicket extends Ticket
{
    String application;
    String version;
    Domain domain;
    public SoftwareTicket(String cn, int i, String d, int due,
                          String app, String ver, Domain dom)
    {
        super(cn, i, d, due);
        application = app;
        version = ver;
        domain = dom;
    }
    @Override
    public String toString()
    {
        return super.toString() 
             + "\nAPPLICATION:    " + application 
             + "\nVERSION:        " + version 
             + "\nDOMAIN:         " + domain;
    }
}

public class TicketingSystem 
{
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static LocalDate today = LocalDate.now();
    private static void populateDatabase()
    {
        tickets.add(new HardwareTicket("Kalpana Patel",54641, 
                                      "Cell phone won't power on",
                                       5, "Smartie", "SM250",
                                       "SN546497-S23"));
        tickets.add(new SoftwareTicket("Chester Rodriguez",89034,
                                 "MapApp can't find grandma's house",
                                       2, "MapApp", "1.01",
                                        Domain.PHONE_HOSTED));
        tickets.add(new SoftwareTicket("Britney Delmonica",91472,
                              "Can't change banking info on website",
                                     1, "awesomecheapcellphones.com",
                                       "2.65", Domain.WEB_HOSTED));


        tickets.add(new HardwareTicket("Kalpana Patel",54641, 
                                    "Cell phone's screen goes black",
                                       7, "Rover", "RV100",
                                       "SN456742-R31"));
    }
    public static void main(String[] args)
    {
        Supplier<? extends Ticket> nextTicket = () -> 
        {
            Ticket next = null;


            for (int i=0; i < tickets.size(); ++i)
            {
                Ticket t = tickets.get(i);
                if (t.servicedDate.compareTo(today) < 0)
                {
                    if (next == null || t.compareTo(next) < 0)
                        next = t;
                }
            }
            if (next != null)
                next.servicedDate = today;
            return next;
        };
        
        BooleanSupplier canClose = () -> {   
            boolean result = false;
            Scanner scan = new Scanner(System.in);
            System.out.print("\nCan you close the ticket (Y or N)?");
            if (scan.nextLine().charAt(0) == 'Y')
                result = true;
            return result;
        };
        
        BooleanSupplier isQuittingTime = () -> {   
            boolean result = false;
            Scanner scan = new Scanner(System.in);
            System.out.print("Is it quitting time (Y or N)?");




            if (scan.nextLine().charAt(0) == 'Y')
                result = true;
            return result;
        };
        
        populateDatabase();
        Ticket next;
        boolean done = false;
        do
        {
            next = nextTicket.get();
            if (next != null)
            {
                System.out.println("\n" + next);
                if (canClose.getAsBoolean())
                    tickets.remove(next);


                if (isQuittingTime.getAsBoolean())
                    done = true;
            }
        } while(next != null && !done);
        
        if (next == null)
            System.out.println(
                 "\nCongrats, you get a $50 bonus today!");
        else
            System.out.println("\nSee you tomorrow");
    }
}
