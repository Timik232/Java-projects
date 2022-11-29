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
        private String[][] data = new String[40][3];
        int tableSize = 0;

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
                if (Integer.parseInt(cost) < 0) {
                    JOptionPane.showMessageDialog(null, "Некорректная цена напитка");
                    return false;
                }
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
                choose.add(comboBox);
                choose.setSize(160, 140);
                comboBox.setBounds(20, 20, 100, 20);
                choose.setLayout(null);
                choose.setBackground(Color.DARK_GRAY);
                choose.setLocationRelativeTo(null);
                choose.setVisible(true);
                JButton button = new JButton("OK");
                button.setBounds(20, 50, 100, 30);
                choose.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DrinkTypeEnum drinkTypeEnum = (DrinkTypeEnum) comboBox.getSelectedItem();
                        Drink drink = new Drink(Integer.parseInt(cost), name, description, Double.parseDouble(degrees), drinkTypeEnum);
                        order.add(drink);
                        JOptionPane.showMessageDialog(null, "Напиток добавлен");
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
                if (Integer.parseInt(cost) < 0) {
                    JOptionPane.showMessageDialog(null, "Некорректная цена блюда");
                    return false;
                }
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
                            //JOptionPane.showMessageDialog(null, "Напиток добавлен");
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
                    if (order.itemsQuantity() == 0){
                        if (JOptionPane.showConfirmDialog(null, "Вы не составили заказ, вы уверены, что хотите выйти?") == JOptionPane.YES_OPTION) {
                            internetOrder.dispose();
                        }
                        else {
                            return;
                        }
                    }
                    order.setCustomer(customers[customers.length - 1]);
                    internetOrdersManager.add(order);
                    data[tableSize][0] = "Заказ в Интернете";
                    data[tableSize][1] = customers[customers.length - 1].getFirstName() + " " + customers[customers.length - 1].getSecondName();
                    data[tableSize][2] = String.valueOf(order.costTotal());
                    table.repaint();
                    //System.arraycopy(data, 0, data = new String[data.length + 1][3], 0, data.length-1);
                    tableSize++;
                    JOptionPane.showMessageDialog(null, "Заказ добавлен");
                    internetOrder.dispose();
                }
            });
            internetOrder.add(comboBox);
            internetOrder.add(button);
            internetOrder.add(cancel);
            internetOrder.setVisible(true);
        }
        private void guiAddRestaurantOrder(){
            if (!addCustomer(false)){
                JOptionPane.showMessageDialog(null, "Отмена заказа");
                return ;
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
            JButton button = new JButton("Добавить");
            JButton cancel = new JButton("Готово");
            comboBox.setBounds(15, 10, 150, 20);
            button.setBounds(15, 40, 150, 20);
            cancel.setBounds(15, 70, 150, 20);
            TableOrder order = new TableOrder();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (comboBox.getSelectedItem().equals("Напиток")){
                        if (guiAddDrinkOrder(order,false)) {
                            //JOptionPane.showMessageDialog(null, "Напиток добавлен");
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
                        else {
                            return;
                        }
                    while (true) {
                        boolean flag = true;
                        String tableNumber = JOptionPane.showInputDialog("Введите номер столика");
                        if (tableNumber == null) {
                            return;
                        }
                        try {
                        if (Integer.parseInt(tableNumber) < 0 || Integer.parseInt(tableNumber) > 1000) {
                            JOptionPane.showMessageDialog(null, "Неверный номер стола");
                            flag = false;
                            continue;
                        }
                        if (!tableNumber.matches("[0-9]+")) {
                            JOptionPane.showMessageDialog(null, "Неверный формат номера стола");
                            flag = false;
                            continue;
                        }
                            order.setCustomer(customers[customers.length - 1]);
                            tableOrdersManager.add(order, Integer.parseInt(tableNumber));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Неверный формат номера стола");
                            flag = false;
                            continue;
                        }
                        if (flag)
                            break;
                    }
                    data[tableSize][0] = "Заказ в ресторане";
                    data[tableSize][1] = customers[customers.length - 1].getFirstName() + " " + customers[customers.length - 1].getSecondName();
                    data[tableSize][2] = String.valueOf(order.costTotal());
                    table.repaint();
                    //System.arraycopy(data, 0, data = new String[data.length + 1][3], 0, data.length-1);
                    tableSize++;
                    JOptionPane.showMessageDialog(null, "Заказ добавлен");
                    restaurantOrder.dispose();
                }
            });
            restaurantOrder.add(comboBox);
            restaurantOrder.add(button);
            restaurantOrder.add(cancel);
            //restaurantOrder.add(smallField);
            restaurantOrder.setVisible(true);
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
        private void guiAddOrder(){
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
        }

        private void guiDeleteOrder(){
            if (internetOrdersManager.ordersQuantity() == 0 && tableOrdersManager.ordersQuantity() == 0){
                JOptionPane.showMessageDialog(frame, "Нет заказов");
                return;
            }
            JFrame deleteOrder = new JFrame("Удалить заказ");
            deleteOrder.setSize(300, 150);
            deleteOrder.setLayout(null);
            deleteOrder.setResizable(false);
            deleteOrder.setLocationRelativeTo(null);
            deleteOrder.setBackground(Color.DARK_GRAY);
            JComboBox comboBox = new JComboBox();
            Order[] orders = new Order[internetOrdersManager.ordersQuantity() + tableOrdersManager.ordersQuantity()];
            int count = 0;
            for (Order O : internetOrdersManager.getOrders()){
                if (O != null) {
                    orders[count] = O;
                    comboBox.addItem("Интернет: " + orders[count].getCustomer().getFirstName() + " " + orders[count].getCustomer().getSecondName());
                    count++;
                }
            }
            int tableNumber = 0;
            for (Order O : tableOrdersManager.getOrders()){
                if (O != null) {
                    orders[count] = O;
                    comboBox.addItem("Столик " + tableNumber + ": " + orders[count].getCustomer().getFirstName() + " " + orders[count].getCustomer().getSecondName());
                    count++;
                }
                tableNumber++;
            }
            final Order[] finalOrders = orders;
            JButton button = new JButton("Удалить");
            comboBox.setBounds(25, 20, 250, 20);
            button.setBounds(25, 50, 250, 20);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (JOptionPane.showConfirmDialog(null, "Вы уверены, что хотите удалить заказ?") == JOptionPane.YES_OPTION) {
                        if (comboBox.getSelectedItem().toString().contains("Интернет")) {
                            internetOrdersManager.remove(finalOrders[comboBox.getSelectedIndex()]);
                            //delete data from table
                            for (int i = 0; i < table.getRowCount(); i++) {
                                if (data[i][0].contains("Интернет")) {
                                    if (data[i][1].equals(finalOrders[comboBox.getSelectedIndex()].getCustomer().getFirstName() + " " + finalOrders[comboBox.getSelectedIndex()].getCustomer().getSecondName())) {
                                        data[i][0] = "";
                                        data[i][1] = "";
                                        data[i][2] = "";
                                        for (int j = i; j < table.getRowCount() - 1; j++) {
                                            data[j][0] = data[j + 1][0];
                                            data[j][1] = data[j + 1][1];
                                            data[j][2] = data[j + 1][2];
                                        }
                                        data[table.getRowCount() - 1][0] = "";
                                        data[table.getRowCount() - 1][1] = "";
                                        data[table.getRowCount() - 1][2] = "";
                                        table.repaint();
                                        tableSize--;
                                        break;
                                    }
                                }
                            }
                        } else if (comboBox.getSelectedItem().toString().contains("Столик")) {
                            System.out.println(1);
                            tableOrdersManager.remove(finalOrders[comboBox.getSelectedIndex()]);
                            for (int i = 0; i < table.getRowCount(); i++) {
                                if (data[i][0].contains("ресторан")) {
                                    //System.out.println(finalOrders[comboBox.getSelectedIndex()].getCustomer().getFirstName() + " " + finalOrders[comboBox.getSelectedIndex()].getCustomer().getSecondName());
                                    if (data[i][1].equals(finalOrders[comboBox.getSelectedIndex()].getCustomer().getFirstName() + " " + finalOrders[comboBox.getSelectedIndex()].getCustomer().getSecondName())) {
                                        data[i][0] = "";
                                        data[i][1] = "";
                                        data[i][2] = "";
                                        for (int j = i; j < table.getRowCount() - 1; j++) {
                                            data[j][0] = data[j + 1][0];
                                            data[j][1] = data[j + 1][1];
                                            data[j][2] = data[j + 1][2];
                                        }
                                        data[table.getRowCount() - 1][0] = "";
                                        data[table.getRowCount() - 1][1] = "";
                                        data[table.getRowCount() - 1][2] = "";
                                        table.repaint();
                                        tableSize--;
                                        break;
                                    }
                                }
                            }
                        }
                        deleteOrder.dispose();
                    }

                }

            });
            deleteOrder.add(comboBox);
            deleteOrder.add(button);
            deleteOrder.setVisible(true);
        }
        private void guiOpenInternetOrder(InternetOrder order){
            JFrame internetOrder = new JFrame("Интернет заказ");
            internetOrder.setSize(300, 300);
            internetOrder.setLayout(null);
            internetOrder.setResizable(false);
            internetOrder.setLocationRelativeTo(null);
            internetOrder.setBackground(Color.DARK_GRAY);
            JLabel label = new JLabel("Заказчик: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getSecondName());
            label.setBounds(20, 20, 250, 20);
            JLabel label1 = new JLabel("Адрес: \n" + "Город " + order.getCustomer().getAddress().getCityName() + ", улица " + order.getCustomer().getAddress().getStreetName() + ",");
            label1.setBounds(20, 40, 250, 15);
            JLabel label11 = new JLabel("дом " + order.getCustomer().getAddress().getBuildingNumber() + ", квартира " + order.getCustomer().getAddress().getApartmentNumber());
            label11.setBounds(20, 55, 250, 15);
            JLabel label2 = new JLabel("Стоимость: " + order.costTotal());
            label2.setBounds(20, 70, 250, 20);
            JLabel label3 = new JLabel("Количество блюд: " + order.itemsQuantity());
            label3.setBounds(20, 90, 250, 20);
            JButton button = new JButton("Удалить");
            button.setBounds(20, 120, 250, 20);
            JButton button1 = new JButton("Посмотреть заказ");
            button1.setBounds(20, 150, 250, 20);
            JButton button2 = new JButton("Готово");
            button2.setBounds(20, 180, 250, 20);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    internetOrder.dispose();
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    MenuItem[] items = order.sortedItemsByCostDesc();
                    String printItems = "";
                    for (int i = 0; i < items.length; i++){
                        printItems += items[i].toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(frame, printItems);
                }
            });
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (JOptionPane.showConfirmDialog(null, "Вы уверены, что хотите удалить заказ?") == JOptionPane.YES_OPTION){
                        System.out.println("Удаление заказа");
                        for (int i = 0; i < table.getRowCount(); i++){
                            System.out.println(data[i][1] + " " + order.getCustomer().getFirstName() + " " + order.getCustomer().getSecondName());
                            if (data[i][1].equals(order.getCustomer().getFirstName() + " " + order.getCustomer().getSecondName())){
                                System.out.println(1);
                                data[i][0] = "";
                                data[i][1] = "";
                                data[i][2] = "";
                                for (int j = i; j < table.getRowCount() - 1; j++){
                                    data[j][0] = data[j + 1][0];
                                    data[j][1] = data[j + 1][1];
                                    data[j][2] = data[j + 1][2];
                                }
                                data[table.getRowCount() - 1][0] = "";
                                data[table.getRowCount() - 1][1] = "";
                                data[table.getRowCount() - 1][2] = "";
                                table.repaint();
                                tableSize--;
                                break;
                            }
                        }
                        internetOrdersManager.remove(order);
                        internetOrder.dispose();
                    }
                }
            });
            internetOrder.add(label);
            internetOrder.add(label1);
            internetOrder.add(label11);
            internetOrder.add(label2);
            internetOrder.add(label3);
            internetOrder.add(button);
            internetOrder.add(button1);
            internetOrder.add(button2);
            internetOrder.setVisible(true);
        }
        private void guiOpenTableOrder(TableOrder order,int i){
            JFrame tableOrder = new JFrame("Столик " + i);
            tableOrder.setSize(300, 300);
            tableOrder.setLayout(null);
            tableOrder.setResizable(false);
            tableOrder.setLocationRelativeTo(null);
            tableOrder.setBackground(Color.DARK_GRAY);
            JLabel label = new JLabel("Заказчик: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getSecondName());
            label.setBounds(20, 20, 250, 20);
            JLabel label2 = new JLabel("Стоимость: " + order.costTotal());
            label2.setBounds(20, 40, 250, 20);
            JLabel label3 = new JLabel("Количество блюд: " + order.itemsQuantity());
            label3.setBounds(20, 60, 250, 20);
            JButton button = new JButton("Удалить");
            button.setBounds(20, 80, 250, 20);
            JButton button1 = new JButton("Посмотреть заказ");
            button1.setBounds(20, 110, 250, 20);
            JButton button2 = new JButton("Готово");
            button2.setBounds(20, 140, 250, 20);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tableOrder.dispose();
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    MenuItem[] items = order.sortedItemsByCostDesc();
                    String printItems = "";
                    for (int i = 0; i < items.length; i++){
                        printItems += items[i].toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(frame, printItems);
                }
            });
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (JOptionPane.showConfirmDialog(null, "Вы уверены, что хотите удалить заказ?") == JOptionPane.YES_OPTION){
                        tableOrdersManager.remove(order);
                        tableOrder.dispose();
                    }
                }
            });
            tableOrder.add(label);
            tableOrder.add(label2);
            tableOrder.add(label3);
            tableOrder.add(button);
            tableOrder.add(button1);
            tableOrder.add(button2);
            tableOrder.setVisible(true);
        }
        private void guiOpenOrder(){
            if (internetOrdersManager.ordersQuantity() == 0 && tableOrdersManager.ordersQuantity() == 0){
                JOptionPane.showMessageDialog(frame, "Нет заказов");
                return;
            }
            JFrame openOrder = new JFrame("Открыть заказ");
            openOrder.setSize(300, 150);
            openOrder.setLayout(null);
            openOrder.setResizable(false);
            openOrder.setLocationRelativeTo(null);
            openOrder.setBackground(Color.DARK_GRAY);
            JComboBox comboBox = new JComboBox();
            Order[] orders = new Order[internetOrdersManager.ordersQuantity() + tableOrdersManager.ordersQuantity()];
            int count = 0;
            for (Order O : internetOrdersManager.getOrders()){
                if (O != null) {
                    orders[count] = O;
                    comboBox.addItem("Интернет: " + orders[count].getCustomer().getFirstName() + " " + orders[count].getCustomer().getSecondName());
                    count++;
                }
            }
            int tableNumber = 0;
            for (Order O : tableOrdersManager.getOrders()){
                if (O != null) {
                    orders[count] = O;
                    comboBox.addItem("Столик " + tableNumber + " : " + orders[count].getCustomer().getFirstName() + " " + orders[count].getCustomer().getSecondName());
                    count++;
                }
                tableNumber++;
            }
            final Order[] finalOrders = orders;
            JButton button = new JButton("Открыть");
            comboBox.setBounds(25, 20, 250, 20);
            button.setBounds(25, 50, 250, 20);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (comboBox.getSelectedItem().toString().contains("Интернет")){
                        guiOpenInternetOrder((InternetOrder) finalOrders[comboBox.getSelectedIndex()]);
                    }
                    else if (comboBox.getSelectedItem().toString().contains("Столик")){
                        String[] splitted = comboBox.getSelectedItem().toString().split(" ");
                        guiOpenTableOrder((TableOrder) finalOrders[comboBox.getSelectedIndex()], Integer.parseInt(splitted[1]));
                    }
                    openOrder.dispose();
                }
            });
            openOrder.add(comboBox);
            openOrder.add(button);
            openOrder.setVisible(true);
        }
        public GUIOrders(){

             super("Restaurant");
            for (int i = 0; i < 40; i++) {
                data[i][0] = "";
                data[i][1] = "";
                data[i][2] = "";
            }
            JPanel panel = new JPanel();
            setSize(700,650);
            panel.setLayout(new GridLayout(10,5,5,10));
            //panel.setLayout(new FlowLayout());
            getContentPane().setBackground(Color.lightGray);
            table = new JTable(data, columnNames);
            table.setBounds(0, 20, 700, 500);
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

                            guiDeleteOrder();
                        }
                    });
                }
                else  {
                    button.setBounds(210, 500, 100, 20);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            guiOpenOrder();
                        }
                    });
                }

                panel.add(button, BorderLayout.SOUTH);
            }

            getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
            getContentPane().add(table, BorderLayout.CENTER);
            getContentPane().add(scrollPane);
            getContentPane().add(panel);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }
}
