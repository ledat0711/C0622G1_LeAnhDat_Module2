/*
Mục tiêu:
Luyện tập sử dụng try-catch để xử lý ngoại lệ.
Mô tả:
Viết một ứng dụng nhập vào 3 cạnh của hình tam giác.
Kiểm tra nếu giá trị nhập vào là số âm hoặc tổng 2 cạnh không lớn hơn cạnh còn lại thì sinh ngoại lệ.
Sử dụng IllegalTriangleException để sinh lỗi khi kiểm tra tam giác.
*/
package illegal_triangle_exception;

import illegal_triangle_exception.utils.exception.IllegalTriangleException;

import java.util.Scanner;

public class MainView {
    static Scanner scanner = new Scanner(System.in);

    public static double checkInputValidEdge1(String stringInput) {
        System.out.printf("Cạnh %s: ", stringInput);
        double edge = 0;
        int i = 0;
        while (i < 10) {
            i++;
            try {
                edge = Double.parseDouble(scanner.nextLine());
                if (edge <= 0) {
                    throw new IllegalTriangleException(String.format("\nBạn đã nhập giá trị không phải số dương cho cạnh %s.", stringInput));
                }
                break;
            } catch (IllegalTriangleException ie) {
                System.out.println(ie.getMessage());
            } catch (NumberFormatException n) {
                System.out.println(String.format("\nBạn đã dữ liệu không phải là số cho cạnh %s.", stringInput));
            } catch (Exception e) {
                System.out.println("\nBạn đã nhập bị lỗi.");
            }
            System.out.printf("Mời bạn lại cạnh %s: ", stringInput);
        }
        return edge;
    }

//    Đây là cách thứ 2: Dùng hàm này để gọi các class ngoại lệ để sinh lỗi ( nếu không muốn dùng if ):
//    public static boolean CheckInputValidEdge2(double firstEdge, double secondEdge, double thirdEdge) {
//        boolean isValid = true;
//        try {
//            if ((firstEdge + secondEdge) <= thirdEdge ||
//                    (firstEdge + thirdEdge) <= secondEdge ||
//                    (secondEdge + thirdEdge) <= firstEdge) {
//                isValid = false;
//                throw new IllegalTriangleException("\nBạn đã nhập vào các giá trị không thỏa mãn: " +
//                        "Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
//            }
//        } catch (IllegalTriangleException e) {
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Bạn đã nhập thông tin bị lỗi.");
//        }
//        return isValid;
//    }

    public static void main(String[] args) {
        int i = 0;
        double firstEdge = 0;
        double secondEdge = 0;
        double thirdEdge = 0;
        while (i < 10) {
            i++;
            System.out.println("Mời bạn nhập chiều dài các cạnh a, b, c của tam giác. ");
            firstEdge = checkInputValidEdge1("a");
            secondEdge = checkInputValidEdge1("b");
            thirdEdge = checkInputValidEdge1("c");
            if ((firstEdge + secondEdge) <= thirdEdge ||
                    (firstEdge + thirdEdge) <= secondEdge ||
                    (secondEdge + thirdEdge) <= firstEdge) {
                System.out.println("\nBạn đã nhập vào các giá trị không thỏa mãn: " +
                        "Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
            } else {
                break;
            }
        }
        if (i == 10) {
            System.out.println("Press Run To Continue ^^!");
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