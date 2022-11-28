package drink;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TableOrder implements Order{
    private int size;
    MenuItem[] items = new MenuItem[size];
    Customer customer;
    @Override
    public boolean add(MenuItem item) {
        System.arraycopy(items, 0, items = new MenuItem[size + 1], 0, size);
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[size];
        for (int i = 0; i <size; i++){
            names[i] = items[i].getName();
        }
        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        for (MenuItem i : items){
            if (i.name.equals(itemName))
                quantity++;
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int quantity = 0;
        for (MenuItem i : items){
            if (i==item)
                quantity++;
        }
        return quantity;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        int remPos = -1;
        for (int i = 0; i<size;i++){
            if (items[i].getName().equals(itemName)){
                remPos = i;
                break;
            }
        }
        MenuItem[] tmpItems;
        System.arraycopy(items, 0, tmpItems = new MenuItem[size-1], 0, remPos-1);
        System.arraycopy(items, remPos+1, tmpItems, remPos, size-remPos-1);
        items = tmpItems;
        size--;
        return true;
    }

    @Override
    public boolean remove(MenuItem item) {
        int remPos = -1;
        for (int i = 0; i<size;i++){
            if (items[i]==item){
                remPos = i;
                break;
            }
        }
        MenuItem[] tmpItems;
        System.arraycopy(items, 0, tmpItems = new MenuItem[size-1], 0, remPos-1);
        System.arraycopy(items, remPos+1, tmpItems, remPos, size-remPos-1);
        items = tmpItems;
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        for (MenuItem c: items) {
            if (c.getName().equals(itemName)) {
                remove(itemName);
                count++;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        for (MenuItem c: items) {
            if (c==item) {
                remove(item);
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] tmpItems = items;
        Arrays.sort(tmpItems, new MenuItemComparator());
        return tmpItems;
    }

    @Override
    public int costTotal() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total+=items[i].getCost();
        }
        return total;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

