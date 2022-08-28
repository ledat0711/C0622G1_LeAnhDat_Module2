package case_study.service.impl.facility;

import case_study.model.facility.House;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HouseServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<House, Integer> HOUSE_INTEGER_MAP = new LinkedHashMap<>();
    private static int timesUseHouse;
    static {
        HOUSE_INTEGER_MAP.put(new House("SVHO67-5422","House GG"), timesUseHouse);
        HOUSE_INTEGER_MAP.put(new House("SVHO12-0977","House BB"), timesUseHouse);
    }
    @Override
    public void display() {
        Set<House> houseSet = HOUSE_INTEGER_MAP.keySet();
        for (House house : houseSet){
            System.out.println(house + ", Số lần sử dụng: " + HOUSE_INTEGER_MAP.get(house));
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập mã dịch vụ:");
        String serviceID = SCANNER.nextLine();
        System.out.println("Nhập tên dịch vụ:");
        String serviceName = SCANNER.nextLine();
        System.out.println("Nhập số lần sử dụng: ");
        timesUseHouse = Integer.parseInt(SCANNER.nextLine());
        HOUSE_INTEGER_MAP.put(new House(serviceID, serviceName), timesUseHouse);
    }

    @Override
    public void edit() {

    }
}
