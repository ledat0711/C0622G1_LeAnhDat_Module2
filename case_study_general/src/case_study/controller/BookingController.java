package case_study.controller;
import case_study.utils.common.*;
public class BookingController {
    public static void displayBookingManagementMenu() {
        FuramaController furamaController = new FuramaController();
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println(
                    "-------------------------------------------" +
                    "\n1. Add new booking." +
                    "\n2. Display list booking." +
                    "\n3. Create new contract" +
                    "\n4. Display list contracts" +
                    "\n5. Edit contracts" +
                    "\n6. Return main menu" +
                    "\nMời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(CommonController.inputValidChoice("[1-6]"));
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    furamaController.displayMainMenu();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
