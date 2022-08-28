package case_study.service.impl.facility;

import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomServiceImpl implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Room, Integer> ROOM_INTEGER_MAP = new LinkedHashMap<>();
    private static int timesUseRoom;

    static {
        ROOM_INTEGER_MAP.put(new Room("SVRO-4422", "Room KKK"), timesUseRoom);
    }

    @Override
    public void display() {
        Set<Room> roomSet = ROOM_INTEGER_MAP.keySet();
        for (Room room : roomSet) {
            System.out.println(room + ", Số lần sử dụng"+ ROOM_INTEGER_MAP);
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập mã dịch vụ:");
        String serviceID = SCANNER.nextLine();
        System.out.println("Nhập tên dịch vụ:");
        String serviceName = SCANNER.nextLine();
        System.out.println("Nhập số lần sử dụng: ");
        timesUseRoom = Integer.parseInt(SCANNER.nextLine());
        ROOM_INTEGER_MAP.put(new Room(serviceID, serviceName), timesUseRoom);
    }

    @Override
    public void edit() {
    }
}
