package generic;

public class main {
    public static void main(String[] args) {
        BoundedWaitList<Integer> que = new BoundedWaitList<Integer>(5);
        for (int i = 0; i < 6; i++)
            que.add(i);
        System.out.println(que);
        UnfairWaitList<Integer> unque = new UnfairWaitList<Integer>();
        for(int i = 0; i < 6; i++)
            unque.add(i);
        unque.remove(2);
        unque.moveToBack(5);
        System.out.println(unque);
    }
}
