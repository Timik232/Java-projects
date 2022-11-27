package queue;

public class ArrayQueue {
    private Object[] arr;
    private int size = 0;
    private int last = 0;
    private int first = 0;

    public ArrayQueue() {
        arr = new Object[size];
        last = first = 0;
    }

    public void enqueue(Object elem) {
        if (isEmpty()) {
            arr = new Object[++size];
            arr[size - 1] = elem;
        } else {
            if (last + 1 >= size) {
                System.arraycopy(arr, first, arr = new Object[size + 1], 0, size);
                size++;
            }
            arr[size - 1] = elem;
            last++;
        }
    }


    public Object element() {
        return arr[first];
    }

    public Object dequeue() {
        Object res = arr[first];
        System.arraycopy(arr, first + 1, arr = new Object[--size], 0, size);
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        arr = new Object[size];
    }
}

