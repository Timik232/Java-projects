package generic;

public class Main {
    public static void main(String[] args) {
        BoundedWaitList<Integer> que = new BoundedWaitList<Integer>(5);
        for (int i = 0; i < 6; i++)
            que.add(i);
        System.out.println("BoundedList after creating: " + que);
        UnfairWaitList<Integer> unque = new UnfairWaitList<Integer>();
        for(int i = 0; i < 6; i++)
            unque.add(i);
        System.out.println("UnfairList after creating: " + unque);
        unque.remove(2);
        unque.moveToBack(5);
        System.out.println("Changed list: " + unque);
    }
}
