package case_study.controller;

import case_study.common.*;

public class PromotionController {
    public static void displayPromotionManagementMenu() {
        FuramaController furamaController = new FuramaController();
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
