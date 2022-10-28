package generic;

public class BoundedWaitList <E> extends WaitList<E> {
    private int capacity;
    BoundedWaitList(int capacity){
        super();
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                '}' + content.toString();
    }
    public void add(E element){
        if (content.size()<capacity) {
            content.add(element);
        }
    }
}
