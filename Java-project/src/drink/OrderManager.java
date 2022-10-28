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
    public OrderManager(Order[] orders) {
        this.orders = orders;
        size = curSize = orders.length;
    }

    public boolean add(Order order) {
        if (curSize == size){
            return false;
        }
        orders[curSize] = order;
        curSize+=1;
        return true;
    }

    public boolean remove(int numb) {
        if (numb > curSize){
            return false;
        }
       for (int i = numb; i < curSize-1; i++){
           Order buf = orders[i];
           orders[i] = orders[i+1];
           orders[i+1] = buf;
       }
       curSize-=1;
       return true;
    }

    public void removeAll() {
        curSize = 0;
    }

    public int getAmount() {
        return curSize;
    }
}
