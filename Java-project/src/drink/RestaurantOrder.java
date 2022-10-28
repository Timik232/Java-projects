package drink;

public class RestaurantOrder implements Order{
    private int size;
    private int curSize;
    private Item[] elements;
    //private Dish[] dishes;
    //private Drink[] drinks;

    public RestaurantOrder(int size) {
        this.size = size;
        curSize = 0;
        elements = new Item[size];
        //dishes = new Dish[size];
        //drinks = new Drink[size];
    }

    @Override
    public boolean add(Item item) {
        if (size == curSize){
            return false;
        }
        elements[curSize] = item;
        curSize+=1;
        return true;
    }

    @Override
    public boolean remove(String name) {
        boolean flag = false;
        for (int i = 0; i < curSize; i++){
            if (name == elements[i].getNAME()){
                flag = true;
                for (int j = i; j < curSize-1; j++){
                    Item buf = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = buf;
                }
                curSize-=1;
            }
        }
        return flag;
    }

    @Override
    public int removeAll(String name) {
        int count = 0;
        for (int i = 0; i < curSize; i++){
            if (name == elements[i].getNAME()){
                count+=1;
                for (int j = curSize; j > i+1; j--){
                    Item buf = elements[j];
                    elements[j] = elements[j-1];
                    elements[j-1] = buf;
                }
                curSize-=1;
            }
        }
        return count;
    }

    @Override
    public int getAmount() {
        return curSize;
    }

    @Override
    public Item[] getArrayOrder() {
        Item[] items = new Item[curSize];
        for (int i = 0; i < curSize; i++){
            items[i] = elements[i];
        }
        return items;
    }

    @Override
    public int getFullCost() {
        int cost = 0;
        for (Item I: elements){
            cost+=I.getCOST();
        }
        return cost;
    }

    @Override
    public int getNameAmount(String name) {
        int count = 0;
        for (Item I: elements){
            if (I.getNAME() == name){
             count+=1;
            }
        }
        return count;
    }

    @Override
    public Item[] getUniqueArrayOrder() {
        Item[] Unique = new Item[curSize];
        Unique[0] = elements[0];
        int count = 1;
        for (int i = 1; i < curSize; i++){
            boolean flag = false;
            for (int j = 0; j < count; j++){
                if (elements[i].getNAME() == Unique[j].getNAME()){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                Unique[count] = elements[i];
                count+=1;
            }
        }
        Item[] realUnique = new Item[count];
        for (int i = 0; i < count; i++){
            realUnique[i] = Unique[i];
        }
        return realUnique;
    }

    @Override
    public Item[] getSortedByCostArrayOrder() {
        Item[] items = new Item[curSize];
        for (int i = 0; i < curSize; i++)
            items[i] = elements[i];
        for (int out = curSize - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(items[in].getCOST() < items[in + 1].getCOST()) {
                    Item buf = items[in];
                    items[in] = items[in+1];
                    items[in+1] = buf;
                }

            }
        }
        return items;
    }
}
