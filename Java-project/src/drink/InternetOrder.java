package drink;

import java.awt.*;
import java.util.Arrays;
//import java.util.Objects;

public class InternetOrder implements Order{
    private int size;
    ListNode head;
    ListNode tail;
    Customer customer;

    @Override
    public boolean add(MenuItem item) {
        if (size==0) {
            head = new ListNode(null, item);
            tail = head;
        }else {
            tail.next = new ListNode(null,item);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] itemsNames = new String[size];
        ListNode curr = head;
        int i = 0;
        while(curr!=null){
            itemsNames[i]=curr.value.name;
            curr = curr.next;
            i++;
        }
        return itemsNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            if (curr.value.name.equals( itemName)){
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            if (curr.value == item){
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[size];
        ListNode curr = head;
        int i = 0;
        while(curr!=null){
            items[i]=curr.value;
            curr = curr.next;
            i++;
        }
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        ListNode curr = head;
        while(curr.next!=null){
            if (curr.next.value.name.equals(itemName)){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return true;
    }

    @Override
    public boolean remove(MenuItem item) {
        ListNode curr = head;
        while(curr.next!=null){
            if (curr.next.value==item){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        ListNode curr = head;
        int count = 0;
        while(curr.next!=null){
            if (curr.next.value.name.equals(itemName)){
                curr.next = curr.next.next;
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        ListNode curr = head;
        int count = 0;
        while(curr.next!=null){
            if (curr.next.value==item){
                curr.next = curr.next.next;
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        Arrays.sort(items, new MenuItemComparator());
        return items;
    }

    @Override
    public int costTotal() {
        ListNode curr = head;
        int total = 0;
        while(curr!=null){
            total+=curr.value.getCost();
            curr = curr.next;
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

