package colorable.model;

import java.text.DecimalFormat;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(String color) {
        super(color);
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##.00");
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length + " ," +
                " area= " + f.format(getArea()) + ", " +
                super.toString() +
                '}';
    }
}
