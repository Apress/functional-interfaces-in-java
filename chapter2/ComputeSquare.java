package chapter2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class ComputeSquare extends JFrame 
{
    JTextField number;
    JTextField square;
    JButton submit;
    JPanel panel;
    public ComputeSquare()
    {
        number = new JTextField(10);
        square = new JTextField(10);
        submit = new JButton("Submit");



        submit.addActionListener( x -> {
            try {
                int num = Integer.parseInt(number.getText());
                square.setText(Integer.toString(num*num));
            } 
            catch (NumberFormatException e) {
                System.out.println(number.getText() 
                                 + " is not a number");
            }
        });

        panel = new JPanel();
        setSize(200,130);
        panel.add(number);
        panel.add(square);
        panel.add(submit);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new ComputeSquare();
    }
}
