package a_thi_module_2.controller;

import a_thi_module_2.common.CommonController;
import a_thi_module_2.service.IEmployeeService;
import a_thi_module_2.service.IStudentService;
import a_thi_module_2.service.impl.EmployeeServiceImpl;
import a_thi_module_2.service.impl.StudentServiceImpl;

public class StudentController {
    private static final IStudentService studentService = new StudentServiceImpl();
    public void displayStudentManagementMenu(){
        String choice;
        while (true) {
            System.out.print("---------------------------------------------------------" +
                    "\n---------------MENU QUẢN LÝ HỌC VIÊN---------------" +
                    "\n1. Thêm mới thông tin học viên." +
                    "\n2. Xóa thông tin học viên." +
                    "\n3. Hiển thị thông tin học viên." +
                    "\nMời bạn nhập lựa chọn: "
            );
            choice = CommonController.inputValidChoice("[1-3]");
            switch (choice) {
                case "1":
                    studentService.add();
                    break;
                case "2":
                    studentService.remove();
                    break;
                case "3":
                    studentService.display();
                    break;
                case "4":
                    break;
//                case"5":
//                    EmployeeServiceImpl.findEmployee();
//                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

}
