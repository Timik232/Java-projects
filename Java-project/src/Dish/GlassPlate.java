package Dish;

public class GlassPlate extends Dish {

    GlassPlate(){
        this.material = "Glass";
        canUseMetallicSponge = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Material is " + material);
        System.out.println("You can't use metallic sponge to clean it");
    }
}
