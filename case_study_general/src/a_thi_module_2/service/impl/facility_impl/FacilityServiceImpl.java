package a_thi_module_2.service.impl.facility_impl;

import case_study.service.IFacilityService;
import case_study.service.impl.facility_impl.HouseServiceImpl;
import case_study.service.impl.facility_impl.RoomServiceImpl;
import case_study.service.impl.facility_impl.VillaServiceImpl;

import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    IFacilityService villaServiceImpl = new VillaServiceImpl();
    IFacilityService houseServiceImpl = new HouseServiceImpl();
    IFacilityService roomServiceImpl = new RoomServiceImpl();
//    private static final Map<Facility, Integer> FACILITY_INTEGER_MAP = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);
//    private static int timesUseFacility;
//
//    static {
//        FACILITY_INTEGER_MAP.put(new Villa("SVVL45-3382",
//                "Sky Service",
//                "56 m2",
//                10,
//                20,
//                "Thuê theo tháng",
//                "Good",
//                "5 m2",
//                5), 4);
//    }

    @Override
    public void display() {
        System.out.println("Các loại dịch vụ để hiển thị: ");
        System.out.println("1. Hiển thị thông tin dịch vụ 'Villa'");
        System.out.println("2. Hiển thị thông tin dịch vụ 'House'");
        System.out.println("3. Hiển thị thông tin dịch vụ 'Room'");
        System.out.println("4. Quay trở lại menu quản lý cơ sở.");
        System.out.print("Lựa chọn của bạn: ");
        String selection = SCANNER.nextLine();
        switch (selection) {
            case "1":
                System.out.println("Hiển thị thông tin dịch vụ 'Villa'");
                villaServiceImpl.display();
                break;
            case "2":
                System.out.println("Hiển thị thông tin dịch vụ 'House'");
                houseServiceImpl.display();
                break;
            case "3":
                System.out.println("Hiển thị thông tin dịch vụ 'Room'");
                roomServiceImpl.display();
                break;
            case "4":
                return;
            default:
                System.out.println("Bạn đã nhập lỗi , vui lòng nhập lại.");
        }
    }

    @Override
    public void add() {
        System.out.println("Các loại dịch vụ để thêm vào: ");
        System.out.println("1. Thêm mới thông tin dịch vụ 'Thuê Villa");
        System.out.println("2. Thêm mới thông tin dịch vụ 'Thuê Nhà'");
        System.out.println("3. Thêm mới thông tin dịch vụ 'Thuê Phòng'");
        System.out.println("4. Quay trở lại menu quản lý cơ sở.");
        System.out.print("Lựa chọn của bạn: ");
        String selection = SCANNER.nextLine();
        switch (selection) {
            case "1":
                System.out.println("Thêm mới thông tin dịch vụ 'Thuê Villa'");
                villaServiceImpl.add();
                break;
            case "2":
                System.out.println("Thêm mới thông tin dịch vụ 'Thuê Nhà'");
                houseServiceImpl.add();
                break;
            case "3":
                System.out.println("Thêm mới thông tin dịch vụ 'Thuê Phòng'");
                roomServiceImpl.add();
                break;
            case "4":
                return;
            default:
                System.out.println("Bạn đã nhập lỗi , vui lòng nhập lại.");
        }
    }
    @Override
    public void edit() {
    }

}
