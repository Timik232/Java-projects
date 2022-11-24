package generic28;

public class TestClassList {
    public static void main(String[] args) {
        try {
            ClassList classList = new ClassList("src");
            classList.print();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
