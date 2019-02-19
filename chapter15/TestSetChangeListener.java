package chapter15;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TestSetChangeListener extends Application {
    ObservableSet<String> set;

    @Override
    public void start(Stage primaryStage) 
    {
        set = FXCollections.observableSet();
        SetChangeListener listener = x -> {
            System.out.print("set event:");
            if (x.wasAdded())
            {
                System.out.print(" ADD "  + x.getElementAdded());
            }
            if (x.wasRemoved())
            {
                System.out.print(" RMV " + x.getElementRemoved());
            }
            System.out.println("\nNew set:");
            x.getSet().forEach( y -> System.out.println(y));
        };
        set.addListener(listener);
        
        TextField element = new TextField();
        Button add = new Button("add");
        Button rmv = new Button("remove");

        add.setOnAction(x -> set.add(element.getText()));
        rmv.setOnAction(x -> set.remove(element.getText()));
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(element, add, rmv);

        StackPane root = new StackPane();
        root.getChildren().add(hBox);

        Scene scene = new Scene(root);
 
        primaryStage.setTitle("Test Set Change Listener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}