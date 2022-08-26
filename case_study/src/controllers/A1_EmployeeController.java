package controllers;

import static controllers.A0_FuramaController.displayMainMenu;

public class A1_EmployeeController {
    public static void displayEmployeeManagementMenu() {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.println("-------------------------------------------");
            System.out.println("1. Display list employees.");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu.");
            System.out.print("Mời bạn nhập lựa chọn: ");
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
