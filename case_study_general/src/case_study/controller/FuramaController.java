package case_study.controller;

import case_study.utils.common.*;

public class FuramaController {
    public void displayMainMenu() {
        int i = 0;
        String selection;
        while (i < 10) {
            i++;
            System.out.print(
                    "-------------------------------------------" +
                            "\nChào bạn. Đây là ứng dụng quản lý khu nghỉ dưỡng Furama." +
                            "\n1. Empoyee Management." +
                            "\n2. Customer Management." +
                            "\n3. Facility Management." +
                            "\n4. Booking Management." +
                            "\n5. Promotion Management." +
                            "\n6. Exit" +
                            "\nMời bạn nhập lựa chọn: "
            );
            selection = CommonController.inputValidChoice("[1-6]");
            switch (selection) {
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
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
