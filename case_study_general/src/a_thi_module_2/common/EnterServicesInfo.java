package a_thi_module_2.common;

import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.*;
import case_study.utils.exception.DuplicateInfoException;
import case_study.utils.exception.EmptyInformationException;
import case_study.utils.exception.InvalidFormatException;
import case_study.utils.exception.OutOfValuesRange;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EnterServicesInfo {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * @method: returnServiceID();
     * @duties: Kiểm tra mã dịch vụ phải đúng định dạng SV(VL|HO|RO)-YYYY.
     * Mã dịch vụ không được trùng.
     * @return: Mã dịch vụ (String)
     */
    public static String returnServiceID() {
        Map<Villa, Integer> villaIntegerMap = ReadAndWriteFile.readVillaFromFile("src\\case_study\\data\\facilities\\villa.csv");
        Map<House, Integer> houseIntegerMap = ReadAndWriteFile.readHouseFromFile("src\\case_study\\data\\facilities\\house.csv");
        Map<Room, Integer> roomIntegerMap = ReadAndWriteFile.readRoomFromFile("src\\case_study\\data\\facilities\\room.csv");
        String serviceRegex = "SV(VL|HO|RO)-\\d{4}";
        String serviceID;
        while (true) {
            try {
                System.out.println("Định dạng khi nhập mã dịch vụ:" +
                        "\nVilla: SVVL-YYYY" +
                        "\nHouse: SVHO-YYYY" +
                        "\nRoom: SVRO-YYYY" +
                        "\nVới Y là chữ số." +
                        "\nMời bạn nhập mã dịch vụ:");
                serviceID = SCANNER.nextLine().trim();
                if (serviceID.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!serviceID.matches(serviceRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập mã dịch vụ không hợp lệ");
                }
                for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
                    if (entry.getKey().getServiceID().equals(serviceID)) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã dịch vụ Villa");
                    }
                }
                for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
                    if (entry.getKey().getServiceID().equals(serviceID)) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã dịch vụ House");
                    }
                }
                for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
                    if (entry.getKey().getServiceID().equals(serviceID)) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã dịch vụ Room");
                    }
                }
                return serviceID;
            } catch (EmptyInformationException | InvalidFormatException | DuplicateInfoException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.print("Vui lòng nhập lại mã dịch vụ: ");
        }
    }

    public static String checkAndReturnServiceName() {
        String serviceName;
        String nameRegex = "^(?=^.{5,50}$)(\\p{L}+(\\s\\p{L}+)*)$";
        System.out.println("Lưu ý khi nhập thông tin:" +
                "\nTrong phạm vi từ 5-50 ký tự" +
                "\nKhông được chứa ký tự đặc biệt và số." +
                "\nMời bạn nhập thông tin: ");
        while (true) {
            try {
                System.out.println("Nhập thông tin vào đây: ");
                serviceName = SCANNER.nextLine().trim();
                if(serviceName.isEmpty()){
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if(!serviceName.matches(nameRegex)){
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                return serviceName;
            }catch (EmptyInformationException|InvalidFormatException e){
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Hãy nhập lại.");
        }
    }


    public static String formatAndReturnServiceName() {
        String serviceName = checkAndReturnServiceName();
        String[] arr = serviceName.toLowerCase().trim().split("");
        StringBuilder str = new StringBuilder().append(arr[0].toUpperCase());
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(" ")) {
                if (arr[i - 1].equals(" ")) {
                    str.append(arr[i].toUpperCase());
                } else {
                    str.append(arr[i]);
                }
            } else if (!arr[i + 1].equals(" ")) {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }

    public static String returnAreaDouble() {
        String areaRegex = "^[3-9][0-9]+([\\.]+[0-9]+)*$";
        String area;
        double areaDouble;
        do {
            try {
                System.out.println("Hãy nhập diện tích (lớn hơn 30 m2): ");
                area = SCANNER.nextLine();
                if (area.isEmpty()) {
                    throw new EmptyInformationException("Bạn đã để trống thông tin.");
                }
                if (!area.matches(areaRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                return area;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Bạn hãy nhập lại.");
        } while (true);
    }

    public static String returnRentalPriceAndFloor() {
        String rentalPriceRegex = "[1-9][0-9]*";
        String rentalPrice;
        do {
            try {
                System.out.println("Nhập vào số dương: ");
                rentalPrice = SCANNER.nextLine();
                if (rentalPrice.isEmpty()) {
                    throw new EmptyInformationException("Bạn đã để trống thông tin.");
                }
                if (!rentalPrice.matches(rentalPriceRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                return rentalPrice;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Bạn hãy nhập lại.");
        } while (true);
    }

    public static int returnMaxPeopleServiceInt() {
        String maxPeopleRegex = "[1-9][0-9]*";
        String maxPeople;
        int maxPeopleInt;
        do {
            try {
                System.out.println("Hãy nhập vào số người tối đa (1-19 người): ");
                maxPeople = SCANNER.nextLine();
                if (maxPeople.isEmpty()) {
                    throw new EmptyInformationException("Bạn đã để trống thông tin.");
                }
                if (!maxPeople.matches(maxPeopleRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                if (Integer.parseInt(maxPeople) >= 20 || Integer.parseInt(maxPeople) <= 0) {
                    throw new OutOfValuesRange("Bạn đã nhập thông tin vượt ngoài giá trị.");
                }
                maxPeopleInt = Integer.parseInt(maxPeople);
                return maxPeopleInt;
            } catch (EmptyInformationException | InvalidFormatException | OutOfValuesRange e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Đã xảy ra lỗi chuyển đổi kiểu dữ liệu.");
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Bạn hãy nhập lại.");
        } while (true);
    }

    public static String returnTypeOfRental() {
        String selection;
        do {
            System.out.println("Chọn các số tương ứng với các kiểu cho thuê:" +
                    "\n1. Thuê Theo Năm" +
                    "\n2. Thuê Theo Tháng" +
                    "\n3. Thuê Theo Ngày" +
                    "\n4. Thuê Theo Giờ" +
                    "\nLựa chọn của bạn: ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    System.out.println("Bạn đã nhập 'Thuê Theo Năm'");
                    return "Thuê Theo Năm";
                case "2":
                    System.out.println("Bạn đã nhập 'Thuê Theo Tháng'");
                    return "Thuê Theo Tháng";
                case "3":
                    System.out.println("Bạn đã nhập 'Thuê Theo Ngày'");
                    return "Thuê Theo Ngày";
                case "4":
                    System.out.println("Bạn đã nhập 'Thuê Theo Giờ");
                    return "Thuê Theo Giờ";
                default:
                    System.out.println("Đã chọn sai. Bạn hãy nhập lại.");
            }
        } while (true);
    }

    public static int returnTimesUse() {
        String maxPeopleRegex = "[1-9][0-9]*";
        String maxPeople;
        int maxPeopleInt;
        do {
            try {
                System.out.println("Hãy nhập vào số lần sử dụng: ");
                maxPeople = SCANNER.nextLine();
                if (maxPeople.isEmpty()) {
                    throw new EmptyInformationException("Bạn đã để trống thông tin.");
                }
                if (!maxPeople.matches(maxPeopleRegex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                maxPeopleInt = Integer.parseInt(maxPeople);
                return maxPeopleInt;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Đã xảy ra lỗi chuyển đổi kiểu dữ liệu.");
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Bạn hãy nhập lại.");
        } while (true);
    }
}
