package Price;

public class Plate implements Priceable {
    String material;
    int price;
    Plate(String material, int price){
        this.material = material;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
