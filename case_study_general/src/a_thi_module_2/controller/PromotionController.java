package a_thi_module_2.controller;

import case_study.common.*;
import case_study.controller.FuramaController;

public class PromotionController {
    public static void displayPromotionManagementMenu() {
        case_study.controller.FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.println("----------------------------------------------------------" +
                    "\n--------------------MENU QUẢN LÝ PROMOTION--------------------" +
                    "\n1. Hiển thị danh sách khách hàng sử dụng dịch vụ." +
                    "\n2. Hiển thị danh sách khách hàng nhận được voucher." +
                    "\n3. Trở lại menu chính." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-3]");
            switch (choice) {
                case "1":
                    System.out.println("Hiển thị danh sách khách hàng sử dụng dịch vụ.");
                    break;
                case "2":
                    System.out.println("Hiển thị danh sách khách hàng nhận được voucher.");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
