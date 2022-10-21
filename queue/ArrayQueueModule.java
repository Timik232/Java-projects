package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    private int[] arr;
    private int curSize;
    private int rear;
    private int front;
    //int maxSize;
    ArrayQueueModule(int n){
     arr = new int[n];
     curSize = 0;
     rear = -1;
     front = -1;
    }
    public void enqueue(int number){
        if (front == 0 && rear == arr.length -1)
            return;
        if (front==-1)
            front = 0;
        rear = (rear+1)%arr.length;
        arr[rear] = number;
        if (curSize!=arr.length)
            curSize+=1;
    }
    public int element(){
        if (curSize!=0)
            return arr[0];
        else return -1;
    }
    public int size(){
        return curSize;
    }
    public boolean isEmpty(){
        if (curSize==0)
            return true;
        else return false;
    }
    public int dequeue(){
        if (curSize!=0){
            int buf = arr[0];
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
        else return -1;
    }
    public void clear(){
        for (int i = 0; i < curSize; i++){
            arr[i] = 0;
        }
        curSize = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public String toString() {
        return "ArrayQueueModule{" +
                "arr=" + Arrays.toString(arr) +
                ", curSize=" + curSize +
                ", rear=" + rear +
                ", front=" + front +
                '}';
    }
}
