package inheritance;

public class MovableRectangle implements Movable{
    private MoveablePoint topLeft;
    private MoveablePoint bottomRight;
    MovableRectangle(int x1, int x2, int y1, int y2, int xSpeed, int ySpeed){
        topLeft = new MoveablePoint(x1,y1,xSpeed, ySpeed);
        bottomRight = new MoveablePoint(x2,y2,xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MovableRectangle " + "topLeft=" + topLeft +", bottomRight=" + bottomRight;
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }
}
