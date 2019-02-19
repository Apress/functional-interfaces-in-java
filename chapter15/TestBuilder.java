package chapter15;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Builder;
import java.util.Scanner;

public class TestBuilder extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        Builder<Label> labelBuilder = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter label name:");
            return new Label(input.nextLine());
        };

        Builder<Button> buttonBuilder = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter button name:");
            return new Button(input.nextLine());
        };

        VBox box = new VBox();
        box.getChildren().addAll(labelBuilder.build(),
                                 buttonBuilder.build());
        
        StackPane root = new StackPane();
        root.getChildren().add(box);

        Scene scene = new Scene(root, 250, 100);
 
        primaryStage.setTitle("Test Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}