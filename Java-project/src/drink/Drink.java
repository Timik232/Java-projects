package drink;

final public class Drink implements Item{
    final private int COST;
    final private String NAME;
    final private String DESCRIPTION;
    Drink(String name, String description){
        this.NAME = name;
        this.DESCRIPTION = description;
        COST = 0;
    }
    Drink(String name, String description, int cost){
        this.NAME = name;
        this.DESCRIPTION = description;
        this.COST = cost;
    }

    public int getCOST() {
        return COST;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getNAME() {
        return NAME;
    }
}
