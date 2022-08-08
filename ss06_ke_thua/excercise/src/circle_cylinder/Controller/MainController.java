/*    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }*/
package circle_cylinder.Controller;

import circle_cylinder.Model.Circle;
import circle_cylinder.Model.Cylinder;

public class MainController {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        circle1 = new Circle(8, "blue");
        System.out.println(circle1);

        Cylinder cylinder1= new Cylinder();
        System.out.println(cylinder1);
        cylinder1=new Cylinder(2, 4, "black");
        System.out.println(cylinder1);
    }
}
