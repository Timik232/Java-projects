package generic;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList <E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue <E> content;
    WaitList(){
        content = new ConcurrentLinkedQueue<E>();
    };
    WaitList(Collection <E> c){
        content = new ConcurrentLinkedQueue<E>(c);
    };

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.remove();
    }

    @Override
    public boolean contains(E element) {
        if (content.contains(element))
            return true;
        else return false;
    }

    @Override
    public boolean containsAll(Collection <E> element) {
        if (content.containsAll(element))
            return true;
        else return false;
    }

    @Override
    public boolean isEmpty() {
        if (content.isEmpty())
            return true;
        else return false;
    }
}
