package package_quan_ly_ss15.controller;

import package_quan_ly_ss15.service.IStudentService;
import package_quan_ly_ss15.service.impl.StudentService;
import package_quan_ly_ss15.utils.exception.InvalidException;

import java.util.Scanner;

public class StudentController {
    /**
     * menuManagementStudent(): Menu quản lý học sinh
     */
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();
    private static MainController memberController = new MainController();

    public static void menuManagementStudent() throws Exception {
        int i = 0;
        int j = 0;
        int choice = 0;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách học viên.");
            System.out.println("1. Hiển thị danh sách học viên.");
            System.out.println("2. Thêm mới học viên.");
            System.out.println("3. Cập nhật thông tin học viên.");
            System.out.println("4. Xóa học viên.");
            System.out.println("5. Tìm học viên bằng ID. ");
            System.out.println("6. Tìm học viên bằng tên.");
            System.out.println("7. Sắp xếp danh sách học viên theo tên và hiển thị. ");
            System.out.println("8. Quay trở lại menu trước. ");
            System.out.print("Mời bạn nhập chức năng: ");
            i++;
            do {
                j++;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 8|| choice <0) {
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
                    studentService.sortStudentByName();
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