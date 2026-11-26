package domain;

public class Circle extends Shape {
    private double radius;

    public Circle(String id, double x, double y, double radius) {
        super(id, x, y);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Circle radius must be greater than zero.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Circumference
    }
}
