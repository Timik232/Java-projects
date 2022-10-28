package Price;

public class TestPrice {
    public static void main(String[] args) {
        Book book = new Book("Green mile", 1000);
        Plate plate = new Plate("Glass",2000);
        System.out.println("Book: " + book.getPrice());
        System.out.println("Plate: " + plate.getPrice());
    }
}
