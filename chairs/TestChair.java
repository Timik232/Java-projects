package chairs;

public class TestChair {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        Chair chair = factory.createFunctionalChair();
        Client man = new Client();
        man.setChair(chair);
    }
}
