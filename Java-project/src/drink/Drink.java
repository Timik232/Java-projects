package drink;
public class Drink extends MenuItem implements Alcoholable{
    Double alcoholVol;
    DrinkTypeEnum type;

    public Drink(int cost, String name, String description, Double alcoholVol, DrinkTypeEnum type) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return type.ordinal() <= DrinkTypeEnum.JAGERMEISTER.ordinal();
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }
}

