package guessgame;
//23
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.random.*;
public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess the number");
        frame.setSize(260, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.DARK_GRAY);
        JLabel label = new JLabel("Enter number from 0 to 20 (including)");
        label.setBounds(10, 0, 200, 20);
        JTextField textField = new JTextField("Enter number from 0 to 20 (including");
        frame.add(textField);
        JButton button = new JButton("Guess");
        button.setLayout(null);
        button.setBounds(70, 50, 75, 30);
        JTextField smallField = new JTextField(15);
        smallField.setBounds(70, 20, 75, 30);
        //mouselistener button

        int random = (int) (Math.random() * 20);
        final int[] count = {0};
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(smallField.getText());
                if (number == random) {
                    JOptionPane.showMessageDialog(frame, "You guessed the number!");
                } else if (number > random) {
                    JOptionPane.showMessageDialog(frame, "The number is smaller");
                } else if (number < random) {
                    JOptionPane.showMessageDialog(frame, "The number is bigger");
                }
                count[0] += 1;
                if (count[0] == 3) {
                    JOptionPane.showMessageDialog(frame, "You lost");
                    System.exit(0);
                }
            }
        });
        frame.add(smallField);
        frame.add(button);
        frame.add(label);

    }
}
