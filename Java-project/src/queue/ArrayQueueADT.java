package queue;

public class ArrayQueueADT <T>  {
    protected T[] arr;
    protected int front,rear,curSize;

    ArrayQueueADT(int n, T[] arr){
        front = -1;
        rear = -1;
        this.arr = arr;
    }

    public void enqueue(T el) {
        if (front == 0 && rear == arr.length -1)
            return;
        if (front==-1)
            front = 0;
        rear = (rear+1)%arr.length;
        arr[rear] = el;
        if (curSize!=arr.length)
            curSize+=1;
    }


    public T element() {
        if (curSize!=0)
            return arr[0];
        else return null;
    }


    public T dequeue() {
        if (curSize!=0){
            T buf = arr[0];
            for (int i = 0; i < curSize-1; i++){
                arr[i] = arr[i+1];
            }
            curSize-=1;
            rear-=1;
            if (front == rear){
                front = -1;
                rear = -1;
            }
            return buf;
        }
        else return null;
    }


    public boolean isEmpty() {
        if (curSize==0)
            return true;
        else return false;
    }

    public int size() {
        return curSize;
    }

    public void clear() {
        for (int i = 0; i < curSize; i++){
            arr[i] = null;
        }
        curSize = 0;
        front = -1;
        rear = -1;
    }
}
