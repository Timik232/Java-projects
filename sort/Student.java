package sort;

public class Student {
    String name;
    double mark;
    public Student(String name, double mark){
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return name + " with mark " + mark;
    }
}
