package case_study.controller;

import case_study.service.IBookingService;
import case_study.service.IContractService;
import case_study.service.impl.BookingService;
import case_study.service.impl.ContractService;

import java.util.Scanner;

public class BookingController {
    public void menuBookingManagement() {
        Scanner scanner = new Scanner(System.in);
        IBookingService iBookingService = new BookingService();
        IContractService iContractService = new ContractService();

        do {
            System.out.println("\nQUẢN LÝ ĐẶT CHỖ:\n" +
                    "1. Thêm mới đặt chỗ.\n" +
                    "2. Hiển thị danh sách đặt chỗ.\n" +
                    "3. Tạo hợp đồng mới.\n" +
                    "4. Hiển thị danh sách hợp đồng.\n" +
                    "5. Chỉnh sửa hợp đồng.\n" +
                    "6. Trở về MENU chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }

            switch (choose) {
                case 1:
                    iBookingService.add();
                    break;
                case 2:
                    iBookingService.display();
                    break;
                case 3:
                    iContractService.add();
                    break;
                case 4:
                    iContractService.display();
                    break;
                case 5:
                    iContractService.edit();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
