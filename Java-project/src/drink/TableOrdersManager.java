package drink;

import java.awt.*;
import java.util.Arrays;

public class TableOrdersManager implements OrdersManager{

    private int size = 0;
    Order[] orders = new Order[size];
    int elemCount=0;

    public boolean add(Order order, int tableNumber) {
        if (tableNumber>=size) {
            System.arraycopy(orders, 0, orders = new Order[tableNumber+1], 0, size);
            size = tableNumber+1;
        }
        if (orders[tableNumber]==null)
            elemCount++;
        orders[tableNumber] = order;
        return true;
    }
    public boolean addItem(MenuItem item, int tableNumber) {
        if (orders[tableNumber]!=null) {
            orders[tableNumber].add(item);
            return true;
        }
        return false;
    }
    public Order getOrder(int tableNumber) {
        return orders[tableNumber];
    }

    public boolean remove(int tableNumber) {
        orders[tableNumber]=null;
        elemCount--;
        return true;
    }


    public boolean remove(Order order) {
        for (int i = 0; i<size;i++){
            if (orders[i]==order){
                remove(i);
                elemCount--;
                return true;
            }
        }
        return false;
    }


    public int removeAll(Order order) {
        int count = 0;
        for (int i = 0; i<size;i++){
            if (orders[i]==order){
                remove(i);
                count++;
                elemCount--;
            }
        }
        return count;
    }


    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i]!=null){
                quantity+= orders[i].itemsQuantity(itemName);
            }
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int quantity = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i]!=null){
                quantity+= orders[i].itemsQuantity(item);
            }
        }
        return quantity;
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int summary = 0;
        for (int i = 0; i < size; i++) {
            if (orders[i]!=null){
                summary+= orders[i].costTotal();
            }
        }
        return summary;
    }

    @Override
    public int ordersQuantity() {
        return elemCount;
    }
}
