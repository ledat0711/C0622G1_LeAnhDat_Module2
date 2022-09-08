package a_thi_module_2.service.impl.facility_impl;

import case_study.common.EnterServicesInfo;
import case_study.model.facility.House;
import case_study.service.IFacilityService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HouseServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_HOUSE_FILE = "src\\case_study\\data\\facilities\\house.csv";

    //    private static final Map<House, Integer> HOUSE_INTEGER_MAP = new LinkedHashMap<>();
//    static {
//        HOUSE_INTEGER_MAP.put(new House("SVHO67-5422","House Good"), 2);
//        HOUSE_INTEGER_MAP.put(new House("SVHO12-0977","House Very Good"), 3);
//    }
    @Override
    public void display() {
        Map<House, Integer> houseIntegerMap = ReadAndWriteFile.readHouseFromFile(LINK_HOUSE_FILE);
        Set<House> houseSet = houseIntegerMap.keySet();
        for (House house : houseSet) {
            System.out.println(house + ", Số lần sử dụng: " + houseIntegerMap.get(house));
        }
    }

    @Override
    public void add() {
        Map<House, Integer> houseIntegerMap = ReadAndWriteFile.readHouseFromFile(LINK_HOUSE_FILE);
        String serviceID = EnterServicesInfo.returnServiceID();

        System.out.println("\nNhập vào tên dịch vụ: ");
        String serviceName = EnterServicesInfo.formatAndReturnServiceName();

        System.out.println("\nNhập vào diện tích sử dụng: ");
        double area = Double.parseDouble(EnterServicesInfo.returnAreaDouble());

        System.out.println("\nNhập vào giá cho thuê: ");
        double rentalPrice = Double.parseDouble(EnterServicesInfo.returnRentalPriceAndFloor());


        int maxPeople = EnterServicesInfo.returnMaxPeopleServiceInt();

        String typeOfRental = EnterServicesInfo.returnTypeOfRental();

        System.out.println("\nNhập vào tiêu chuẩn phòng: ");
        String roomStandard = EnterServicesInfo.formatAndReturnServiceName();

        System.out.println("\nNhập vào số tầng: ");
        int floorNumber = Integer.parseInt(EnterServicesInfo.returnRentalPriceAndFloor());

        int timesUseHouse = EnterServicesInfo.returnTimesUse();
        houseIntegerMap.put(new House(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental, roomStandard, floorNumber), timesUseHouse);
        ReadAndWriteFile.writeHouseToFile(LINK_HOUSE_FILE, houseIntegerMap, false);
    }

    @Override
    public void edit() {
    }

}
