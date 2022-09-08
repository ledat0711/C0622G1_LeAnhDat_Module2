package a_thi_module_2.service.impl.people_impl;

import case_study.controller.CustomerController;
import case_study.common.*;
import case_study.model.person.Customer;
import case_study.service.ICustomerService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_CUSTOMER_FILE = "src\\case_study\\data\\person\\customer.csv";

//    private static final List<Customer> CUSTOMER_LIST = new LinkedList<>();
//
//    static {
//        CUSTOMER_LIST.add(new Customer("Vinh Nguyễn", LocalDate.parse("26-09-1994"), "Nam", "201768999",
//                "0978112556", "vinh12344@gmail.com", "KH44512",
//                "Silver", "An Hải Đông - Sơn Trà - Đà Nẵng"));
//        CUSTOMER_LIST.add(new Customer("Tâm Nguyễn", LocalDate.parse("11/09/1996"), "Nữ", "201111786",
//                "0956119007", "tamnguyen67@gmail.com", "1",
//                "Gold", "An Hải Tây - Sơn Trà - Đà Nẵng"));
//        CUSTOMER_LIST.add(new Customer("Khang Lê", LocalDate.parse("22/11/1999"), "Nam", "204589111",
//                "0967454666", "khangle123@gmail.com", "KH88500",
//                "Member", "Hòa Khánh Bắc - Liên Chiểu - Đà Nẵng"));
//    }


    @Override
    public void display() {
        int i;
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile(LINK_CUSTOMER_FILE);
        System.out.println("--------------Danh sách khác hàng--------------");
        for (i = 0; i < customerList.size(); i++) {
            System.out.println("STT " + (i + 1) + ": " + customerList.get(i));
        }
    }

    @Override
    public void add() {
        System.out.println("-------------------------------------------");
        System.out.println("Bạn đang sử dụng chức năng thêm thông tin khách hàng. ");
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile(LINK_CUSTOMER_FILE);
        Customer customerAdding = this.addInfoCustomer(null);
        customerList.add(customerAdding);
        ReadAndWriteFile.writeCustomerToFile(LINK_CUSTOMER_FILE, customerList, false);
        System.out.println("Thêm mới thành công!");
        System.out.println("Đã thêm thông tin sau vào danh sách:");
        System.out.println(customerAdding.toString());
    }

    public Customer addInfoCustomer(String customerID) {
        String name = EnterPeopleInfo.formatAndEnterPeopleName();
        LocalDate dateOfBirth = EnterPeopleInfo.enterBirthDate(18, 120);
        String gender = EnterPeopleInfo.enterGender();
        String personalID = EnterPeopleInfo.enterPersonalID();
        String phoneNumber = EnterPeopleInfo.enterPhoneNumber();
        String email = EnterPeopleInfo.enterEmail();

        if (customerID == null) {
            customerID = EnterPeopleInfo.enterCustomerID();
        }

        String customerType = EnterPeopleInfo.enterCustomerType();
        String address = EnterPeopleInfo.enterCustomerAddress();
        return new Customer(name, dateOfBirth, gender, personalID, phoneNumber, email, customerID, customerType, address);
    }

    @Override
    public void edit() {
        int j;
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile(LINK_CUSTOMER_FILE);
        Customer customerFound = (Customer) EnterPeopleInfo.checkIDReturnObject(customerList, "khách hàng", "CUS-[0-9]{4}", "edit");
        if (customerFound == null) {
            System.out.println("Không tồn tại khách hàng với ID đã nhập.");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println("Khách hàng cần chỉnh sửa:");
        System.out.println(customerFound);
        String selection;
        int i = 0;
        do {
            System.out.println("Chọn mục bạn muốn chỉnh sửa: ");
            System.out.println("1. Tên khách hàng.");
            System.out.println("2. Ngày sinh.");
            System.out.println("3. Giới tính");
            System.out.println("4. Số CMND/CCCD");
            System.out.println("5. Số điện thoại.");
            System.out.println("6. Email");
            System.out.println("7. Mã số khách hàng");
            System.out.println("8. Loại khách hàng");
            System.out.println("9. Địa chỉ");
            System.out.println("10. Quay lại menu quản lý nhân viên.");
            System.out.println("Lựa chọn của bạn (Nhập lựa chọn từ số 1 - 10): ");
            selection = SCANNER.nextLine();
            switch (selection) {
                case "1":
                    customerFound.setName(EnterPeopleInfo.formatAndEnterPeopleName());
                    break;
                case "2":
                    customerFound.setDateOfBirth(EnterPeopleInfo.enterBirthDate(18, 110));
                    break;
                case "3":
                    customerFound.setGender(EnterPeopleInfo.enterGender());
                    break;
                case "4":
                    customerFound.setPersonalID(EnterPeopleInfo.enterPersonalID());
                    break;
                case "5":
                    customerFound.setPhoneNumber(EnterPeopleInfo.enterPhoneNumber());
                    break;
                case "6":
                    customerFound.setEmail(EnterPeopleInfo.enterEmail());
                    break;
                case "8":
                    customerFound.setCustomerType(EnterPeopleInfo.enterCustomerType());
                    break;
                case "9":
                    customerFound.setAddress(EnterPeopleInfo.enterCustomerAddress());
                    break;
                case "10":
                    CustomerController.displayCustomerManagementMenu();
                    break;
                default:
                    System.err.println("Bạn đã nhập lỗi.");
                    System.out.println("Vui lòng nhập lại.");
                    continue;
            }
            for (j = 0; j < customerList.size(); j++) {
                if (customerFound.getCustomerID().equals(customerList.get(j).getCustomerID())) {
                    customerList.set(i, customerFound);
                    break;
                }
            }
            ReadAndWriteFile.writeCustomerToFile(LINK_CUSTOMER_FILE, customerList, false);
            System.out.println("Hoàn thành chỉnh sửa thông tin.");
            System.out.println(customerFound);
            System.out.println("\nMời bạn lựa chọn thao tác tiếp theo:");
            System.out.println("Nhấn phím 1 để TIẾP TỤC.");
            System.out.println("Nhấn bất kỳ phím khác để quay lại 'Menu Quản Lý Khách Hàng'.");
            System.out.print("Lựa chọn của bạn: ");
            selection = SCANNER.nextLine().trim();
            if (!selection.equals("1")) {
                return;
            }
        } while (true);
    }

    public static void remove() {
        List<Customer> customerList = ReadAndWriteFile.readCustomerFromFile(LINK_CUSTOMER_FILE);
        System.out.println("\nDanh sách khách hàng:");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        Customer customerFound = (Customer) EnterPeopleInfo.checkIDReturnObject(customerList, "khách hàng", "CUS-[0-9]{4}", "xóa");
        if (customerFound == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
            return;
        }
        System.out.println("Bạn có chắc muốn xóa đối tượng bên dưới không?");
        System.out.println(customerFound + "\n");
        System.out.println("Phím 1: Có" +
                "\nBất kỳ phím khác: không");
        String selection = SCANNER.nextLine().trim();
        if (selection.equals("1")) {
            customerList.remove(customerFound);
            System.out.println("Xóa thành công.");
            ReadAndWriteFile.writeCustomerToFile(LINK_CUSTOMER_FILE, customerList, false);
        } else {
            System.out.println("Bạn đã chọn không xóa thông tin.");
        }
    }

    public static void find(){
    }
}