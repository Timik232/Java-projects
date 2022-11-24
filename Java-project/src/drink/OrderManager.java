package drink;

public class OrderManager {
    private Order[] orders;
    private int curSize;
    private int size;
    public OrderManager(){
        orders = new Order[100];
        size = 100;
        curSize = 0;
    }
    public OrderManager(int size){
        orders = new Order[size];
        this.size = size;
        curSize = 0;
    }
    public OrderManager(Order[] orders) {
        this.orders = orders;
        size = curSize = orders.length;
    }

    public boolean add(Order order, int TableNumber) {
        if (curSize == size){
            return false;
        }
        orders[curSize] = order;
        curSize+=1;
        return true;
    }
    Order getOrder(int TableNumber){
        return orders[TableNumber];
    }
    public void removeOrder(int numb) {
        orders[numb] = null;
    }

    public void removeAll() {
        curSize = 0;
    }

    public int freeTableNumber(){
        for (int i = 0; i < size; i++){
            if (orders[i] == null){
                return i;
            }
        }
        return -1;
    }
    public int[] freeTableNumbers(){
        int[] free = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++){
            if (orders[i] == null){
                free[count] = i;
                count+=1;
            }
        }
        return free;
    }
    public double ordersCostSummary(){
        double cost = 0;
        for (int i = 0; i < size; i++){
            cost += orders[i].getFullCost();
        }
        return cost;
    }
    public int ordersQuantity(){
        return curSize;
    }
    public Order[] getOrders(){
        return orders;
    }
    public int itemsQuantity(String dishName){
        int count = 0;
        for (int i = 0; i < size; i++){
            count += orders[i].getNameAmount(dishName);
        }
        return count;
    }
    public void addDish(Dish dish, int TableNumber){
        orders[TableNumber].add(dish);
    }
}
