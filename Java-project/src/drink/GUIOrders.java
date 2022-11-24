package drink;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;


public class GUIOrders extends JFrame{ //gui for OrderManager
        private JFrame frame;
        private JPanel mainPanel;

        public GUIOrders(){
             frame = new JFrame("Restaurant");
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);

            JPanel content = new JPanel();
            content.setLayout(new BorderLayout());

            JPanel buttons = new JPanel();
            content.add(buttons, BorderLayout.NORTH);

        }



}
