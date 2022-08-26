package controllers;

import static controllers.A0_FuramaController.displayMainMenu;

public class A1_EmployeeController {
    public static void displayEmployeeManagementMenu() {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println(
                    "-------------------------------------------" +
                    "\n1. Display list employees." +
                    "\n2. Add new employee" +
                    "\n3. Edit employee" +
                    "\n4. Return main menu." +
                    "'\nMời bạn nhập lựa chọn: "
            );
            choice = Integer.parseInt(A0_FuramaController.inputValidChoice("[1-4]"));
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
