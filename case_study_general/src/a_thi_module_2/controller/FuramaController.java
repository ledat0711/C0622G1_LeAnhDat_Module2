package a_thi_module_2.controller;

import case_study.common.*;
import case_study.controller.*;

public class FuramaController {
    public void displayMainMenu() {
        String choice;
        while (true) {
            System.out.println(
                    "--------------ỨNG DỤNG QUẢN LÝ KHU NGHỈ DƯỠNG FURAMA--------------" +
                            "\n1. Quản lý nhân viên." +
                            "\n2. Quản lý khách hàng." +
                            "\n3. Quản lý cơ sở." +
                            "\n4. Quản lý đặt chỗ (booking)." +
                            "\n5. Quản lý Promotion." +
                            "\n6. Thoát." +
                            "\nMời bạn nhập lựa chọn: "
            );
            choice = CommonController.inputValidChoice("[1-6]");
            switch (choice) {
                case "1":
                    EmployeeController.displayEmployeeManagementMenu();
                    break;
                case "2":
                    CustomerController.displayCustomerManagementMenu();
                    break;
                case "3":
                    FacilityController.displayFacilityManagementMenu();
                    break;
                case "4":
                    BookingController.displayBookingManagementMenu();
                    break;
                case "5":
                    PromotionController.displayPromotionManagementMenu();
                    break;
                case "6":
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
