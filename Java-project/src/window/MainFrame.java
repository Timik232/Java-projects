package window;
//22
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Scanner;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame {

    final JLabel img;
    public MainFrame(String name){
        this.setSize(500, 1000);
        img = new JLabel("", new ImageIcon(getClass().getResource(name)), SwingConstants.CENTER);
        getContentPane().add(img);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the image: ");
        String s = scanner.nextLine();
        MainFrame image = new MainFrame(s);
        image.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        image.setVisible(true);
    }
}