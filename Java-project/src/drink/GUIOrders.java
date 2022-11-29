package drink;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class GUIOrders extends JFrame{
        private JFrame frame;
        private JTable table;
        private JPanel mainPanel;

        private final Color[] colors = {Color.CYAN, Color.lightGray, Color.GRAY};
        private final String[] commands = {"Добавить заказ",  "Удалить","Открыть"};
        private final String[] columnNames = {"Тип заказа", "Имя-фамилия заказчика", "Стоимость"};
        private String[][] data = {{"","",""}, {"","",""}, {"","",""}};
        private Customer[] customers = new Customer[0];
        private TableOrdersManager tableOrdersManager = new TableOrdersManager();
        private InternetOrdersManager internetOrdersManager = new InternetOrdersManager();

        private void AddOrder(){

        }

        private boolean guiAddDrinkOrder(Order order, boolean isInternetOrder){
            try {
                String name = JOptionPane.showInputDialog("Введите название напитка");
                if (name == null) return false;
                String cost = JOptionPane.showInputDialog("Введите цену напитка");
                if (cost == null) return false;
                String description = JOptionPane.showInputDialog("Введите описание напитка");
                if (description == null) return false;
                String degrees = JOptionPane.showInputDialog("Введите крепость напитка");
                if (degrees == null) return false;
                if (Double.parseDouble(degrees) > 100 || Double.parseDouble(degrees) < 0) {
                    JOptionPane.showMessageDialog(null, "Некорректная крепость напитка");
                    return false;
                }
                if (isInternetOrder) {
                    if (Double.parseDouble(degrees) > 0.05) {
                        JOptionPane.showMessageDialog(null, "Нельзя заказывать алкоголь через интернет");
                        return false;
                    }
                }
                if (Double.parseDouble(degrees) > 0.05) {
                    if (customers[customers.length - 1].getAge() < 18) {
                        JOptionPane.showMessageDialog(null, "Нельзя заказывать алкоголь несовершеннолетним");
                        return false;
                    }
                    if (JOptionPane.showConfirmDialog(null, "Подтвердите заказ алкоголя") == JOptionPane.NO_OPTION) {
                        return false;
                    }
                }
                ArrayList arr = new ArrayList<DrinkTypeEnum>(Arrays.asList(DrinkTypeEnum.values()));
                JFrame choose = new JFrame("тип напитка");
                JComboBox comboBox = new JComboBox(arr.toArray());
                comboBox.setBounds(50, 20, 100, 20);
                choose.add(comboBox);
                choose.setSize(180, 100);
                choose.setLayout(null);
                choose.setBackground(Color.DARK_GRAY);
                choose.setVisible(true);
                JButton button = new JButton("OK");
                button.setBounds(50, 50, 100, 30);
                choose.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DrinkTypeEnum drinkTypeEnum = (DrinkTypeEnum) comboBox.getSelectedItem();
                        Drink drink = new Drink(Integer.parseInt(cost), name, description, Double.parseDouble(degrees), drinkTypeEnum);
                        order.add(drink);
                        choose.dispose();
                    }
                });
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Некорректный ввод");
                return false;
            }
            return true;
        }
        private boolean guiAddFoodOrder(Order order){
            try {
                String name = JOptionPane.showInputDialog("Введите название блюда");
                if (name == null) return false;
                String cost = JOptionPane.showInputDialog("Введите цену блюда");
                if (cost == null) return false;
                String description = JOptionPane.showInputDialog("Введите описание блюда");
                if (description == null) return false;
                Dish dish = new Dish(Integer.parseInt(cost), name, description);
                order.add(dish);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ошибка ввода");
            }
            return true;
        }
        private void guiAddInternetOrder(){
            if (!addCustomer(true)){
                JOptionPane.showMessageDialog(null, "Отмена заказа");
                return;
            }
            JFrame internetOrder = new JFrame("Добавить заказ");
            internetOrder.setSize(200, 150);
            internetOrder.setLayout(null);
            internetOrder.setResizable(false);
            internetOrder.setLocationRelativeTo(null);
            internetOrder.setBackground(Color.DARK_GRAY);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Напиток");
            comboBox.addItem("Еда");
            JButton button = new JButton("Добавить");
            JButton cancel = new JButton("Готово");
            comboBox.setBounds(15, 10, 150, 20);
            button.setBounds(15, 40, 150, 20);
            cancel.setBounds(15, 70, 150, 20);
            InternetOrder order = new InternetOrder();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (comboBox.getSelectedItem().equals("Напиток")){
                        if (guiAddDrinkOrder(order,true)) {
                            JOptionPane.showMessageDialog(null, "Напиток добавлен");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Напиток не был добавлен");
                        }
                    } else if (comboBox.getSelectedItem().equals("Еда")){
                        if (guiAddFoodOrder(order)){
                            JOptionPane.showMessageDialog(null, "Блюдо добавлено");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Блюдо не было добавлено");
                        }
                    }
                }
            });
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (order.itemsQuantity() == 0)
                        if (JOptionPane.showConfirmDialog(null, "Вы не составили заказ, вы уверены, что хотите выйти?") == JOptionPane.YES_OPTION){
                        internetOrder.dispose();
                    }
                    internetOrdersManager.add(order);
                    table.add(new JLabel(customers[customers.length - 1].toString()));
                    internetOrder.dispose();
                }
            });
            internetOrder.add(comboBox);
            internetOrder.add(button);
            internetOrder.add(cancel);
            internetOrder.setVisible(true);
        }
        private boolean guiAddRestaurantOrder(){
            if (!addCustomer(false)){
                JOptionPane.showMessageDialog(null, "Отмена заказа");
                return false;
            }
            JFrame restaurantOrder = new JFrame("Добавить заказ");
            restaurantOrder.setSize(200, 150);
            restaurantOrder.setLayout(null);
            restaurantOrder.setResizable(false);
            restaurantOrder.setLocationRelativeTo(null);
            restaurantOrder.setBackground(Color.DARK_GRAY);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Напиток");
            comboBox.addItem("Еда");
            //JTextField smallField = new JTextField();

            JButton button = new JButton("Добавить");
            JButton cancel = new JButton("Готово");
            comboBox.setBounds(15, 10, 150, 20);
            //smallField.setBounds(15, 40, 150, 20);
            button.setBounds(15, 40, 150, 20);
            cancel.setBounds(15, 70, 150, 20);
            TableOrder order = new TableOrder();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (comboBox.getSelectedItem().equals("Напиток")){
                        if (guiAddDrinkOrder(order,false)) {
                            JOptionPane.showMessageDialog(null, "Напиток добавлен");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Напиток не был добавлен");
                        }
                    } else if (comboBox.getSelectedItem().equals("Еда")){
                        if (guiAddFoodOrder(order)){
                            JOptionPane.showMessageDialog(null, "Блюдо добавлено");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Блюдо не было добавлено");
                        }
                    }
                }
            });
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (order.itemsQuantity() == 0)
                        if (JOptionPane.showConfirmDialog(null, "Вы не составили заказ, вы уверены, что хотите выйти?") == JOptionPane.YES_OPTION){
                            restaurantOrder.dispose();
                            return;
                        }
                    String tableNumber = JOptionPane.showInputDialog("Введите номер столика");
                    try {
                        tableOrdersManager.add(order, Integer.parseInt(tableNumber));
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Неверный формат номера стола");
                        return;
                    }
                    table.add(new JLabel(customers[customers.length - 1].toString()));
                    restaurantOrder.dispose();
                }
            });
            restaurantOrder.add(comboBox);
            restaurantOrder.add(button);
            restaurantOrder.add(cancel);
            //restaurantOrder.add(smallField);
            restaurantOrder.setVisible(true);
            return true;
        }
        private boolean addCustomer(boolean isInternet){
            try {
                String name = JOptionPane.showInputDialog("Введите имя заказчика");
                if (name == null) return false;
                String surname = JOptionPane.showInputDialog("Введите фамилию заказчика");
                if (surname == null) return false;
                String age = JOptionPane.showInputDialog("Введите возраст заказчика");
                if (age == null) return false;
                if (Integer.parseInt(age) <= 0 || Integer.parseInt(age) >=150) throw new IllegalArgumentException("Возраст должен быть больше 0 и  меньше 150");
                String bufAddress = "-1";
                if (isInternet) {
                    bufAddress = JOptionPane.showInputDialog("Введите адрес заказчика в формате: город, почтовый индекс, улица, дом, квартира через пробелы");
                    if (bufAddress == null) return false;
                }
                if (name.equals("") || surname.equals("") || age.equals("") || bufAddress.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Вы не ввели данные");
                    return false;
                }
                String[] splitAddress = bufAddress.trim().split(" ");
                Address address;
                if (isInternet) {
                    address = new Address(splitAddress[0], Integer.parseInt(splitAddress[1]), splitAddress[2], Integer.parseInt(splitAddress[3]), Integer.parseInt(splitAddress[4]));
                }
                else{
                    address = Address.EMPTY_ADDRESS;
                }
                Customer customer = new Customer(name, surname, Integer.parseInt(age), address);
                //System.arraycopy(customers,0, customers = new Customer[customers.length + 1],0, customers.length);
                customers = Arrays.copyOf(customers, customers.length + 1);
                customers[customers.length - 1] = customer;
            }
            catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(frame, e.getMessage());
                return false;
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(frame, "Неверный формат ввода");
                return false;
            }
        return true;
        }
        private JFrame guiAddOrder(){
            frame = new JFrame("Добавить заказ");
            frame.setSize(200, 150);
            frame.setLayout(null);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setBackground(Color.DARK_GRAY);
            //add combobox
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Интернет заказ");
            comboBox.addItem("Заказ в ресторане");
            JButton button = new JButton("Выбрать");
            comboBox.setBounds(15, 10, 150, 20);
            button.setBounds(15, 40, 150, 20);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (comboBox.getSelectedItem().equals("Интернет заказ")){
                        frame.dispose();
                        guiAddInternetOrder();
                    }
                    else if (comboBox.getSelectedItem().equals("Заказ в ресторане")){
                        frame.dispose();
                        guiAddRestaurantOrder();
                    }
                }
            });
            frame.add(comboBox);
            frame.add(button);
            frame.setVisible(true);
            return frame;
        }


        public GUIOrders(){

             super("Restaurant");
            JPanel panel = new JPanel();
            setSize(700,700);
            panel.setLayout(new GridLayout(10,5,5,10));
            //panel.setLayout(new FlowLayout());
            getContentPane().setBackground(Color.lightGray);
            table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 5; j++){
                    panel.add(new JLabel(""));
                }
            }
            panel.add(new JLabel(""));
            for (int i = 0; i < 3; i++) {
                JButton button = new JButton(commands[i]);
                button.setBounds(10, 10, 100, 20);
                //button.setBackground(colors[0]);
                if (i == 0) {
                    button.setBounds(10, 500, 100, 20);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            
                            guiAddOrder();
                        }
                    });
                }
                else if (i == 1) {
                    button.setBounds(110, 500, 100, 20);
                    button.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            System.out.println(2);
                        }
                    });
                }
                else  {
                    button.setBounds(210, 500, 100, 20);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            System.out.println(3);
                        }
                    });
                }

                panel.add(button, BorderLayout.SOUTH);
            }
            getContentPane().add(panel);
            getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }



}
