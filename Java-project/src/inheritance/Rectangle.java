package inheritance;

public class Rectangle extends Shape{
    protected double width;
    protected double length;
    public Rectangle(){
    width = 1;
    length = 1;
    color = "without";
    filled = false;
    }
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
        color = "without";
        filled = false;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public double getPerimeter() {
        return 2*width + 2*length;
    }

    @Override
    public String toString() {
        if (filled)
            return "Shape: rectangle," + " width=" + width + " length=" + length + " color= " + color + ", filled";
        else
            return "Shape: rectangle," + " width=" + width + " length=" + length + " color= " + color + ", not filled";
    }
}
