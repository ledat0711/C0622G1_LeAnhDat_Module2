package test_circle_package;

public class CircleClass {
    private double radius = 1.0;
    private String color = "red";
    private double area = Math.PI * Math.pow(radius, 2);

    public CircleClass() {
    }

    public CircleClass(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return area;
    }
}
