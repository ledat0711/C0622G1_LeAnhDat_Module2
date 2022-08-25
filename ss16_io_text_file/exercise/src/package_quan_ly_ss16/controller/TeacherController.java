package package_quan_ly_ss16.controller;

import package_quan_ly_ss16.service.ITeacherService;
import package_quan_ly_ss16.service.impl.TeacherService;
import package_quan_ly_ss16.utils.exception.InvalidException;

import java.util.Scanner;

public class TeacherController {
    /**
     * menuManagementStudent(): Menu quản lý giảng viên
     */
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherService teacherService = new TeacherService();
    private static MainController memberController = new MainController();

    public static int inputValidChoice() {
        int choice = 0;
        int j = 0;
        while (j < 10) {
            j++;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 8 || choice < 1) {
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

    public static void menuManagementTeacher() throws Exception {
        int i = 0;
        int choice;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách giảng viên.");
            System.out.println("1. Hiển thị danh sách giảng viên.");
            System.out.println("2. Thêm mới giảng viên.");
            System.out.println("3. Cập nhật thông tin giảng viên.");
            System.out.println("4. Xóa giảng viên.");
            System.out.println("5. Tìm giảng viên bằng ID.");
            System.out.println("6. Tìm giảng viên bằng tên.");
            System.out.println("7. Sắp xếp danh sách giảng viên theo tên tăng dần và hiển thị.");
            System.out.println("8. Quay trở lại menu trước.");
            System.out.print("Mời bạn nhập chức năng: ");
            i++;
            choice = inputValidChoice();
            switch (choice) {
                case 1:
                    teacherService.writeNewAndDisplayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.writeNewAndDisplayAllTeacher();
                    teacherService.updateTeacher();
                    break;
                case 4:
                    teacherService.removeTeacher();
                    break;
                case 5:
                    teacherService.findTeacherByID();
                    break;
                case 6:
                    teacherService.printResultTeacherFoundByName();
                    break;
                case 7:
                    teacherService.sortTeacherByNameAscending();
                    break;
                case 8:
                    memberController.displayMenuMainController();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}