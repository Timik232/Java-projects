package chairs;

public class TestChair {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        Chair chair = factory.createFunctionalChair();
        Client man = new Client();
        man.setChair(chair);
        man.sit();
        MagicChair magic = factory.createMagicanChair();
        magic.doMagic();
        VictorianChair victor = factory.createVictorianChair(5);
        System.out.println(victor.getAge());
    }
}
