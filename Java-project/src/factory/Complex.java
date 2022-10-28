package factory;

public class Complex {
    double real, image;
    Complex(double real, double image){
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", image=" + image +
                '}';
    }
}
