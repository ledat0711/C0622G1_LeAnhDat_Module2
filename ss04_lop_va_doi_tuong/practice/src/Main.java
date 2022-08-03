import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều rộng: ");
        double widthNumber = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập chiều cao: ");
        double heightNumber = Double.parseDouble(sc.nextLine());
        RectangleClass rectangleObject = new RectangleClass(widthNumber, heightNumber);
        System.out.println("\n"+rectangleObject.display());
        System.out.printf("\nDiện tích: %f m2", rectangleObject.getArea());
        System.out.printf("\nChu vi: %.2f m\n", rectangleObject.getPerimeter());
    }
}
