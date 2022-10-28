package Dish;

public abstract class Dish {
    String material;
    boolean canUseMetallicSponge;
    public String getMaterial() {
        return material;
    }
    public boolean isMettallicSponge(){
        return canUseMetallicSponge;
    }
    public abstract void displayInfo();

}
