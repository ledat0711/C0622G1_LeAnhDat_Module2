package case_study.service.impl.facility_impl;

import case_study.common.CheckAndReturnServicesInfo;
import case_study.model.facility.Room;
import case_study.service.IFacilityService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_ROOM_FILE = "src\\case_study\\data\\facilities\\room.csv";

    @Override
    public void display() {
        Map<Room, Integer> roomIntegerMap = ReadAndWriteFile.readRoomFromFile(LINK_ROOM_FILE);
        Set<Room> roomSet = roomIntegerMap.keySet();
        for (Room room : roomSet) {
            System.out.println(room + ", Số lần sử dụng: "+ roomIntegerMap.get(room));
        }
    }

    @Override
    public void add() {
        Map<Room, Integer> roomIntegerMap = ReadAndWriteFile.readRoomFromFile(LINK_ROOM_FILE);

        System.out.println("\nNhập mã dịch vụ: ");
        String serviceID = CheckAndReturnServicesInfo.returnServiceID();

        System.out.println("\nNhập tên dịch vụ:");
        String serviceName = CheckAndReturnServicesInfo.formatAndReturnServiceName();

        System.out.println("\nNhập diện tích sử dụng: ");
        double area = Double.parseDouble(CheckAndReturnServicesInfo.returnAreaDouble());

        System.out.println("\nNhập giá cho thuê: ");
        double rentalPrice = Double.parseDouble(CheckAndReturnServicesInfo.returnRentalPriceAndFloor());

        int maxPeople = CheckAndReturnServicesInfo.returnMaxPeopleServiceInt();

        String typeOfRental = CheckAndReturnServicesInfo.returnTypeOfRental();

        System.out.println("\nNhập dịch vụ miễn phí: ");
        String freeServices = CheckAndReturnServicesInfo.formatAndReturnServiceName();

        int timesUseRoom= CheckAndReturnServicesInfo.returnTimesUse();
        roomIntegerMap.put(new Room(serviceID, serviceName,area,rentalPrice,maxPeople,typeOfRental,freeServices), timesUseRoom);
        ReadAndWriteFile.writeRoomToFile(LINK_ROOM_FILE, roomIntegerMap, false);
    }

    @Override
    public void edit() {
    }
}
