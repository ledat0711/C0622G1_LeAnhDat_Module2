package a_thi_module_2.service.impl.facility_impl;

import case_study.common.EnterServicesInfo;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.util.Map;
import java.util.Scanner;

public class VillaServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_VILLA_FILE = "src\\case_study\\data\\facilities\\villa.csv";
    //
//    static {
//        VILLA_INTEGER_MAP.put(new Villa("VI01111",
//                "Sea Service",
//                100,
//                10,
//                20,
//                "Thuê theo ngày",
//                "Standard",
//                "10 m2",
//                5),
//                timesUseVilla);
//        VILLA_INTEGER_MAP.put(new Villa("VI53382",
//                "Sky Service",
//                56,
//                10,
//                20,
//                "Thuê theo tháng",
//                "Good",
//                "5 m2",
//                5),
//                timesUseVilla);
//    }

    @Override
    public void display() {
        Map<Villa, Integer> villaIntegerMap = ReadAndWriteFile.readVillaFromFile("src\\case_study\\data\\facilities\\villa.csv");
        for(Map.Entry<Villa, Integer> entry: villaIntegerMap.entrySet()){
            System.out.println(entry.getKey()+" ,Số lần sử dụng: " + entry.getValue());
        }
    }

    @Override
    public void add() {
        System.out.println("-------------------------------------------" +
                "\nBạn đang sử dụng chức năng thêm thông tin dịch vụ Villa. ");
        Map<Villa, Integer> villaIntegerMap = ReadAndWriteFile.readVillaFromFile("src\\case_study\\data\\facilities\\villa.csv");

        String serviceID = EnterServicesInfo.returnServiceID();

        System.out.println("\nNhập tên dịch vụ: ");
        String serviceName = EnterServicesInfo.formatAndReturnServiceName();

        System.out.println("\nNhập diện tích sử dụng:");
        double area = Double.parseDouble(EnterServicesInfo.returnAreaDouble());

        System.out.println("\nNhập vào giá cho thuê: ");
        double rentalPrice = Double.parseDouble(EnterServicesInfo.returnRentalPriceAndFloor());

        int maxPeople = EnterServicesInfo.returnMaxPeopleServiceInt();

        String typeOfRental = EnterServicesInfo.returnTypeOfRental();

        System.out.println("\nNhập tiêu chuẩn phòng: ");
        String roomStandard = EnterServicesInfo.formatAndReturnServiceName();

        System.out.println("\nNhập diện tích hồ bơi:");
        String poolArea = EnterServicesInfo.returnAreaDouble();

        System.out.println("\nNhập vào số tầng: ");
        int floor = Integer.parseInt(EnterServicesInfo.returnRentalPriceAndFloor());

        int timesUseVilla = EnterServicesInfo.returnTimesUse();

        villaIntegerMap.put(new Villa(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental, roomStandard, poolArea, floor), timesUseVilla);

        ReadAndWriteFile.writeVillaToFile(LINK_VILLA_FILE, villaIntegerMap, false);
    }

    @Override
    public void edit() {

    }
}
