package Dish;

public class MetallCup extends Dish {
    @Override
    public void displayInfo() {
        System.out.println("Material is " + material);
        System.out.println("You can use metallic sponge to clean it");
    }
    MetallCup(){
        this.material = "Metall";
        canUseMetallicSponge = true;
    }
}
