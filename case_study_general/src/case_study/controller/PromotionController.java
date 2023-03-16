package case_study.controller;

import case_study.service.IPromotionService;
import case_study.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    public void menuPromotionManagement() {
        Scanner scanner = new Scanner(System.in);
        IPromotionService iPromotionService = new PromotionService();
        do {
            System.out.println("\nQUẢN LÝ KHUYẾN MÃI\n" +
                    "1. Hiển thị danh sách khách hàng sử dụng dịch vụ.\n" +
                    "2. Hiển thị danh sách khách hàng nhận được voucher.\n" +
                    "3. Trở về MENU chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }

            switch (choose) {
                case 1:
                    iPromotionService.displayUseService();
                    break;
                case 2:
                    iPromotionService.displayGetVoucher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
