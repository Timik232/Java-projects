package ten;

public class Shirt {
    String number;
    String name;
    String color;
    String size;
    Shirt(String[] elements){
        number = elements[0];
        name = elements[1];
        color = elements[2];
        size = elements[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
