package case_study.controller;

import case_study.common.CommonController;
import case_study.service.IBookingService;
import case_study.service.impl.BookingServiceImpl;

public class BookingController {
    public static void displayBookingManagementMenu() {
        IBookingService bookingService = new BookingServiceImpl();
        String choice;
        while (true) {
            System.out.println("-------------------------------------------------------" +
                    "\n---------------MENU QUẢN LÝ BOOKING---------------" +
                    "\n1. Hiển thị danh sách booking." +
                    "\n2. Thêm thông tin booking mới." +
                    "\n3. Tạo hợp đồng mới" +
                    "\n4. Hiển thị dan sách hợp đồng" +
                    "\n5. Chỉnh sửa hợp đồng" +
                    "\n6. Trở lại menu chính" +
                    "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-6]");
            switch (choice) {
                case "1":
                    System.out.println("Hiển thị danh sách booking");
                    bookingService.display();
                    break;
                case "2":
                    System.out.println("Thêm mới booking");
                    bookingService.add();
                    break;
                case "3":
                    System.out.println("Tạo hợp đồng mới");
                    break;
                case "4":
                    System.out.println("Hiển thị dan sách hợp đồng");
                    break;
                case "5":
                    System.out.println("Chỉnh sửa hợp đồng");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
