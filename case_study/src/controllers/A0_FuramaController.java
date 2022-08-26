package controllers;

import java.util.Scanner;

public class A0_FuramaController {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputValidChoice(String vailidFormatInput) {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches(vailidFormatInput)) {
                return choiceString;
            } else {
                System.out.println("\nBạn đã nhập không hợp lệ.");
                System.out.print("Vui lòng nhập lại lựa chọn: ");
            }
        }
    }

    public static void displayMainMenu() {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println(
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
            choice = Integer.parseInt(inputValidChoice("[1-6]"));
            switch (choice) {
                case 1:
                    A1_EmployeeController.displayEmployeeManagementMenu();
                    break;
                case 2:
                    A2_CustomerController.displayCustomerManagementMenu();
                    break;
                case 3:
                    A3_FacilityController.displayFacilityManagementMenu();
                    break;
                case 4:
                    A4_BookingController.displayBookingManagementMenu();
                    break;
                case 5:
                    A5_PromotionController.displayPromotionManagementMenu();
                    break;
                case 6:
                    System.out.println(
                            "\nĐã kết thúc chương trình." +
                            "\nCảm ơn bạn đã sử dụng." +
                            "\nHẹn gặp lại.");
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
