package drink;

public class InternetOrdersManager implements OrdersManager{
    private QueueNode head;
    private QueueNode tail;
    private int size = 0;
    boolean add(Order order){
        if (size==0){
            head = new QueueNode(null,null,order);
            tail = head;
        }else {
            tail.prev = new QueueNode(tail,null,order);
            tail = tail.prev;
        }
        size++;
        return true;

    }
    Order remove(){
        QueueNode tmp = head;
        head = head.prev;
        return tmp.value;
    }
    Order order(){
        return head.value;
    }

    @Override
    public int itemsQuantity(String itemName) {
        QueueNode curr= head;
        int quantity = 0;
        while(curr!=null){
            quantity+=curr.value.itemsQuantity(itemName);
            curr = curr.next;
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        QueueNode curr= tail;
        int quantity = 0;
        while(curr!=null){
            quantity+=curr.value.itemsQuantity(item);
            curr = curr.next;
        }
        return quantity;
    }

    @Override
    public Order[] getOrders() {
        Order[] order = new Order[size];
        QueueNode curr = tail;
        for (int i = 0; i < size; i++) {
            order[i]= curr.value;
            curr = curr.next;
        }
        return order;
    }

    @Override
    public int ordersCostSummary() {
        QueueNode curr= tail;
        int summary = 0;
        while(curr!=null){
            summary+=curr.value.costTotal();
            curr = curr.next;
        }
        return summary;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }
}
