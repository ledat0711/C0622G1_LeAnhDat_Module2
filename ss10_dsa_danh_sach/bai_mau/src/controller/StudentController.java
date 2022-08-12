package controller;

import service.IStudentService;
import service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);

    private IStudentService studentService = new StudentService();
//    public void menuManagementStudent() {
//            int i = 0;
//        while(i!=5){
//            System.out.println("---------------------------------------------");
//            System.out.println("Chào bạn.");
//            System.out.println("1. Hiển thị danh sách học viên");
//            System.out.println("2. Thêm mới học sinh");
//            System.out.println("3. Cập nhật thông tin học sinh");
//            System.out.println("4. Xóa học sinh");
//            System.out.println("5. Exit");
//            System.out.print("Mời bạn nhập chức năng 1->5: ");
//            i++;
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    studentService.displayAllStudent();
//                    break;
//                case 2:
//                    studentService.addStudent();
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    studentService.removeStudent();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Lựa chọn bạn nhập không đúng!");
//            }
//        }
//    }
}
