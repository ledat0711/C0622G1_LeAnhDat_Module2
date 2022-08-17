package package_quan_ly.controller;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static int numericalOrder = 0;

    public void menuMainController() {
        int i = 0;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------");
            System.out.println("Chào bạn.");
            System.out.println("1. Quản lý học viên.");
            System.out.println("2. Quản lý giảng viên");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
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