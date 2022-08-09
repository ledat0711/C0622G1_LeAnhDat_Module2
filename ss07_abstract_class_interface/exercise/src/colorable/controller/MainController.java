package colorable.controller;

import resizeable.model.Circle;
import resizeable.model.Rectangle;
import resizeable.model.Shape;
import resizeable.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape square1 = new Square(7);
        System.out.println("\n\nbefore increasing the size");
        System.out.println(square1);
        System.out.println("after size increase");
        System.out.println(square1);
    }
}
