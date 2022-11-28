package drink;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;


public class GUIOrders extends JFrame{ //gui for OrderManager
        private JFrame frame;
        private JPanel mainPanel;
        private int depth;
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
             depth = 0;
            /*JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.BOTTOM,
                   JTabbedPane.SCROLL_TAB_LAYOUT);*/
            /*for (int i = 0; i < 3; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(colors[i]);
                panel.add(new JLabel(String.format(actions[i],i)));
                panel = dishMenu(panel);
                tabsLeft.addTab(tabs[i],panel);
            }*/
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3,4,5,10));
            getContentPane().setBackground(Color.lightGray);
            panel.add(new JLabel(""));
            for (int i = 0; i < 4; i++) {
                JButton button = new JButton(columnNames[i]);
                //button.setBackground(colors[0]);
                if (i == 0) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(1);
                        }
                    });
                }
                else if (i == 1) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(2);
                        }
                    });
                }
                else if (i == 2) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(3);
                        }
                    });
                }
                else if (i == 3) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(4);
                        }
                    });
                }
                panel.add(button);
            }
            getContentPane().add(panel);

            setSize(600,700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }



}
