package chapter15;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class TestListChangeListener extends Application {

    @Override
    public void start(Stage primaryStage) 
    {
        ObservableList<String> list 
            = FXCollections.observableArrayList();
        ListChangeListener listener = x -> {
            while (x.next())
            {
                System.out.print("list event from " + x.getFrom() 
                               + " TO " + x.getTo() + ":");
                if (x.wasAdded())
                {
                    System.out.print(" ADD "  + x.getAddedSubList());
                }
                if (x.wasRemoved())
                {
                    System.out.print(" RMV " + x.getRemoved());
                }
                if (x.wasReplaced())
                {
                    System.out.print(" RPL from " + x.getFrom() 
                                   + " TO " + x.getTo());
                }
            }
            System.out.println("\nNew list:");
            x.getList().forEach( y -> System.out.println(y));
        };
        list.addListener(listener);
        
        TextField value = new TextField();
        TextField index = new TextField();
        Button add = new Button("add");
        Button rmv = new Button("remove");
        add.setOnAction(x -> {
            int i = Integer.parseInt(index.getText());
            if (list.size() == i)
                list.add(value.getText());
            else if (list.size() > i)
                list.set(i,value.getText());
        });

        rmv.setOnAction(x -> {
            int i = Integer.parseInt(index.getText());
            if (list.size() > i)
                list.remove(i);
        });
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(value, index, add, rmv);

        StackPane root = new StackPane();
        root.getChildren().add(hBox);

        Scene scene = new Scene(root);
 
        primaryStage.setTitle("List Change Listener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}