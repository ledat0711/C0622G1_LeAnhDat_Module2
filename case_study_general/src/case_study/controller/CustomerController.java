package case_study.controller;
import case_study.service.ICustomerService;
import case_study.service.impl.people.CustomerServiceImpl;
import case_study.utils.common.*;

public class CustomerController {
    private static final ICustomerService customerService = new CustomerServiceImpl();
    public static void displayCustomerManagementMenu(){
        FuramaController furamaController = new FuramaController();
        int i = 0;
        String selection;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------" +
                    "\n1. Display list customers." +
                    "\n2. Add new customer" +
                    "\n3. Edit customer" +
                    "\n4. Return main menu." +
                    "\nMời bạn nhập lựa chọn: ");
            selection = CommonController.inputValidChoice("[1-4]");
            switch (selection) {
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
                    furamaController.displayMainMenu();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
