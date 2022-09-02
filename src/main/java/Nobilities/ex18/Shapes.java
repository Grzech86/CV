package Nobilities.ex18;

public class Shapes {

    public static void printArea(Shape shape) {
        System.out.println("shape area is " + shape.area());
    }

    public static void main(String[] args) {
        printArea(new Circle(3.0));
        printArea(new Square(2.0));
        printArea(new Rectangle(2.0, 4.0));
    }
}

interface Shape {
   double area();
}

class Circle implements Shape {
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }
}

class Square implements Shape {
    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return a * a;
    }
}

class Rectangle implements Shape {
    private final double a;
    private final double b;


    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }
}