package case_study.common;

import case_study.model.Booking;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.utils.exception.*;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EnterBookingInfo {
    private static final String LINK_VILLA_FILE = "src\\case_study\\data\\facilities\\villa.csv";
    private static final String LINK_HOUSE_FILE = "src\\case_study\\data\\facilities\\house.csv";
    private static final String LINK_ROOM_FILE = "src\\case_study\\data\\facilities\\room.csv";
    private static final String LINK_CUSTOMER_FILE = "src\\case_study\\data\\person\\customer.csv";
    private static final String LINK_BOOKING_FILE = "src\\case_study\\data\\booking.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String enterBookingID(){
        Set<Booking> bookingSet = ReadAndWriteFile.readBookingFromFile(LINK_BOOKING_FILE);
        String regexBookingID = "^BK\\d+$";
        String bookingID;
        do {
            try {
                System.out.println("Nhập mã số booking (BKXXXX , X là số): ");
                bookingID = SCANNER.nextLine().trim();
                if (bookingID.isEmpty()) {
                    throw new EmptyInformationException("Mã số booking đang trống.");
                }
                if (!bookingID.matches(regexBookingID)) {
                    throw new InvalidFormatException("Bạn đã nhập mã số booking không hợp lệ.");
                }
                for (Booking booking : bookingSet) {
                    if (bookingID.equals(booking.getBookingID())) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã số booking");
                    }
                }
                return bookingID;
            } catch (EmptyInformationException | InvalidFormatException | DuplicateInfoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập mã số booking bị lỗi.");
            }
            System.out.println("Hãy nhập lại.");
        } while (true);
    }

    public static LocalDate enterStartDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate startDay;
        int validTime;
        String dateString;
        do {
            System.out.println("Hãy nhập ngày bắt đầu với định dạng dd/MM/yyyy: ");
            try {
                String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                dateString = scanner.nextLine().trim();
                if (dateString.isEmpty()) {
                    throw new EmptyInformationException("\nBạn chưa nhập thông tin về ngày bắt đầu.");
                }
                if (!dateString.matches(regexDate)) {
                    throw new InvalidDateException("\nBạn đã nhập sai định dạng.");
                }
                startDay = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validTime = LocalDate.now().until(startDay).getDays();
                if (validTime >= 0) {
                    return startDay;
                }
                throw new OutOfValuesRange("\nBạn đã nhập không hợp lệ. " +
                        "\nNgày bắt đầu phải là thời điểm sau hoặc bằng ngày hiện tại.");
            } catch (DateTimeParseException e) {
                System.out.println("\nNhập sai định dạng ngày tháng.");
            } catch (InvalidDateException | OutOfValuesRange e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static LocalDate enterEndDate(LocalDate startDate) {
        Scanner scanner = new Scanner(System.in);
        LocalDate endDay;
        int validTime;
        String dateString;
        do {
            System.out.println("Hãy nhập ngày kết thúc với định dạng dd/MM/yyyy: ");
            try {
                String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                dateString = scanner.nextLine().trim();
                if (dateString.isEmpty()) {
                    throw new EmptyInformationException("\nBạn chưa nhập thông tin về ngày trả dịch vụ.");
                }
                if (!dateString.matches(regexDate)) {
                    throw new InvalidDateException("\nBạn đã nhập sai định dạng.");
                }
                endDay = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validTime = startDate.until(endDay).getDays();
                if (validTime >= 0) {
                    return endDay;
                }
                throw new OutOfValuesRange("\nBạn đã nhập không hợp lệ." +
                        "\nNgày kết thúc phải là thời điểm sau hoặc bằng ngày bắt đầu.");
            } catch (DateTimeParseException e) {
                System.out.println("\nNhập sai định dạng.");
            } catch (InvalidDateException | OutOfValuesRange e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("\nBạn đã nhập lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterCustomerIDForBooking() {
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile(LINK_CUSTOMER_FILE);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        String regexCustomerID = "^CUS-\\d+$";
        String customerID;
        do {
            try {
                System.out.println("Nhập mã số khách hàng (CUS-XXXX , X là số): ");
                customerID = SCANNER.nextLine().trim();
                if (customerID.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!customerID.matches(regexCustomerID)) {
                    throw new InvalidFormatException("Bạn đã nhập mã số khách hàng không hợp lệ.");
                }
                for(Customer customer : customerList){
                    if(customer.getCustomerID().contains(customerID)){
                        return customerID;
                    }
                }
                throw new InfoDoesNotExistException("Mã số khách hàng không tồn tại");
            } catch (EmptyInformationException | InvalidFormatException |InfoDoesNotExistException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập mã số bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterServiceNameForBooking() {
        Map<Villa, Integer> villaIntegerMap = ReadAndWriteFile.readVillaFromFile(LINK_VILLA_FILE);
        Map<House, Integer> houseIntegerMap = ReadAndWriteFile.readHouseFromFile(LINK_HOUSE_FILE);
        Map<Room, Integer> roomIntegerMap = ReadAndWriteFile.readRoomFromFile(LINK_ROOM_FILE);
        for (Map.Entry<Villa, Integer> villaIntegerEntry : villaIntegerMap.entrySet()) {
            System.out.println(villaIntegerEntry.getKey() + "," + villaIntegerEntry.getValue());
        }
        for (Map.Entry<House, Integer> houseIntegerEntry : houseIntegerMap.entrySet()) {
            System.out.println(houseIntegerEntry.getKey() + "," + houseIntegerEntry.getValue());
        }
        for (Map.Entry<Room, Integer> roomIntegerEntry : roomIntegerMap.entrySet()) {
            System.out.println(roomIntegerEntry.getKey() + "," + roomIntegerEntry.getValue());
        }
        String serviceName;
        String nameRegex = "^(?=^.{5,50}$)(\\p{L}+(\\s\\p{L}+)*)$";
        System.out.println("Lưu ý khi nhập thông tin:" +
                "\nTrong phạm vi từ 5-50 ký tự" +
                "\nKhông được chứa ký tự đặc biệt và số." +
                "\nMời bạn nhập thông tin: ");
        while (true) {
            try {
                System.out.println("Nhập tên dịch vụ: ");
                serviceName = SCANNER.nextLine().trim();
                if (serviceName.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!serviceName.matches(nameRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                for (Map.Entry<Villa, Integer> villaIntegerEntry : villaIntegerMap.entrySet()) {
                    if (villaIntegerEntry.getKey().getServiceName().equals(serviceName)) {
                        return serviceName;
                    }
                }
                for (Map.Entry<House, Integer> houseIntegerEntry : houseIntegerMap.entrySet()) {
                    if (houseIntegerEntry.getKey().getServiceName().equals(serviceName)) {
                        return serviceName;
                    }
                }
                for (Map.Entry<Room, Integer> roomIntegerEntry : roomIntegerMap.entrySet()) {
                    if(roomIntegerEntry.getKey().getServiceName().equals(serviceName)){
                        return serviceName;
                    }
                }
                throw new InfoDoesNotExistException("Không tồn tại tên dịch vụ đã nhập.");
            } catch (EmptyInformationException | InvalidFormatException | InfoDoesNotExistException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Hãy nhập lại.");
        }
    }
}
