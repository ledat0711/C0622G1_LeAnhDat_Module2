package case_study.controller;

import case_study.service.IEmployeeService;
import case_study.service.impl.people.EmployeeServiceImpl;

public class EmployeeController {
    private static IEmployeeService employeeService = new EmployeeServiceImpl();
    public static void displayEmployeeManagementMenu() {
        int i = 0;
        int choice;
        while (i < 10) {
            i++;
            System.out.print(
                    "-------------------------------------------" +
                    "\n1. Display list employees." +
                    "\n2. Add new employee" +
                    "\n3. Edit employee" +
                    "\n4. Return main menu." +
                    "'\nMời bạn nhập lựa chọn: "
            );
            choice = Integer.parseInt(FuramaController.inputValidChoice("[1-4]"));
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
