package case_study.controller;
import case_study.utils.common.*;

public class PromotionController {
    public static void displayPromotionManagementMenu(){
        FuramaController furamaController = new FuramaController();
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------" +
                    "\n1. Display list customers use service." +
                    "\n2. Display list customers get voucher." +
                    "\n3. Return main menu." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(CommonController.inputValidChoice("[1-3]"));
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    furamaController.displayMainMenu();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
