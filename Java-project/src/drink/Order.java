package drink;

public interface Order {
    boolean add(Item item);
    boolean remove(String name);
    int removeAll(String name);
    int getAmount();
    Item[] getArrayOrder();
    int getFullCost();
    int getNameAmount(String name);
    Item[] getUniqueArrayOrder();
    Item[] getSortedByCostArrayOrder();
}
