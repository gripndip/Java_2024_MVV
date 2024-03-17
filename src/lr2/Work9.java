package lr2;

abstract class GeometricShape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
class CircularShape extends GeometricShape {
    private double radius;
    public CircularShape(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
class QuadrilateralShape extends GeometricShape {
    private double side;
    public QuadrilateralShape(double side) {
        this.side = side;
    }
    public double calculateArea() {
        return Math.pow(side, 2);
    }
    public double calculatePerimeter() {
        return 4 * side;
    }
}
class TriangularShape extends GeometricShape {
    private double base;
    private double height;
    private double side1;
    private double side2;
    public TriangularShape(double base, double height, double side1, double side2) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
    public double calculateArea() {
        return 0.5 * base * height;
    }
    public double calculatePerimeter() {
        return base + side1 + side2;
    }
}
public class Work9 {
    public static void main(String[] args) {
        CircularShape circle = new CircularShape(5);
        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Периметр круга: " + circle.calculatePerimeter());

        QuadrilateralShape square = new QuadrilateralShape(4);
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());

        TriangularShape triangle = new TriangularShape(3, 4, 5, 5);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
        System.out.println("Периметр треугольника: " + triangle.calculatePerimeter());
    }
}
