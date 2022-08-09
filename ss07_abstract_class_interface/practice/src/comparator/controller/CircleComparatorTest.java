package comparator.controller;



import comparator.model.Circle;
import comparator.model.CircleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[0] = new Circle();
        circles[0] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {   // for-each: (KDL biếnDạiDiện : tênMảng)
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted: ");
        for (Circle circle : circles){
            System.out.println(circle);
        }
    }
}
