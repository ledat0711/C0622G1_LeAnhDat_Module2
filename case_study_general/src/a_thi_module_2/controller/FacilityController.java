package a_thi_module_2.controller;
import case_study.controller.FuramaController;
import case_study.service.IFacilityService;
import case_study.service.impl.facility_impl.FacilityServiceImpl;
import case_study.common.*;

public class FacilityController {
    private static final IFacilityService facilityService = new FacilityServiceImpl();
    public static void displayFacilityManagementMenu() {
        case_study.controller.FuramaController furamaController = new FuramaController();
        String choice;
        while (true) {
            System.out.println("--------------------------------------------------------" +
                    "\n---------------MENU QUẢN LÝ CƠ SỞ---------------" +
                    "\n1. Hiển thị danh sách các cơ sở." +
                    "\n2. Thêm mới thông tin cơ sở." +
                    "\n3. Hiển thị danh sách cơ sở bảo trì." +
                    "\n4. Trở lại menu chính." +
                    "\nMời bạn nhập lựa chọn: ");
            choice = CommonController.inputValidChoice("[1-4]");
            switch (choice) {
                case "1":
                    facilityService.display();
                    break;
                case "2":
                    facilityService.add();
                    break;
                case "3":
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
