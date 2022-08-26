package controllers;

import static controllers.A0_FuramaController.displayMainMenu;

public class A5_PromotionController {
    public static void displayPromotionManagementMenu(){
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------" +
                    "\n1. Display list customers use service." +
                    "\n2. Display list customers get voucher." +
                    "\n3. Return main menu." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(A0_FuramaController.inputValidChoice("[1-3]"));
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
