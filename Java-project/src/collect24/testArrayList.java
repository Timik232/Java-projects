package collect24;
//24
import java.util.ArrayList;

public class testArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(1, "Java");
        System.out.println(list);
        list.set(1, "World");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.contains("World"));
        System.out.println(list.contains("Java"));
        System.out.println(list.indexOf("World"));
        System.out.println(list.indexOf("Java"));
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());
    }
}
