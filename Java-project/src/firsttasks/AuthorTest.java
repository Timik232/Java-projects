package firsttasks;

public class AuthorTest {
    public static void main(String[] args) {
        Author Cawton = new Author("Scott Cawthon", "scott@email.com", 'M');
        System.out.println(Cawton.getName());
        System.out.println(Cawton.getEmail());
        Cawton.setEmail("fnaf@game.com");
        System.out.println(Cawton.getEmail());
        System.out.println(Cawton);
    }
}
