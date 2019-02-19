package chapter15;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;
import java.util.*;

public class TestBuilderFactory extends Application 
{
    ArrayList<Node> list;
    Builder<?> getBuilder(String className)
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

        Class c = null;
        if (className.equals("Label"))
            c = new Label().getClass();
        if (className.equals("Button"))
            c = new Button().getClass();
        
        BuilderFactory factory = x -> {
            if (x == Label.class)
                return labelBuilder;
            else if (x == Button.class)
                return buttonBuilder;
            return null;
        };
        
        return factory.getBuilder(c);
    }

    void addComponent(String name)
    {
        Builder<?> builder = getBuilder(name);
        if (builder != null)
            list.add((Node)builder.build());
    }

    @Override
    public void start(Stage primaryStage) 
    {
        list = new ArrayList<>();
        VBox box = new VBox();
        
        Scanner keyboard = new Scanner(System.in);
        String name = "";
        while (!name.equals("Quit"))
        {
            System.out.print(
                "Enter component name(Enter Quit when finished):");
            name = keyboard.nextLine();
            if (!name.equals("Quit"))
                addComponent(name);
        }

        Node[] nodes = new Node[list.size()];
        list.toArray(nodes);
        box.getChildren().addAll(nodes);
        
        StackPane root = new StackPane();
        root.getChildren().add(box);

        Scene scene = new Scene(root, 250, 100);
 
        primaryStage.setTitle("Test Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}