package controller;

import service.IStudentService;
import service.impl.MemberService;
import service.impl.StudentService;

import java.util.Scanner;

public class MemberController {
    private static Scanner scanner = new Scanner(System.in);

    private IStudentService studentService = new StudentService();
    private static Scanner scanner1 = new Scanner(System.in);
    private static IStudentService studentService1 = new StudentService();;
    //StudentService.menuManagementStudent()
    public static void menuManagementStudent() {
        int i = 0;
        while(i!=3){
            System.out.println("-------------------------------------------");
            System.out.println("Chào bạn.");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Exit");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            i++;
            int choice = Integer.parseInt(scanner1.nextLine());
            switch (choice) {
                case 1:
                    studentService1.displayAllStudent();
                    break;
                case 2:
                    studentService1.addStudent();
                    break;
                case 3:
                    break;
                case 4:
                    studentService1.removeStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
    public void menuManagementMember() {
        int i = 0;
        System.out.println("Chào mừng đến với CodeGym.");
        System.out.println("1. Quản lý học viên.");
        System.out.println("2. Quản lý giảng viên");
        System.out.print("Mời bạn nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                menuManagementStudent();
                break;
            case 2:
                studentService.addStudent();
                break;
            default:
                System.out.println("Lựa chọn bạn nhập không đúng!");
        }
    }
}

