/*
Mục tiêu:
Luyện tập sử dụng try-catch để xử lý ngoại lệ.
Mô tả:
Viết một ứng dụng nhập vào 3 cạnh của hình tam giác.
Kiểm tra nếu giá trị nhập vào là số âm hoặc tổng 2 cạnh không lớn hơn cạnh còn lại thì sinh ngoại lệ.
Sử dụng IllegalTriangleException để sinh lỗi khi kiểm tra tam giác.
*/
package illegal_triangle_exception;
import java.util.Scanner;
public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        double firstEdge = 0;
        double secondEdge = 0;
        double thirdEdge = 0;
        System.out.println("Mời bạn nhập chiều dài các cạnh a, b, c của tam giác. ");
        do {
            i++;
            try {
                System.out.print("Cạnh a: ");
                firstEdge = Double.parseDouble(scanner.nextLine());
                System.out.print("Cạnh b: ");
                secondEdge = Double.parseDouble(scanner.nextLine());
                System.out.print("Cạnh c: ");
                thirdEdge = Double.parseDouble(scanner.nextLine());
                if (firstEdge <= 0 || secondEdge <= 0 || thirdEdge <= 0) {
                    throw new IllegalTriangleException("Bạn đã nhập giá trị không phải số dương cho một hoặc nhiều cạnh.");
                }
                if ((firstEdge + secondEdge) <= thirdEdge ||
                        (firstEdge + thirdEdge) <= secondEdge ||
                        (secondEdge + thirdEdge) <= firstEdge) {
                    throw new IllegalTriangleException("Bạn đã nhập vào các giá trị không thỏa mãn: " +
                            "Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException n) {
                System.err.println("Bạn đã nhập giá trị không phải là một số.");
            }
            System.out.println("--------------------------------");
            System.out.println("Mời bạn lại các giá trị");
        } while (i < 10);
        if (i == 10) {
            System.out.println("(To continue, Press Run ^^!)");
        } else {
            System.out.printf("Tam giác có:" +
                            "\nCạnh a: %s (cm)." +
                            "\nCạnh b: %s (cm)." +
                            "\nCạnh c: %s (cm).",
                    firstEdge, secondEdge, thirdEdge);
            System.out.println("\n(To continue, Press Run ^^!)");
        }
    }
}