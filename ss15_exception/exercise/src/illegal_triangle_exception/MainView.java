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
import package_quan_ly_ss15.utils.exception.InvalidException;

import java.util.Scanner;

public class MainView {
    static Scanner scanner = new Scanner(System.in);

    public static double inputValidEdge1(String stringInput) {
        System.out.printf("Cạnh %s: ", stringInput);
        double edge = 0;
        double point = 0;
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

    public static boolean inputValidEdge2(double firstEdge, double secondEdge, double thirdEdge) {
        boolean isValid=true;
        try {
            if ((firstEdge + secondEdge) <= thirdEdge ||
                    (firstEdge + thirdEdge) <= secondEdge ||
                    (secondEdge + thirdEdge) <= firstEdge) {
                isValid=false;
                throw new IllegalTriangleException("\nBạn đã nhập vào các giá trị không thỏa mãn: " +
                        "Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
            }
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Bạn đã nhập thông tin bị lỗi.");
        }
        return isValid;
    }

    public static void main(String[] args) {
        int i = 0;
        double firstEdge = 0;
        double secondEdge = 0;
        double thirdEdge = 0;
        System.out.println("Mời bạn nhập chiều dài các cạnh a, b, c của tam giác. ");
        while (i < 10) {
            i++;
            firstEdge = inputValidEdge1("a");
            secondEdge = inputValidEdge1("b");
            thirdEdge = inputValidEdge1("c");
            if(inputValidEdge2(firstEdge, secondEdge, thirdEdge)){
                break;
            }else {
                System.out.println("Mời bạn lại giá trị các cạnh a,b,c của tam giác: ");
            };
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