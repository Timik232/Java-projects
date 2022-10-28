package factory;

public class testComplex {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex comp = factory.CreateComplex(1.1,3);
        System.out.println(comp);
    }
}
