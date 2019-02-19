package chapter15;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.function.*;
import java.util.*;
import java.time.*;
import javafx.collections.*;
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
    public String toString() 
    { 
        return expDate + " " + insurance + " " + status + " " 
             + vehicles;
    }
}
public class DMVGUI extends Application {
    ObservableMap<String,License> d;

    @Override
    public void start(Stage primaryStage) {

        d = FXCollections.observableHashMap();

        MapChangeListener listener = x -> {
            System.out.print("map event:");
            if (x.wasAdded())
            {
                System.out.print(" ADD " + x.getKey() + "," 
                               + x.getValueAdded());
            }
            if (x.wasRemoved())
            {
                System.out.print(" RMV " + x.getKey() + "," 
                               + x.getValueRemoved());
            }
            System.out.println("\nNew map:");
            x.getMap().forEach( (y,z) -> System.out.println(y + "," 
                                       + z));
        };
        d.addListener(listener);

        GridPane gridPane = new GridPane();


        Label label1 = new Label("licenseId:");
        Label label2 = new Label("Year:     ");
        Label label3 = new Label("Month:    ");
        Label label4 = new Label("Day:      ");

        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();

        ChoiceBox box = new ChoiceBox();
        box.getItems().addAll("Add Driver",
                              "Remove Driver",
                              "Change Insurance",
                              "Suspend License",
                              "Renew License",
                              "Add Vehicle",
                              "Remove Vehicle",
                              "Quit");
        box.getSelectionModel().selectFirst();
        box.setOnAction( x -> {
            text2.setText("");
            text3.setText("");
            text4.setText("");
            switch (box.getSelectionModel().getSelectedIndex())
            {
                case 0: 
                case 4:  label2.setText("Year:     ");
                         label3.setText("Month:    ");
                         label4.setText("Day:      ");
                         break;
                case 1:
                case 3:  label2.setText("          ");
                         label3.setText("          ");
                         label4.setText("          ");
                         break;
                case 2:  label2.setText("Insurance:");
                         label3.setText("          ");
                         label4.setText("          ");
                         break;
                case 5: 
                case 6:  label2.setText("Make:     ");
                         label3.setText("Model:    ");
                         label4.setText("Year:     ");
                         break;
                default: Platform.exit();
            }
        });

        Supplier<LocalDate> expDate = () -> {
            int year = Integer.parseInt(text2.getText());
            Month month = Month.valueOf(text3.getText());
            int day = Integer.parseInt(text4.getText());
            return LocalDate.of(year, month, day);
        };

        Supplier<Vehicle> vehicle = () -> {
            String make = text2.getText();
            String model = text3.getText();
            int year = Integer.parseInt(text4.getText());
            return new Vehicle(make, model, year);
        };

        Button submit = new Button("submit");
        submit.setOnAction( x -> {
            switch (box.getSelectionModel().getSelectedIndex())
            {
                case 0: // Add Driver
                        BiFunction<License,License,License> 
                            addDriver = (ov,nv) -> ov;
                        d.merge(text1.getText(),
                                new License(expDate.get(), null),
                                addDriver);
                        break;
                        
                case 1: // Remove Driver
                        BiFunction<String,License,License> 
                            remove = (k,v) -> null;
                        d.computeIfPresent(text1.getText(),remove);
                        break;

                case 2: // Change Insurance
                        BiFunction<License,License,License>
                          changeInsurance = (ov,nv) -> 
                            new License(ov.expDate, nv.insurance,
                                        ov.status, ov.vehicles);        
                        d.merge(text1.getText(),
                                new License(null, text2.getText()),
                                changeInsurance);
                        break;

                                                
                case 3: // Suspend License
                        BiFunction<String,License,License> 
                          suspend = (k,v) -> 
                           new License(v.expDate, v.insurance,
                                       STATUS.SUSPENDED, v.vehicles);        
                        d.computeIfPresent(text1.getText(),suspend);
                        break;
                        
                case 4: // Renew License
                        BiFunction<License,License,License> 
                          renew = (ov,nv) ->
                            new License(nv.expDate, ov.insurance, 
                                        STATUS.ACTIVE, ov.vehicles);        
                        d.merge(text1.getText(),
                                new License(expDate.get(), null),
                                renew);
                        break;
                        
                case 5: // Add Vehicle
                        BiFunction<License,License,License> 
                          addVehicle = (ov,nv) -> {
                            License temp = new License(ov);
                            temp.vehicles.add(nv.vehicles.get(0));
                            return temp;
                        };
                        d.merge(text1.getText(),
                                new License(null, null,
                                            vehicle.get()),
                                addVehicle);
                        break;
                        
                case 6: // Remove Vehicle
                        BiFunction<License,License,License> 
                          removeVehicle = (ov,nv) -> {
                            License temp = new License(ov);
                            Vehicle r = nv.vehicles.get(0);

                            temp.vehicles.removeIf(z ->
                                              z.make.equals(r.make)
                                           && z.model.equals(r.model)
                                          && z.year == r.year);
                            return temp;
                         };


                         d.merge(text1.getText(),
                                 new License(null,
                                             null,vehicle.get()),
                                 removeVehicle);
            }            
        });
        
        gridPane.add(label1,0,0);
        gridPane.add(text1 ,1,0);
        gridPane.add(label2,0,1);
        gridPane.add(text2 ,1,1);
        gridPane.add(label3,0,2);
        gridPane.add(text3 ,1,2);
        gridPane.add(label4,0,3);
        gridPane.add(text4 ,1,3);
        gridPane.add(box   ,1,4);
        gridPane.add(submit,1,5);

        Scene scene = new Scene(gridPane, 300, 250);
 
        primaryStage.setTitle("DMV");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}