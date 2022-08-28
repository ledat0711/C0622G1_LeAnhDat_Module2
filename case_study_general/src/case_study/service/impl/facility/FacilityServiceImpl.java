package case_study.service.impl.facility;

import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private static final Map<Facility, Integer> FACILITY_INTEGER_MAP = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int timesUseFacility;

    static {
        FACILITY_INTEGER_MAP.put(new Villa("SVVL45-3382",
                "Sky Service",
                "56 m2",
                10,
                20,
                "Thuê theo tháng",
                "Good",
                "5 m2",
                5), 4);
    }

    @Override
    public void display() {
        Set<Facility> facilitySet = FACILITY_INTEGER_MAP.keySet();
        for (Facility facility : facilitySet) {
            System.out.println(facility + ", Số lần sử dụng: " + FACILITY_INTEGER_MAP.get(facility));
        }
    }

    @Override
    public void add() {
        System.out.println("Các loại dịch vụ để thêm vào: ");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Return to Facility Management Menu.");
        System.out.print("Lựa chọn của bạn: ");
        String selection = SCANNER.nextLine();
        switch (selection) {
            case "1":
                System.out.println("Add New Villa");
                addNewVilla();
                break;
            case "2":
                System.out.println("Add New House");
                addNewHouse();
                break;
            case "3":
                System.out.println("Add New Room");
                addNewRoom();
                break;
            case "4":
                return;
            default:
                System.out.println("Bạn đã nhập lỗi , vui lòng nhập lại.");
        }
    }

    public void addNewVilla() {
        System.out.println("Nhập mã dịch vụ:");
        String serviceID = SCANNER.nextLine();
        System.out.println("Nhập tên dịch vụ:");
        String serviceName = SCANNER.nextLine();
        System.out.println("Nhập diện tích:");
        String area = SCANNER.nextLine();
        System.out.println("Nhập giá cho thuê:");
        double rentalPrice = Double.parseDouble(SCANNER.nextLine());
        System.out.println("Nhập số người tối đa:");
        int maxPeople = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Nhập kiểu cho thuê:");
        String typeOfRental = SCANNER.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng:");
        String roomStandard = SCANNER.nextLine();
        System.out.println("Nhập diện tích hồ bơi:");
        String poolArea = SCANNER.nextLine();
        System.out.println("Nhập số phòng:");
        int floor = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Nhập số lần sử dụng:");
        timesUseFacility = Integer.parseInt(SCANNER.nextLine());
        FACILITY_INTEGER_MAP.put(new Villa(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental, roomStandard, poolArea, floor), timesUseFacility);
    }
    public void addNewHouse() {
        System.out.println("Nhập mã dịch vụ:");
        String serviceID = SCANNER.nextLine();
        System.out.println("Nhập tên dịch vụ:");
        String serviceName = SCANNER.nextLine();
        System.out.println("Nhập diện tích:");
        System.out.println("Nhập số lần sử dụng:");
        timesUseFacility = Integer.parseInt(SCANNER.nextLine());
        FACILITY_INTEGER_MAP.put(new House(serviceID, serviceName), timesUseFacility);
    }
    public void addNewRoom() {
        System.out.println("Nhập mã dịch vụ:");
        String serviceID = SCANNER.nextLine();
        System.out.println("Nhập tên dịch vụ:");
        String serviceName = SCANNER.nextLine();
        System.out.println("Nhập số lần sử dụng:");
        timesUseFacility = Integer.parseInt(SCANNER.nextLine());
        FACILITY_INTEGER_MAP.put(new Room(serviceID, serviceName), timesUseFacility);
    }
    @Override
    public void edit() {
    }
}
