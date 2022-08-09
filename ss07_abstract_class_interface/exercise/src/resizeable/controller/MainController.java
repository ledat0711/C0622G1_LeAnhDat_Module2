package resizeable.controller;

import resizeable.model.Circle;
import resizeable.model.Rectangle;
import resizeable.model.Shape;
import resizeable.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape circle1 = new Circle(5, "red", true);
        System.out.println("before increasing the size");
        System.out.println(circle1);
        circle1.resize(7);
        System.out.println("after size increase");
        System.out.println(circle1);

        Shape rectangle1 = new Rectangle(8,8);
        System.out.println("\n\nbefore increasing the size");
        System.out.println(rectangle1);
        rectangle1.resize(30);
        System.out.println("after size increase");
        System.out.println(rectangle1);

        Shape square1 = new Square(7);
        System.out.println("\n\nbefore increasing the size");
        System.out.println(square1);
        rectangle1.resize(30);
        System.out.println("after size increase");
        System.out.println(square1);
    }
}
