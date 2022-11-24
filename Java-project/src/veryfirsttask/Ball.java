package veryfirsttask;

public class Ball {
    private String color;
    private int radius;
    private int weight;
    Ball(){
        color = "white";
        radius = 1;
        weight = 1;
    }
    Ball(String color, int radius, int weight){
        this.color = color;
        this.radius = radius;
        this.weight = weight;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public String getColor(){
        return color;
    }
    public int getRadius(){
        return radius;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                ", weight=" + weight +
                '}';
    }
}
