package lr2;
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}
class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }
    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}
public class Work6 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Площаль круга: " + circle.calculateArea());
        System.out.println("Периметр круга: " + circle.calculatePerimeter());

        Shape square = new Square(4);
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());

        Shape triangle = new Triangle(3, 4, 5);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
        System.out.println("Периметр треугольника: " + triangle.calculatePerimeter());
    }
}
