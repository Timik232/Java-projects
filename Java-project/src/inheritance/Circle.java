package inheritance;
import java.math.*;
public class Circle extends Shape {
    protected double radius;
    public Circle(){
        this.filled = false;
        this.color = "without";
        radius = 1;
        }
    public Circle(double radius){
        this.filled = false;
        this.color = "without";
        this.radius = radius;
        }
    public Circle(double radius, String color, boolean filled){
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    @Override
    public String toString() {
        if (filled)
            return "Shape: Circle, radius: "+this.radius+", color: "+this.color + ", filled";
        else
            return "Shape: Circle, radius: "+this.radius+", color: "+this.color + ", not filled";
    }
}

