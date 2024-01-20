import java.io.IOException;
import java.nio.CharBuffer;

interface Resizable {
    void resize(double factor);
}

// Abstract class Shape
abstract class Shape {
    // Abstract method to calculate area
    abstract void calculateArea();

    // Non-abstract method to display area
    void displayArea() {
        System.out.print("Area is ");
    }
}

// Concrete class Circle extending Shape
class Circle extends Shape implements Resizable {
    // Attributes specific to Circle
    double radius;

    // Constructor to initialize Circle attributes
    Circle(int radius) {
        this.radius = radius;
    }

    // Implementation of calculateArea for Circle
    @Override
    void calculateArea() {
        double area = 3.14 * radius * radius;
        displayArea();
        System.out.println(area);
    }

    @Override
    public void resize(double factor) {
       this.radius = radius* factor;
    }
}

// Concrete class Rectangle extending Shape
class Rectangle extends Shape implements Resizable {
    // Attributes specific to Rectangle
    int length;
    int width;

    // Constructor to initialize Rectangle attributes
    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of calculateArea for Rectangle
    @Override
    void calculateArea() {
        int area = length * width;
        displayArea();
        System.out.println(area);
    }

    @Override
    public void resize(double factor){
       this.length = (int) (length * factor);
       this.width = (int) (width * factor);
}

class Tringle extends Shape{
    int base;
    int hight;

    Tringle(int base , int hight){
        this.base = base;
        this.hight = hight;
    }

    @Override
    void calculateArea(){
        double area = (0.5) * base * hight ;
        displayArea();
        System.out.println(area);
    }
}

// Main program to test Shape, Circle, and Rectangle
public class Test2 {
    public static void main(String[] args) {
        // Create instances of Circle and Rectangle
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Tringle tringle = new Tringle(25, 10);

        // Calculate and display areas
        circle.calculateArea();
        circle.resize(2);
        circle.calculateArea();
        rectangle.calculateArea();
        tringle.calculateArea();
    }
}
