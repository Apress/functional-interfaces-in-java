package chapter9;
import java.util.*;
import java.util.function.*;
import java.time.*;
enum STATUS {ACTIVE, SUSPENDED}
class Vehicle
{
    String make;
    String model;
    int    year;
    public Vehicle(String ma, String mo, int y) 
    { 
        make = ma; 
        model = mo; 
        year = y; 
    }
    @Override
    public String toString() 
    { 
        return year + " " + make + " " + model; 
    } 
}

class License
{
    LocalDate expDate;
    String insurance;
    STATUS status;
    ArrayList<Vehicle> vehicles;

    public License(LocalDate e, String i, Vehicle... v) 
    { 
        expDate = e;
        insurance = i;
        status = STATUS.ACTIVE;
        vehicles = new ArrayList<>();
        for (Vehicle r : v)
            vehicles.add(r);
    }

    public License(LocalDate e, String i, STATUS s,
                   ArrayList<Vehicle> vs) 
    { 
        expDate = e;
        insurance = i;
        status = s;
        vehicles = new ArrayList<>(vs);
    }

    public License(License l)
    {
        expDate = l.expDate;
        insurance = l.insurance;
        status  = l.status;
        vehicles = new ArrayList<>(l.vehicles);
    }
    @Override
    public String toString() 
    { 
        return expDate + " " + insurance + " " + status 
             + " " + vehicles;
    }
}
public class DMV 
{
    public static void main(String[] args)
    {
        Map<String,License> d = new TreeMap<>();
        System.out.println(
            "Welcome to the Department of Motor Vehicles.");
        
        Supplier<Integer> selectOperation = () -> {
            int selection = -1;
            Scanner input = new Scanner(System.in);
            while (selection < 0 || selection > 7)
            {
                System.out.println("Select and Operation:");
                System.out.println(
              "   0 - Add Driver  1 - Remove Driver 2 - Change Ins");
                System.out.println(
               "   3 - Suspend Lic 4 - Renew License 5 - Add Veh");
                System.out.print  (
               "   6 - Remove Veh  7 - Quit:");
                selection = Integer.parseInt(input.nextLine());
                if (selection < 0 || selection > 7)
                    System.out.println("Imvalid selection");
            }
            return selection;
        };
 
      Supplier<String> licenseId = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter licenseId:");
            return input.nextLine();
        };

        Supplier<String> insurance = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter insurance:");
            return input.nextLine();
        };

        Supplier<LocalDate> expDate = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter year:");
            int year = Integer.parseInt(input.nextLine());
            System.out.print("Enter month:");
            Month month = Month.valueOf(input.nextLine());
            System.out.print("Enter day:");
            int day = Integer.parseInt(input.nextLine());
            return LocalDate.of(year, month, day);
        };

        Supplier<Vehicle> vehicle = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter make:");
            String make = input.nextLine();
            System.out.print("Enter model:");
            String model = input.nextLine();
            System.out.print("Enter year:");
            int year = Integer.parseInt(input.nextLine());
            return new Vehicle(make, model, year);
        };

        int operation = 0;
        while (operation != 7)
        {
            operation = selectOperation.get();
        
            switch (operation)
            {
                case 0: // Add Driver
                  BiFunction<License,License,License> addDriver
                      = (ov,nv) -> ov;

                  System.out.println(
                      d.merge(licenseId.get(),
                              new License(expDate.get(), null),
                              addDriver));
                  break;
                        
                case 1: // Remove Driver
                  BiFunction<String,License,License> remove
                      = (k,v) -> null;
                       
  
                  System.out.println(
                      d.computeIfPresent(licenseId.get(),remove));
                  break;

                case 2: // Change Insurance
                  BiFunction<License,License,License> changeInsurance
                      = (ov,nv) -> new License(ov.expDate,
                                               nv.insurance, 
                                               ov.status,
                                               ov.vehicles);        

                  System.out.println(
                      d.merge(licenseId.get(),
                              new License(null, insurance.get()),
                              changeInsurance));
                  break;
                        
                case 3: // Suspend License
                  BiFunction<String,License,License> suspend 
                      = (k,v) -> new License(v.expDate, v.insurance,
                                             STATUS.SUSPENDED,
                                             v.vehicles);        

                  System.out.println(
                      d.computeIfPresent(licenseId.get(),suspend));
                  break;
                        
                case 4: // Renew License
                  BiFunction<License,License,License> renew
                      = (ov,nv) -> new License(nv.expDate,
                                               ov.insurance,
                                               STATUS.ACTIVE,
                                               ov.vehicles);        

                  System.out.println(
                      d.merge(licenseId.get(),
                              new License(expDate.get(), null),
                              renew));
                  break;

                case 5: // Add Vehicle
                  BiFunction<License,License,License>
                      addVehicle = (ov,nv) -> {
                          License temp = new License(ov);
                          temp.vehicles.add(nv.vehicles.get(0));
                          return temp;
                      };

                  System.out.println(
                      d.merge(licenseId.get(),
                              new License(null, null,vehicle.get()),
                              addVehicle));
                  break;
                        
                case 6: // Remove Vehicle
                  BiFunction<License,License,License>
                      removeVehicle = (ov,nv) -> {
                          License temp = new License(ov);
                          Vehicle r = nv.vehicles.get(0);
                          temp.vehicles.removeIf(
                              x -> x.make.equals(r.make)
                                && x.model.equals(r.model)
                                && x.year == r.year);
                          return temp;
                      };
    
              System.out.println(
                      d.merge(licenseId.get(),
                              new License(null, null,vehicle.get()),
                              removeVehicle));
            }
        }
    }
}
