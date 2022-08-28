package case_study.service.impl.facility;

import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VillaServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Villa, Integer> VILLA_INTEGER_MAP = new LinkedHashMap<>();
    private static int timesUseVilla;

    static {
        VILLA_INTEGER_MAP.put(new Villa("VI01111",
                "Sea Service",
                "100 m2",
                10,
                20,
                "Thuê theo ngày",
                "Standard",
                "10 m2",
                5),
                timesUseVilla);
        VILLA_INTEGER_MAP.put(new Villa("VI53382",
                "Sky Service",
                "56 m2",
                10,
                20,
                "Thuê theo tháng",
                "Good",
                "5 m2",
                5),
                timesUseVilla);
    }

    @Override
    public void display() {
        Set<Villa> villaSet = VILLA_INTEGER_MAP.keySet();
        for (Villa villa : villaSet) {
            System.out.println(villa + " Số lần sử dụng: " + VILLA_INTEGER_MAP.get(villa));
        }
    }

    @Override
    public void add() {
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
        VILLA_INTEGER_MAP.put(new Villa(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental, roomStandard, poolArea, floor), timesUseVilla);
    }

    @Override
    public void edit() {

    }
}
