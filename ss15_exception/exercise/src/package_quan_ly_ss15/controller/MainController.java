//Bài tập thêm HaiTT ( phần ngoại lệ)
package package_quan_ly_ss15.controller;

import package_quan_ly_ss15.utils.exception.InvalidException;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static int numericalOrder = 0;

    public int inputValidChoice() {
        int choice = 0;
        int j = 0;
        while (j < 10) {
            j++;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 2 || choice < 1) {
                    throw new InvalidException("\nBạn đã nhập giá trị ngoài phạm vi.");
                }
                break;
            } catch (NumberFormatException n) {
                System.out.println("\nBạn đã nhập kiểu dữ liệu không phải là số.");
            } catch (InvalidException p) {
                System.out.println(p.getMessage());
            } catch (Exception e) {
                System.out.println("\nThông tin bạn nhập đã bị lỗi");
            }
            System.out.print("Vui lòng nhập lại lựa chọn: ");
        }
        return choice;
    }

    public void menuMainController() throws Exception {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------");
            System.out.println("Chào bạn.");
            System.out.println("1. Quản lý học viên.");
            System.out.println("2. Quản lý giảng viên");
            System.out.print("Mời bạn nhập lựa chọn: ");
            choice = this.inputValidChoice();
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