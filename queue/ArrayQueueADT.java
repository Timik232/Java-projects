package queue;

public abstract class ArrayQueueADT <T> {
    protected T[] arr;
    protected int front,rear,curSize;
    public abstract void enqueue(T el);
    public abstract T element();
    public abstract T dequeue();
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void clear();

}
