package resizeable.model;

import java.text.DecimalFormat;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##.00");
        return "Circle{" +
                "radius=" + radius + ", " +
                " area: " + f.format(getArea()) + " ," +
                super.toString() +
                '}';
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + getRadius() * percent / 100);
    }
}
