package case_study.controller;

import case_study.service.IEmployeeService;
import case_study.service.impl.people_impl.EmployeeServiceImpl;
import case_study.common.*;

public class EmployeeController {
    private static IEmployeeService employeeService = new EmployeeServiceImpl();

    public static void displayEmployeeManagementMenu() {
        FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.print("---------------------------------------------------------" +
                    "\n---------------MENU QUẢN LÝ NHÂN VIÊN---------------" +
                    "\n1. Hiển thị danh sách nhân viên." +
                    "\n2. Thêm mới thông tin nhân viên" +
                    "\n3. Chỉnh sửa thông tin nhân viên" +
                    "\n4. Xóa thông tin nhân viên." +
                    "\n5. Trở lại menu chính." +
                    "\nMời bạn nhập lựa chọn: "
            );
            choice = CommonController.inputValidChoice("[1-4]");
            switch (choice) {
                case "1":
                    employeeService.display();
                    break;
                case "2":
                    employeeService.add();
                    break;
                case "3":
                    employeeService.edit();
                    break;
                case "4":
                    EmployeeServiceImpl.remove();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
