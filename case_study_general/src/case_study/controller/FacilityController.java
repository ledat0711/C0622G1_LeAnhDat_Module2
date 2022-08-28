package case_study.controller;
import case_study.utils.common.*;
import static case_study.controller.FuramaController.displayMainMenu;

public class FacilityController {
    public static void displayFacilityManagementMenu() {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println(
                    "-------------------------------------------" +
                    "\n1. Display list facility." +
                    "\n2. Add new facility" +
                    "\n3. Display list facility maintenace" +
                    "\n4. Return main menu." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(CommonController.inputValidChoice("[1-4]"));
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
