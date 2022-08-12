package controller;

import service.IStudentService;
import service.ITeacherService;
import service.impl.StudentService;
import service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    /** menuManagementStudent(): Menu quản lý học sinh
     */
    // StudentController.menuManagementStudent();
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherService teacherService = new TeacherService();
    private static MemberController memberController =new MemberController();
    public static void menuManagementTeacher() {
        int i = 0;
        while (i != 8) {
            System.out.println("-------------------------------------------");
            System.out.println("Chào bạn.");
            System.out.println("1. Hiển thị danh sách giảng viên");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật thông tin giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Quay trở lại menu trước. ");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
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
                    break;
                case 4:
                    teacherService.removeTeacher();
                    break;
                case 5:
                    memberController.menuManagementMember();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
