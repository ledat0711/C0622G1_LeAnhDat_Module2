package case_study.controller;

import case_study.common.*;

public class BookingController {
    public static void displayBookingManagementMenu() {
        FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.println("-------------------------------------------------------" +
                            "\n---------------MENU QUẢN LÝ BOOKING---------------" +
                            "\n1. Thêm thông tin booking mới." +
                            "\n2. Hiển thị danh sách booking." +
                            "\n3. Tạo hợp đồng mới" +
                            "\n4. Hiển thị hợp đồng danh sách" +
                            "\n5. Chỉnh sửa hợp đồng" +
                            "\n6. Trở lại menu chính" +
                            "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-6]");
            switch (choice) {
                case "1":
                    System.out.println("Add new booking");
                    break;
                case "2":
                    System.out.println("Display list booking");
                    break;
                case "3":
                    System.out.println("Create new contract");
                    break;
                case "4":
                    System.out.println("Display list contracts");
                    break;
                case "5":
                    System.out.println("Edit contracts");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
