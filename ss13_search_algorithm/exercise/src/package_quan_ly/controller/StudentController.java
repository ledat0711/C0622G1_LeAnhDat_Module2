package package_quan_ly.controller;

import package_quan_ly.service.IStudentService;
import package_quan_ly.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    /**
     * menuManagementStudent(): Menu quản lý học sinh
     */
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();
    private static MainController memberController = new MainController();

    public static void menuManagementStudent() {
        int i = 0;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách học viên.");
            System.out.println("1. Hiển thị danh sách học viên.");
            System.out.println("2. Thêm mới học viên.");
            System.out.println("3. Cập nhật thông tin học viên.");
            System.out.println("4. Xóa học viên.");
            System.out.println("5. Tìm học viên bằng ID. ");
            System.out.println("6. Tìm học viên bằng tên.");
            System.out.println("7. Quay trở lại menu trước. ");
            System.out.print("Mời bạn nhập chức năng: ");
            i++;
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.displayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.displayAllStudent();
                    studentService.updateStudent();
                    break;
                case 4:
                    studentService.removeStudent();
                    break;
                case 5:
                    studentService.findStudentByID();
                    break;
                case 6:
                    studentService.findStudentByName();
                    break;
                case 7:
                    memberController.menuMainController();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}