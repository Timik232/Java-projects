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
        private int depth;
        private final Color[] colors = {Color.CYAN, Color.lightGray, Color.GRAY};
        private final String[] columnNames = {"Добавить заказ", "Добавить интернет-заказ", "Удалить","Открыть"};
        public JPanel dishMenu(JPanel panel){
            panel.setLayout(new GridLayout());

            return panel;
        }
        public static  void GUIAddOrder(){
            JFrame frame = new JFrame("Добавить заказ");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setBackground(Color.DARK_GRAY);
            JLabel label = new JLabel("Введите номер столика");
            label.setBounds(10, 0, 200, 20);
            JTextField textField = new JTextField("Введите номер столика");
            frame.add(textField);
            JButton button = new JButton("Добавить");
            button.setLayout(null);
            button.setBounds(70, 50, 75, 30);
            final JTextField smallField = new JTextField(15);
            smallField.setBounds(70, 20, 75, 30);
            //mouselistener button
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    int number = Integer.parseInt(smallField.getText());
                    TableOrdersManager tableOrdersManager = new TableOrdersManager();
                    tableOrdersManager.add(new Order(), number);
                    frame.dispose();
                }
            });
            frame.add(smallField);
            frame.add(button);
            frame.add(label);
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
            panel.setLayout(new GridLayout(0,4,5,10));
            getContentPane().setBackground(Color.lightGray);
            for (int i = 0; i < 4; i++) {
                JButton button = new JButton(columnNames[i]);
                //button.setBackground(colors[0]);
                button.addActionListener(e -> {
                    if (e.getSource() == button) {
                        if (button.getText().equals("Добавить заказ")) {
                            //new GUIAddOrder();
                            System.out.println(1);
                        } else if (button.getText().equals("Добавить интернет-заказ")) {
                            //new GUIAddInternetOrder();
                            System.out.println(2);
                        } else if (button.getText().equals("Удалить")) {
                            //new GUIDeleteOrder();
                            System.out.println(3);
                        } else if (button.getText().equals("Открыть")) {
                            //new GUIOpenOrder();
                            System.out.println(4);
                        }
                    }
                });
                panel.add(button);
            }
            getContentPane().add(panel);
            getContentPane().add
            setSize(600,700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }



}
