package case_study.controller;
import case_study.service.IFacilityService;
import case_study.service.impl.facility.FacilityServiceImpl;
import case_study.utils.common.*;

public class FacilityController {
    private static final IFacilityService facilityService = new FacilityServiceImpl();
    public static void displayFacilityManagementMenu() {
        FuramaController furamaController = new FuramaController();
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
                    facilityService.display();
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    break;
                case 4:
                    furamaController.displayMainMenu();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
