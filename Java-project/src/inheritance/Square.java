package inheritance;

public class Square extends Rectangle{
    public Square(){
        this.filled = false;
        this.color = "white";
        length = 1;
        width = length;
    }
    public Square(double side){
        this.filled = false;
        this.color = "white";
        length = side;
        width = length;
    }
    public Square(double side, String color, boolean filled){
        this.length = side;
        this.color = color;
        this.filled = filled;
        width = length;
    }
    public double getSide() {
        return length;
    }
    public void setSide(double side) {
        this.length = side;
        width = length;
    }

    @Override
    public void setLength(double length) {
        this.length = length;
        this.width = length;
    }
    @Override
    public void setWidth(double width) {
        this.length = width;
        this.width = length;
    }
    public String toString() {
        return "Shape: Square, side: "+this.length+", color: "+this.color;
    }
}
