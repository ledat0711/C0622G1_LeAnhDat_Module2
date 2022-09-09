package a_thi_module_2.controller;

import a_thi_module_2.common.CommonController;
import a_thi_module_2.controller.*;

public class HumanResourceController {
    private static final EmployeeController employeeController = new EmployeeController();
    private static final StudentController studentController = new StudentController();
    public void displayHumanResourceMenu(){
        String choice;
        while(true){
            System.out.println(
                    "--------------ỨNG DỤNG QUẢN LÝ NHÂN SỰ CODEGYM--------------" +
                            "\n1. Quản lý nhân viên." +
                            "\n2. Quản lý học viên." +
                            "\n3. Kết thúc chương trình." +
                            "\nMời bạn nhập lựa chọn: "
            );
            choice = CommonController.inputValidChoice("[1-3]");
            switch (choice) {
                case "1":
                    employeeController.displayEmployeeManagementMenu();
                    break;
                case "2":
                    studentController.displayStudentManagementMenu();
                    break;
                case "3":
                    System.out.println("\nĐã kết thúc chương trình." +
                            "\nCảm ơn bạn đã sử dụng." +
                            "\nHẹn gặp lại.");
                    System.exit(0);
                default:
                    System.err.println("Bạn đã nhập lỗi.");
            }
        }
    }

}
