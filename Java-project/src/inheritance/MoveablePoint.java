package inheritance;

public class MoveablePoint implements Movable {
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    MoveablePoint(){
        x = 0;
        y = 0;
        xSpeed = 0;
        ySpeed = 0;
    }
    MoveablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public String toString() {
        return "MoveablePoint "+" x="+x+", y="+y+", xSpeed="+xSpeed+", ySpeed=" + ySpeed;
    }

    @Override
    public void moveUp() {
        y+=1;
    }

    @Override
    public void moveDown() {
        y-=1;
    }

    @Override
    public void moveLeft() {
        x-=1;
    }

    @Override
    public void moveRight() {
        x+=1;
    }
}
