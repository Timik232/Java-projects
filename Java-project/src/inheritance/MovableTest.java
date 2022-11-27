package inheritance;

public class MovableTest {
    public static void main(String[] args) {
        Movable m1 = new MoveablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);
        m1.moveRight();
        System.out.println(m1);
        m1.moveDown();
        System.out.println(m1);
        m1.moveUp();
        System.out.println(m1);
        System.out.println();

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20); // upcast
        System.out.println(m2);
        m2.moveLeft();
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
        m2.moveDown();
        System.out.println(m2);
        m2.moveUp();
        System.out.println(m2);
    }
}
