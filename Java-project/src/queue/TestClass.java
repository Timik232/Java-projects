package queue;

public class TestClass {
    public static void main(String[] args) {
        ArrayQueueModule arr = new ArrayQueueModule(5);
        if (arr.isEmpty())
            System.out.println("empty");
        arr.enqueue(5);
        System.out.println(arr.size());
        System.out.println(arr.element());
        System.out.println(arr.dequeue());
        if (arr.isEmpty())
            System.out.println("empty");
        for (int i = 0; i < 6; i++){
            arr.enqueue(i);
        }
        System.out.println(arr);
        for (int i = 0; i < 5; i++){
            System.out.println(arr.dequeue());
        }
        if (arr.isEmpty())
            System.out.println("empty");
        String[] array = new String[2];
        ArrayQueueADT strarr = new ArrayQueueADT(2,array);
        strarr.enqueue("some");
        System.out.println("ArrayQueueADT dequeue: " + strarr.dequeue());
    }
}
