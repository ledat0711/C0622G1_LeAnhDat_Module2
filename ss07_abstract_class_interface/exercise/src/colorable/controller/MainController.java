package colorable.controller;

import colorable.model.Circle;
import colorable.model.Rectangle;
import colorable.model.Shape;
import colorable.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(8, 8);
        shapes[2] = new Square(7);
        for (Shape represent : shapes) {
            if (represent == shapes[2]) {
                System.out.println("Before: ");
                System.out.println(represent);
                represent.howToColor();
            }
            System.out.println("Before: ");
            System.out.println(represent);
            System.out.println("After");
            System.out.println(represent + "\n\n");
        }
    }
}