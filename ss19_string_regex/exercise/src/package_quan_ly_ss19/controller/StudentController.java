package package_quan_ly_ss19.controller;

import package_quan_ly_ss19.service.IStudentService;
import package_quan_ly_ss19.service.impl.StudentService;
import package_quan_ly_ss19.utils.exception.InvalidException;

import java.util.Scanner;

public class StudentController {
    /**
     * menuManagementStudent(): Menu quản lý học sinh
     */
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();
    private static StudentService studentService2 = new StudentService();
    private static MainController memberController = new MainController();

    public static int inputValidChoice() {
        int choice = 0;
        int j = 0;
        while (j < 10) {
            j++;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 12 || choice < 1) {
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

    public static void menuManagementStudent() throws Exception {
        int choice;
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách học viên.");
            System.out.println("1. Hiển thị danh sách học viên.");
            System.out.println("2. Thêm mới học viên.");
            System.out.println("3. Cập nhật thông tin học viên.");
            System.out.println("4. Xóa học viên.");
            System.out.println("5. Tìm học viên bằng ID. ");
            System.out.println("6. Tìm học viên bằng tên.");
            System.out.println("7. Sắp xếp danh sách học viên theo TÊN TĂNG dần và hiển thị. ");
            System.out.println("8. Sắp xếp danh sách học viên theo TÊN GIẢM dần và hiển thị. ");
            System.out.println("9. Sắp xếp danh sách học viên theo ĐIỂM TĂNG dần và hiển thị. ");
            System.out.println("10. Sắp xếp danh sách học viên theo ĐIỂM GIẢM dần và hiển thị. ");
            System.out.println("11. Quay trở lại menu trước. ");
            System.out.println("12. Sắp xếp theo tên chính cuối bên phải (tên của người Việt).");
            System.out.print("Mời bạn nhập chức năng: ");
            choice = inputValidChoice();
            switch (choice) {
                case 1:
                    System.out.println("****Danh sách học viên****");
                    studentService.writeNewAndDisplayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.writeNewAndDisplayAllStudent();
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
                    studentService.sortStudentByNameUseLambda1();
                    break;
                case 8:
                    studentService.sortStudentByNameUseLambda2();
                    break;
                case 9:
                    studentService.sortStudentByPointUseLambda1();
                    break;
                case 10:
                    studentService.sortStudentByPointUseLambda2();
                    break;
                case 11:
                    return;
                case 12:
                    studentService2.sortByNameEndRight();
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}