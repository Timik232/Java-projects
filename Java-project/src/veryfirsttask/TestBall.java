package veryfirsttask;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball("red", 5, 10);
        System.out.println(ball);
        ball.setColor("blue");
        ball.setRadius(10);
        ball.setWeight(20);
        System.out.println(ball);
    }
}
