package chapter15;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TestMapChangeListener extends Application {
    int count = 0;
    ObservableMap<String,Integer> map;

    @Override
    public void start(Stage primaryStage) 
    {
        map = FXCollections.observableHashMap();
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
        map.addListener(listener);
        

        TextField key   = new TextField();
        TextField value = new TextField();

        value.setOnAction(x -> 
           map.put(key.getText(),Integer.parseInt(value.getText())));
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(key, value);

        StackPane root = new StackPane();
        root.getChildren().add(hBox);

        Scene scene = new Scene(root);
 
        primaryStage.setTitle("Test Map Change Listener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}