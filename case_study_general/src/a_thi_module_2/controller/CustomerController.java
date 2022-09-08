package a_thi_module_2.controller;
import case_study.controller.FuramaController;
import case_study.service.ICustomerService;
import case_study.service.impl.people_impl.CustomerServiceImpl;
import case_study.common.*;

public class CustomerController {
    private static final ICustomerService customerService = new CustomerServiceImpl();
    public static void displayCustomerManagementMenu(){
        case_study.controller.FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.println("--------------------------------------------------------" +
                    "\n--------------MENU QUẢN LÝ KHÁCH HÀNG--------------" +
                    "\n1. Hiển thị danh sách khách hàng." +
                    "\n2. Thêm mới thông tin khách hàng" +
                    "\n3. Chỉnh sửa thông tin khách hàng" +
                    "\n4. Xóa thông tin khách hàng." +
                    "\n5. Trở lại menu chính." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-5]");
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
                    CustomerServiceImpl.remove();
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
