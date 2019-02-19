package chapter15;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.*;
public class TestInvalidation extends Application {
    ObservableMap<String,Integer> map;

    @Override
    public void start(Stage primaryStage) 
    {
        map = FXCollections.observableHashMap();
        TextField key   = new TextField();
        TextField value = new TextField();
        MapChangeListener listener = x -> {
            x.getMap().forEach( (y,z) -> System.out.println(y + "," 
                                                          + z));
        };
        map.addListener(listener);
        
        InvalidationListener inv = x -> {
            String text = key.getText();
            if (map.containsKey(text))
            {
                int oldValue = map.get(text);
                map.put(text,Integer.parseInt(value.getText()));
                System.out.println("REPLACE " + text + "," + oldValue
                                 + " with " + text + "," 
                                 + value.getText());
            }
        };

        key.textProperty().addListener(inv);
        value.setOnAction(x -> 
            map.put(key.getText(),Integer.parseInt(value.getText()))
        );
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(key, value);

        StackPane root = new StackPane();
        root.getChildren().add(hBox);

        Scene scene = new Scene(root);
 
        primaryStage.setTitle("Invalidation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}