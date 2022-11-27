package drink;

public class QueueNode {
    QueueNode next;
    QueueNode prev;
    Order value;

    public QueueNode(QueueNode next, QueueNode prev, Order value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }
}
