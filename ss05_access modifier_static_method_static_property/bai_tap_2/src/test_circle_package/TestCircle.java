package test_circle_package;

public class TestCircle {
    public static void main(String[] args) {
        Circle circleObject = new Circle();
        System.out.println(circleObject.getRadius());
        System.out.printf("%.4f",circleObject.getArea());
    }
}
