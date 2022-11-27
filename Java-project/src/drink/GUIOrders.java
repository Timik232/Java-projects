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
        private final Color[] colors = {Color.CYAN, Color.lightGray, Color.GRAY};
        private final String[] columnNames = {"Добавить заказ", "Добавить интернет-заказ", "Удалить","Открыть"};
        public JPanel dishMenu(JPanel panel){
            panel.setLayout(new GridLayout());

            return panel;
        }
        public GUIOrders(){
             /*frame = new JFrame("Restaurant");
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);*/
             super("Restaurant");
            JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.BOTTOM,
                    JTabbedPane.SCROLL_TAB_LAYOUT);
            /*for (int i = 0; i < 3; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(colors[i]);
                panel.add(new JLabel(String.format(actions[i],i)));
                panel = dishMenu(panel);
                tabsLeft.addTab(tabs[i],panel);
            }*/
            getContentPane().setLayout(new GridLayout());
            getContentPane().add(tabsLeft);
            setSize(600,250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }



}
