package Book;
//19
public class TestBook {
    public static void main(String[] args) {
        Book book = new Book("Akunin",2000,"Fandorin");
        System.out.println(book.getAuthor());
        book.setName("Erast Fandorine");
        System.out.println(book);
    }
}
