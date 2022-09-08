package case_study.common;

import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.utils.exception.*;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EnterPeopleInfo {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Phương thức checkAndReturnName: Không được gọi trong các Class Service.
     * Mục đích: Hỗ trợ cho phương thức formatAndReturnName.
     * Chức năng : Kiểm tra tên nhập vào trong phạm vi 5-50 ký tự.
     * Tên không được chứa ký tự đặc biệt và số.
     * Chữ cái đầu tiên của mỗi từ viết hoa/thường đều được.
     *
     * @return name(kiểu String) chưa được định dạng đúng.
     */

    public static String checkAndReturnPeopleName() {
        String name;
        String nameRegex = "^(?=^.{5,50}$)(\\p{L}+(\\s\\p{L}+)*)$";
        System.out.println("Lưu ý khi nhập tên:" +
                "\nHọ và tên trong phạm vi từ 5-50 ký tự" +
                "\nKhông được chứa ký tự đặc biệt và số." +
                "\nMời bạn nhập tên: ");
        while (true) {
            try {
                System.out.println("Hãy nhập tên: ");
                name = SCANNER.nextLine().trim();
                if(name.isEmpty()){
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if(!name.matches(nameRegex)){
                    throw new InvalidFormatException("Bạn đã nhập tên không hợp lệ.");
                }
                return name;
            }catch (EmptyInformationException|InvalidFormatException e){
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Bạn hãy nhập lại.");
        }
    }

    /**
     * Phương thức formatAndReturnName.
     * Chức năng: định dạng lại tên đúng với yêu cầu.
     *
     * @return name(kiểu String) đã được định dạng đúng.
     */
    public static String formatAndEnterPeopleName() {
        String peopleName = checkAndReturnPeopleName();
        String[] arr = peopleName.toLowerCase().trim().split("");
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


    /**
     * Phương thức checkIDReturnObject
     */
    public static Object checkIDReturnObject(List<?> objectList, String determineFlow, String regex, String doSomething) {
        String id;
        int i;
        while (true) {
            try {
                System.out.printf("Mời bạn nhập ID của %s cần %s: ", determineFlow, doSomething);
                id = SCANNER.nextLine().trim();
                if (id.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.\nHãy nhập lại.");
                }
                if (!id.matches(regex)) {
                    throw new InvalidFormatException("Bạn đã nhập sai định dạng");
                }
                break;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Đã nhập thông tin bị lỗi.\nHãy nhập lại.");
            }
        }
        if (determineFlow.equals("nhân viên")) {
            List<Employee> employeeList = (List<Employee>) objectList;
            for (i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeID().equals(id)) {
                    return employeeList.get(i);
                }
            }
        } else {
            List<Customer> customerList = (List<Customer>) objectList;
            for (i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getCustomerID().equals(id)) {
                    return customerList.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Phương thức checkAndReturnDate():
     * Nhập vào chuỗi ngày tháng năm.
     * Phải nhập đúng định dạng dd/MM/yyyy
     */
    public static LocalDate enterBirthDate(int minAge, int maxAge) {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDay;
        int age;
        String dateString;
        do {
            System.out.println("Mời bạn nhập ngày sinh (dd/MM/yyyy): ");
            try {
                String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                dateString = scanner.nextLine().trim();
                if (dateString.isEmpty()) {
                    throw new EmptyInformationException("\nBạn chưa nhập thông tin ngày sinh.");
                }
                if (!dateString.matches(regexDate)) {
                    throw new InvalidDateException("\nBạn đã nhập sai định dạng.");
                }
                birthDay = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                age = birthDay.until(LocalDate.now()).getYears();
                if (age > minAge && age < maxAge) {
                    return birthDay;
                }
                throw new OutOfValuesRange("\nBạn đã nhập ngoài phạm vi độ tuổi.\nPhạm vi độ tuổi: " + minAge + " -> " + maxAge);
            } catch (DateTimeParseException e) {
                System.err.println("\nNhập sai định dạng.");
            } catch (InvalidDateException | OutOfValuesRange e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterGender() {
        String selection;
        while (true) {
            System.out.println("Mời bạn nhập giới tính: ");
            System.out.printf("%s-%s\n%s-%s\n%s-%s", 1, "Nam", 2, "Nữ", 3, "Giới tính khác");
            System.out.println("\nLựa chọn của bạn (Nhập một con số trong khoảng từ 1 đến 3): ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    System.out.println("Đã chọn giới tính Nam");
                    return "Nam";
                case "2":
                    System.out.println("Đã chọn giới tính Nữ");
                    return "Nữ";
                case "3":
                    System.out.println("Đã chọn giới tính Khác");
                    return "Giới tính khác";
                default:
                    System.err.println("\nBạn đã nhập thông tin bị lỗi.");
            }
            System.out.println("Hãy nhập lại.");
        }
    }

    /**
     * @method: returnPersonalID();
     * @duty: Kiểm tra sự hợp lệ của CMND/CCCD nhập vào và trả về số CMND/CCCD hợp lệ.
     * Nhập sai sẽ nhập lại đến khi nhập hợp lệ.
     * Số CMND/CCCD hợp lệ: 9 hoặc 12 chữ số. (không chứa chữ hoặc ký tự đặc biệt).
     * Không được nhập trùng số CMND/CCCD trong file dữ liệu.
     * @return: personalID (kiểu String).
     */
    public static String enterPersonalID() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile("src\\case_study\\data\\person\\employee.csv");
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile("src\\case_study\\data\\person\\customer.csv");
        String personalID;
        String regexPersonalID = "^\\d{9}|\\d{12}$";
        do {
            try {
                System.out.println("Nhập số CMND/CCCD (Nhập 9 hoặc 12 chữ số): ");
                personalID = SCANNER.nextLine().trim();
                if (personalID.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!personalID.matches(regexPersonalID)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ.");
                }
                for (Employee employee : employeeList) {
                    if (personalID.equals(employee.getPersonalID())) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng số CMND/CCCD");
                    }
                }
                for (Customer customer : customerList) {
                    if (personalID.equals(customer.getPersonalID())) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng số CMND/CCCD");
                    }
                }
                return personalID;
            } catch (InvalidFormatException | EmptyInformationException | DuplicateInfoException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Thông tin bạn đã nhập bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterPhoneNumber() {
        String regexPhoneNumber = "^(0|84)\\d{9}$";
        String phoneNumber;
        do {
            try {
                System.out.println("Nhập số điện thoại (0/84)XXXXXXXXX: ");
                phoneNumber = SCANNER.nextLine().trim();
                if (phoneNumber.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!phoneNumber.matches(regexPhoneNumber)) {
                    throw new InvalidFormatException("Bạn đã nhập số điện thoại không hợp lệ.");
                }
                return phoneNumber;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập số điện thoại bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterEmail() {
        String regexEmail = "^[\\w.]+@[a-zA-Z0-9.]+$";
        String email;
        do {
            try {
                System.out.println("Nhập email: ");
                email = SCANNER.nextLine().trim();
                if (email.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!email.matches(regexEmail)) {
                    throw new InvalidFormatException("Bạn đã nhập email không hợp lệ.");
                }
                return email;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập email bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterEmployeeID() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile("src\\case_study\\data\\person\\employee.csv");
        String regexEmployeeID = "^EMP-\\d{4}$";
        String employeeID;
        do {
            try {
                System.out.println("Nhập mã số nhân viên (EMP-XXXX , X là số): ");
                employeeID = SCANNER.nextLine().trim();
                if (employeeID.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!employeeID.matches(regexEmployeeID)) {
                    throw new InvalidFormatException("Bạn đã nhập mã số nhân viên không hợp lệ.");
                }
                for (Employee employee : employeeList) {
                    if (employeeID.equals(employee.getEmployeeID())) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã số nhân viên");
                    }
                }
                return employeeID;
            } catch (EmptyInformationException | InvalidFormatException | DuplicateInfoException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập mã số nhân viên bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterEmployeeAcademicLevel() {
        String selection;
        do {
            System.out.println("Chọn các số tương ứng với các trình độ:" +
                    "\n1. Trung cấp" +
                    "\n2. Cao đẳng" +
                    "\n3. Đại học" +
                    "\n4. Sau đại học" +
                    "\nLựa chọn của bạn: ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    System.out.println("Bạn đã nhập 'Trung cấp'");
                    return "Trung cấp";
                case "2":
                    System.out.println("Bạn đã nhập 'Cao đẳng'");
                    return "Cao đẳng";
                case "3":
                    System.out.println("Bạn đã nhập 'Đại học'");
                    return "Đại học";
                case "4":
                    System.out.println("Bạn đã nhập 'Sau đại học'");
                    return "Sau đại học";
                default:
                    System.err.println("Đã chọn sai. Bạn hãy nhập lại.");
            }
        } while (true);
    }


    public static String enterEmployeePosition() {
        String selection;
        do {
            System.out.println("Chọn các số tương ứng với thông tin các vị trí:" +
                    "\n1. Lễ tân" +
                    "\n2. Phục vụ" +
                    "\n3. Chuyên viên" +
                    "\n4. Giám sát" +
                    "\n5. Quản lý" +
                    "\n6. Giám đốc" +
                    "\nLựa chọn của bạn: ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    System.out.println("Bạn đã nhập 'Lễ Tân'");
                    return "Lễ tân";
                case "2":
                    System.out.println("Bạn đã nhập 'Phục vụ'");
                    return "Phục vụ";
                case "3":
                    System.out.println("Bạn đã nhập 'Chuyên viên'");
                    return "Chuyên viên";
                case "4":
                    System.out.println("Bạn đã nhập 'Giám sát'");
                    return "Giám sát";
                case "5":
                    System.out.println("Bạn đã nhập 'Quản lý'");
                    return "Quản lý";
                case "6":
                    System.out.println("Bạn đã nhập 'Giám đốc'");
                    return "Giám đốc";
                default:
                    System.err.println("Đã chọn sai. Bạn hãy nhập lại.");
            }
        } while (true);
    }

    public static String enterEmployeeSalary() {
        String regexSalary = "^[1-9][0-9]{6,}$";
        String salary;
        do {
            try {
                System.out.println("Nhập mức lương (Mức tối thiểu 100000 (Một trăm ngàn): ");
                salary = SCANNER.nextLine().trim();
                if (salary.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin mức lương.");
                }
                if (!salary.matches(regexSalary)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin mức lương không hợp lệ.");
                }
                return salary;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập mức lương bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }


    /**----------------------------------NHẬP THÔNG TIN KHÁC HÀNG-------------------------------------------------------
     */

    public static String enterCustomerID() {
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile("src\\case_study\\data\\person\\customer.csv");
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
                for (Customer customer : customerList) {
                    if (customerID.equals(customer.getCustomerID())) {
                        throw new DuplicateInfoException("Bạn đã nhập trùng mã số khách hàng");
                    }
                }
                return customerID;
            } catch (EmptyInformationException | InvalidFormatException | DuplicateInfoException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập mã số bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }

    public static String enterCustomerType() {
        String selection;
        while (true) {
            System.out.println("Nhập loại khách hàng.\nVới các lựa chọn:");
            System.out.printf("%s-%s\n%s-%s\n%s-%s\n%s-%s\n%s-%s",
                    1, "Diamond", 2, "Platinium", 3, "Gold", 4, "Silver", 5, "Member");
            System.out.println("\nĐiền một con số từ số 1 -> 5: ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    System.out.println("Bạn đã nhập Diamond");
                    return "Diamond";
                case "2":
                    System.out.println("Bạn đã nhập Platinium");
                    return "Platinium";
                case "3":
                    System.out.println("Bạn đã nhập Gold");
                    return "Gold";
                case "4":
                    System.out.println("Bạn đã nhập Silver");
                    return "Silver";
                case "5":
                    System.out.println("Bạn đã nhập Member");
                    return "Member";
                default:
                    System.out.println("Thông tin đã nhập bị lỗi. Vui lòng nhập lại.");
            }
        }
    }

    public static String enterCustomerAddress() {
        String regexAddress = "^([\\p{L}0-9._\\-]+(\\s*[\\p{L}0-9._\\-]*))+$";
        String address;
        do {
            try {
                System.out.println("Nhập địa chỉ" +
                        "\nDùng các dấu: '_' hoặc '-' hoặc '.' để ngăn cách giữa các thành phần" +
                        "\nKhông được dùng dấu phẩy (',') : ");
                address = SCANNER.nextLine().trim();
                if (address.isEmpty()) {
                    throw new EmptyInformationException("Bạn chưa nhập thông tin.");
                }
                if (!address.matches(regexAddress)) {
                    throw new InvalidFormatException("Bạn đã nhập địa chỉ không hợp lệ.");
                }
                return address;
            } catch (EmptyInformationException | InvalidFormatException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bạn đã nhập địa chỉ bị lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }
}
