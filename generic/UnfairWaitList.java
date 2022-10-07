package generic;

public class UnfairWaitList<E> extends WaitList<E>{
    UnfairWaitList(){
        super();
    }
    public void remove(E element){
    content.remove(element);
    }
    public void moveToBack(E element){
        content.remove(element);
        content.add(element);
    }
}
