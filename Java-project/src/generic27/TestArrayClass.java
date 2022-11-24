package generic27;

public class TestArrayClass {
    public static void main(String[] args) {
        String[] arr = {"Copy", "of", "a", "copy"};
        ArrayClass<String> arrayClass = new ArrayClass<>(arr);
        arrayClass.printArray();
        Integer[] arr1 = {1, 2, 3};
        ArrayClass<Integer> arrayClass1 = new ArrayClass<>(arr1);
        arrayClass1.printArray();
    }
}
