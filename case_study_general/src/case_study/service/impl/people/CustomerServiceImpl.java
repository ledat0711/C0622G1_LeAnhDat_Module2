package case_study.service.impl.people;
import case_study.utils.common.*;
import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static case_study.controller.EmployeeController.displayEmployeeManagementMenu;

public class CustomerServiceImpl implements ICustomerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Customer> CUSTOMER_LIST = new LinkedList<>();

    static {
        CUSTOMER_LIST.add(new Customer("Vinh Nguyễn", "12/04/1995", "Nam", "201768999",
                "0978112556", "vinh12344@gmail.com", "KH44512",
                "Silver", "An Hải Đông - Sơn Trà - Đà Nẵng"));
        CUSTOMER_LIST.add(new Customer("Tâm Nguyễn", "24/12/1998", "Nữ", "201111786",
                "0956119007", "tamnguyen67@gmail.com", "KH77144",
                "Gold", "An Hải Tây - Sơn Trà - Đà Nẵng"));
        CUSTOMER_LIST.add(new Customer("Khang Lê", "15/04/1991", "Nam", "204589111",
                "0967454666", "khangle123@gmail.com", "KH88500",
                "Member", "Hòa Khánh Bắc - Liên Chiểu - Đà Nẵng"));
    }

    @Override
    public void display() {
        int i;
        System.out.println("-------------------------------------------");
        System.out.println("Danh sách khách hàng: ");
        for (i = 0; i < CUSTOMER_LIST.size(); i++) {
            System.out.println((i + 1) + ": " + CUSTOMER_LIST.get(i).toString());
        }
    }

    @Override
    public void add() {
        System.out.println("-------------------------------------------" +
                "\nBạn đang sử dụng chức năng thêm thông tin khách hàng. ");
        Customer customerAdding = this.addInfoCustomer();
        System.out.println("Thêm mới thành công!");
    }
    public Customer addInfoCustomer() {
        System.out.print("Mời bạn nhập tên : ");
        String name = CommonService.checkAndFormatName();
        System.out.print("Mời bạn nhập ngày sinh : ");
        String dateOfBirth = SCANNER.nextLine();
        System.out.print("Mời bạn nhập giới tính: ");
        String gender = SCANNER.nextLine();
        System.out.print("Mời bạn nhập số CMND/CCCD: ");
        String id = SCANNER.nextLine();
        System.out.print("Mời bạn nhập số điện thoại : ");
        String phoneNumber = SCANNER.nextLine();
        System.out.print("Mời bạn nhập email: ");
        String email = SCANNER.nextLine();
        System.out.print("Mời bạn nhập mã số khách hàng: ");
        String customerID = SCANNER.nextLine();
        System.out.print("Mời bạn nhập loại khách hàng: ");
        String customerType = SCANNER.nextLine();
        System.out.print("Mời bạn nhập địa chỉ: ");
        String address = SCANNER.nextLine();
        return new Customer(name,dateOfBirth,gender,id,phoneNumber,email,customerID,customerType,address);
    }

    @Override
    public void edit() {
        Customer customerFound = (Customer) CommonService.checkIDReturnObject(CUSTOMER_LIST, "khách hàng");
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
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
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
                    System.out.println("Mời bạn nhập tên mới:");
                    customerFound.setName(CommonService.checkAndFormatName());
                    break;
                case "2":
                    System.out.println("Mời bạn nhập ngày sinh mới:");
                    customerFound.setDateOfBirth(SCANNER.nextLine());
                    break;
                case "3":
                    System.out.println("Mời bạn nhập giới tính mới:");
                    customerFound.setGender(CommonService.enterGender());
                    break;
                case "4":
                    System.out.println("Mời bạn nhập số CMND/CCCD mới:");
                    customerFound.setID(SCANNER.nextLine());
                    break;
                case "5":
                    System.out.println("Mời bạn nhập số điện thoại mới:");
                    customerFound.setPhoneNumber(SCANNER.nextLine());
                    break;
                case "6":
                    System.out.println("Mời bạn nhập email mới:");
                    customerFound.setEmail(SCANNER.nextLine());
                    break;
                case "7":
                    System.out.println("Mời bạn nhập mã số khách hàng mới:");
                    customerFound.setCustomerID(SCANNER.nextLine());
                    break;
                case "8":
                    System.out.println("Mời bạn nhập thông tin về loại khách hàng mới:");
                    customerFound.setCustomerType(SCANNER.nextLine());
                    break;
                case "9":
                    System.out.println("Mời bạn nhập địa chỉ mới:");
                    customerFound.setAddress(SCANNER.nextLine());
                    break;
                case "10":
                    System.out.println("Mời bạn nhập mức lương mới:");
                    customerFound.setSalary(Long.parseLong(SCANNER.nextLine()));
                    break;
                case "11":
                    displayEmployeeManagementMenu();
                    break;
                default:
                    System.out.println("Nội dung bạn vừa chọn không có trong menu.");
                    return;
            }
            System.out.println("Hoàn thành chỉnh sửa thông tin.");
            System.out.println(customerFound);
            System.out.println("\nMời bạn lựa chọn thao tác tiếp theo:");
            System.out.println("Nhấn phím 1 để TIẾP TỤC.");
            System.out.println("Nhấn bất kỳ phím khác để quay lại 'Menu Quản Lý Khách Hàng'.");
            System.out.print("Lựa chọn của bạn: ");
            selection = SCANNER.nextLine();
            if (!selection.equals("1")) {
                return;
            }
            i++;
        } while (i < 10);
    }

}
