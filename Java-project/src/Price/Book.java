package Price;

public class Book implements Priceable {
    String name;
    int price;
    Book(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
