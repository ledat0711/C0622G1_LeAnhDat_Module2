package case_study.utils;

import case_study.model.Customer;
import case_study.model.Facility;
import case_study.model.Link;
import case_study.service.impl.CustomerService;
import case_study.service.impl.FacilityService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookingInfoUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getCustomerId() {
        new CustomerService().display();
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(Link.PATH_CUSTOMER.getPath());
        System.out.print("Nhập mã khách hàng: ");
        String customerId;

        do {
            customerId = SCANNER.nextLine();
            for (Customer customer : customerList) {
                if (customerId.equals(customer.getId())) {
                    return customerId;
                }
            }

            System.out.println("Mã khách hàng khồng tồn tại, vui lòng nhập lại!");
        } while (true);
    }

    public static String getServiceIdBooking() {
        new FacilityService().display();
        Map<Facility, Integer> villaList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_VILLA.getPath());
        Map<Facility, Integer> houseList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_HOUSE.getPath());
        Map<Facility, Integer> roomList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_ROOM.getPath());

        System.out.print("Nhập mã dịch vụ: ");
        String serviceId;

        do {
            serviceId = SCANNER.nextLine();

            for (Facility villa : villaList.keySet()) {
                if (serviceId.equals(villa.getServiceId())) {
                    villaList.put(villa, villaList.get(villa) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_VILLA.getPath(), villaList);

                    if (villaList.get(villa) + 1 > 4) {
                        System.out.println("Cơ sở cần được kiểm tra bảo dưỡng các trang thiết bị!");
                    }
                    return serviceId;
                }
            }

            for (Facility house : houseList.keySet()) {
                if (serviceId.equals(house.getServiceId())) {
                    houseList.put(house, houseList.get(house) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_HOUSE.getPath(), houseList);

                    if (houseList.get(house) + 1 > 4) {
                        System.out.println("Cơ sở cần được kiểm tra bảo dưỡng các trang thiết bị!");
                    }
                    return serviceId;
                }
            }

            for (Facility room : roomList.keySet()) {
                if (serviceId.equals(room.getServiceId())) {
                    roomList.put(room, roomList.get(room) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_ROOM.getPath(), roomList);

                    if (roomList.get(room) + 1 > 4) {
                        System.out.println("Cơ sở cần được kiểm tra bảo dưỡng các trang thiết bị!");
                    }
                    return serviceId;
                }
            }

            System.out.println("Mã dịch vụ khồng tồn tại, vui lòng nhập lại!");
        } while (true);
    }

    public static String getServiceIdContract() {
        new FacilityService().display();
        Map<Facility, Integer> villaList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_VILLA.getPath());
        Map<Facility, Integer> houseList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_HOUSE.getPath());

        System.out.print("Nhập mã dịch vụ Villa/House: ");
        String serviceId;

        do {
            serviceId = SCANNER.nextLine();

            for (Facility villa : villaList.keySet()) {
                if (serviceId.equals(villa.getServiceId())) {
                    villaList.put(villa, villaList.get(villa) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_VILLA.getPath(), villaList);

                    if (villaList.get(villa) + 1 > 4) {
                        System.out.println("Cơ sở cần được kiểm tra bảo dưỡng các trang thiết bị!");
                    }
                    return serviceId;
                }
            }

            for (Facility house : houseList.keySet()) {
                if (serviceId.equals(house.getServiceId())) {
                    houseList.put(house, houseList.get(house) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_HOUSE.getPath(), houseList);

                    if (houseList.get(house) + 1 > 4) {
                        System.out.println("Cơ sở cần được kiểm tra bảo dưỡng các trang thiết bị!");
                    }
                    return serviceId;
                }
            }

                System.out.println("Mã dịch vụ khồng tồn tại, vui lòng nhập lại!");
        } while (true);
    }
}
