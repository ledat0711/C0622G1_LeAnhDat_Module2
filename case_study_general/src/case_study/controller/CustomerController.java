package case_study.controller;
import case_study.service.ICustomerService;
import case_study.service.impl.people_impl.CustomerServiceImpl;
import case_study.common.*;

public class CustomerController {
    private static final ICustomerService customerService = new CustomerServiceImpl();
    public static void displayCustomerManagementMenu(){
        FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.println("--------------------------------------------------------" +
                    "\n--------------MENU QUẢN LÝ KHÁCH HÀNG--------------" +
                    "\n1. Hiển thị danh sách khách hàng." +
                    "\n2. Thêm mới thông tin khách hàng" +
                    "\n3. Chỉnh sửa thông tin khách hàng" +
                    "\n4. Trở lại menu chính." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-4]");
            switch (choice) {
                case "1":
                    customerService.display();
                    break;
                case "2":
                    customerService.add();
                    break;
                case "3":
                    customerService.edit();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
