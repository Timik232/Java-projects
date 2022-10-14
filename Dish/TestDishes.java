package Dish;
//20
public class TestDishes {
    public static void main(String[] args) {
        GlassPlate Plate = new GlassPlate();
        MetallCup Cup = new MetallCup();
        Cup.displayInfo();
        Plate.displayInfo();
        if (Plate.canUseMetallicSponge)
            System.out.println("Plate can be cleaned by metallic sponge");
        else System.out.println("Plate can't be cleaned by metallic sponge");
    }
}
