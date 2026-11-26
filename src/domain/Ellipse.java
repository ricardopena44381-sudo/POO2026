package domain;

public class Ellipse extends Shape {
    private double majorRadius; // Semi-major axis
    private double minorRadius; // Semi-minor axis

    public Ellipse(String id, double x, double y, double majorRadius, double minorRadius) {
        super(id, x, y);
        setRadii(majorRadius, minorRadius);
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setRadii(double majorRadius, double minorRadius) {
        if (majorRadius <= 0 || minorRadius <= 0) {
            throw new IllegalArgumentException("Ellipse radii must be greater than zero.");
        }
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * majorRadius * minorRadius;
    }

    @Override
    public double calculatePerimeter() {
        // Ramanujan's approximation for ellipse perimeter
        double a = majorRadius;
        double b = minorRadius;
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
