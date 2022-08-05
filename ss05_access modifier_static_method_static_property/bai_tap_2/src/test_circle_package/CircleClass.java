package test_circle_package;

public class CircleClass {
    private double radius = 1.0;
    private String color = "red";
    private double area = 3.14 * Math.pow(radius, 2);

    public CircleClass() {
    }

    public CircleClass(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return area;
    }
}
