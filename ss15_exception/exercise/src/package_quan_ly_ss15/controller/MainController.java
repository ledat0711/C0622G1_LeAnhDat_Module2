//Bài tập thêm HaiTT ( phần ngoại lệ)
package package_quan_ly_ss15.controller;

import package_quan_ly_ss15.utils.exception.InvalidException;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static int numericalOrder = 0;

    public void menuMainController() throws Exception {
        int j = 0;
        int i = 0;
        int choice = 0;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------");
            System.out.println("Chào bạn.");
            System.out.println("1. Quản lý học viên.");
            System.out.println("2. Quản lý giảng viên");
            System.out.print("Mời bạn nhập lựa chọn: ");
            do {
                j++;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 2 || choice < 1) {
                        throw new InvalidException("Bạn đã ngoài phạm vi giá trị.");
                    }
                    break;
                } catch (NumberFormatException n) {
                    System.err.println("Bạn đã nhập kiểu dữ liệu không phải là số.");
                } catch (InvalidException p) {
                    System.err.println(p.getMessage());
                } catch (Exception e) {
                    System.err.println("Thông tin bạn nhập đã bị lỗi");
                }
                System.out.println("Vui lòng nhập lại thông tin");
            } while (j < 10);
            switch (choice) {
                case 1:
                    StudentController.menuManagementStudent();
                    break;
                case 2:
                    TeacherController.menuManagementTeacher();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}