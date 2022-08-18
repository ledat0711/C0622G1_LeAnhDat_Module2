package package_quan_ly.controller;

import package_quan_ly.service.ITeacherService;
import package_quan_ly.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    /**
     * menuManagementStudent(): Menu quản lý giảng viên
     */
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherService teacherService = new TeacherService();
    private static MainController memberController = new MainController();

    public static void menuManagementTeacher() {
        int i = 0;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách giảng viên.");
            System.out.println("1. Hiển thị danh sách giảng viên.");
            System.out.println("2. Thêm mới giảng viên.");
            System.out.println("3. Cập nhật thông tin giảng viên.");
            System.out.println("4. Xóa giảng viên.");
            System.out.println("5. Tìm giảng viên bằng ID.");
            System.out.println("6. Tìm giảng viên bằng tên.");
            System.out.println("7. Sắp xếp danh sách giảng viên theo tên và hiển thị.");
            System.out.println("8. Quay trở lại menu trước.");
            System.out.print("Mời bạn nhập chức năng: ");
            i++;
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherService.displayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.displayAllTeacher();
                    teacherService.updateTeacher();
                    break;
                case 4:
                    teacherService.removeTeacher();
                    break;
                case 5:
                    teacherService.findTeacherByID();
                    break;
                case 6:
                    teacherService.findTeacherByName();
                    break;
                case 7:
                    teacherService.sortTeacherByName();
                    break;
                case 8:
                    memberController.menuMainController();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
