package case_study.controller;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        FacilityController facilityController = new FacilityController();
        BookingController bookingController = new BookingController();
        PromotionController promotionController = new PromotionController();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nỨNG DỤNG QUẢN LÝ KHU NGHĨ DƯỠNG FURAMA:\n" +
                    "1. Quản lý nhân viên.\n" +
                    "2. Quản lý khách hàng.\n" +
                    "3. Quản lý cơ sở.\n" +
                    "4. Quản lý đặt chỗ.\n" +
                    "5. Quản lý khuyến mãi.\n" +
                    "6. Thoát.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }

            switch (choose) {
                case 1:
                    employeeController.menuEmployeeManagement();
                    break;
                case 2:
                    customerController.menuCustomerManagement();
                    break;
                case 3:
                    facilityController.menuFacilityManagement();
                    break;
                case 4:
                    bookingController.menuBookingManagement();
                    break;
                case 5:
                    promotionController.menuPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
