package drink17;

public class TestDrink {
    public static void main(String[] args) {
        Drink water = new Drink("water", "usual", 1);
        System.out.println(water.getCOST());
        System.out.println(water.getDESCRIPTION() +" "+ water.getNAME());
    }
}
