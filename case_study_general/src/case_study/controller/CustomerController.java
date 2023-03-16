package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    public void menuCustomerManagement() {
        Scanner scanner = new Scanner(System.in);
        ICustomerService iCustomerService = new CustomerService();
        do {
            System.out.println("\nQUẢN LÝ KHÁCH HÀNG:\n" +
                    "1. Hiển thị danh sách khách hàng.\n" +
                    "2. Thêm mới khách hàng.\n" +
                    "3. Chỉnh sửa khách hàng.\n" +
                    "4. Trở về MENU chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }

            switch (choose) {
                case 1:
                    iCustomerService.display();
                    break;
                case 2:
                    iCustomerService.add();
                    break;
                case 3:
                    iCustomerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
