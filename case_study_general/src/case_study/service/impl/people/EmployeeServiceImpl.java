/*
            System.out.println("1. Display list employees.");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            */
package case_study.service.impl.people;
import case_study.utils.common.*;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static case_study.controller.EmployeeController.displayEmployeeManagementMenu;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        EMPLOYEE_LIST.add(new Employee("Đức Nguyễn", "12/08/1995", "Nam", "201616456",
                "0967114677", "ducng123@gmail.com", "NV24511",
                "Cao Đẳng", "Lễ tân", 500000));
        EMPLOYEE_LIST.add(new Employee("Vi Lê", "22/09/1996", "nữ", "201515211",
                "0967114677", "ducng123@gmail.com", "NV11678",
                "Cao Đẳng", "Lễ tân", 500000));
        EMPLOYEE_LIST.add(new Employee("Đức Nguyễn", "12/08/1995", "Nam", "201312433",
                "0967114677", "ducng123@gmail.com", "NV00544",
                "Cao Đẳng", "Lễ tân", 500000));
    }

    @Override
    public void display() {
        int i;
        System.out.println("-------------------------------------------");
        System.out.println("Danh sách nhân viên: ");
        for (i = 0; i < EMPLOYEE_LIST.size(); i++) {
            System.out.println((i + 1) + ": " + EMPLOYEE_LIST.get(i).toString());
        }
    }

    @Override
    public void add() {
        System.out.println("-------------------------------------------" +
                "\nBạn đang sử dụng chức năng thêm thông tin nhân viên. ");
        Employee employee = this.addInfoEmployee();
        EMPLOYEE_LIST.add(employee);
        System.out.println("Thêm mới thông tin nhân viên thành công");
    }


    public Employee addInfoEmployee() {
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
        System.out.print("Mời bạn nhập mã số nhân viên: ");
        String employeeID = SCANNER.nextLine();
        System.out.print("Mời bạn nhập trình độ học vấn: ");
        String academicLevel = SCANNER.nextLine();
        System.out.print("Mời bạn nhập vị trí: ");
        String jobPosition = SCANNER.nextLine();
        System.out.print("Mời bạn nhập mức lương: ");
        int salary = Integer.parseInt(SCANNER.nextLine());
        return new Employee(name, dateOfBirth, gender, id,
                phoneNumber, email, employeeID, academicLevel, jobPosition, salary);
    }
    @Override
    public void edit() {
        Employee employeeFound = (Employee) CommonService.checkIDReturnObject(EMPLOYEE_LIST, "nhân viên");
        if (employeeFound == null) {
            System.out.println("Không tồn tại nhân viên với ID đã nhập.");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println("Nhân viên cần chỉnh sửa:");
        System.out.println(employeeFound);
        String selection;
        int i = 0;
        do {
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Tên nhân viên.");
            System.out.println("2. Ngày sinh.");
            System.out.println("3. Giới tính");
            System.out.println("4. Số CMND/CCCD");
            System.out.println("5. Số điện thoại.");
            System.out.println("6. Email");
            System.out.println("7. Mã số nhân viên");
            System.out.println("8. Trình độ học vấn");
            System.out.println("9. Vị trí");
            System.out.println("10. Mức lương");
            System.out.println("11. Quay lại menu quản lý nhân viên.");
            System.out.println("Lựa chọn của bạn (Nhập lựa chọn từ số 1 - 10): ");
            selection = SCANNER.nextLine();
            switch (selection) {
                case "1":
                    System.out.println("Mời bạn nhập tên mới:");
                    employeeFound.setName(CommonService.checkAndFormatName());
                    break;
                case "2":
                    System.out.println("Mời bạn nhập ngày sinh mới:");
                    employeeFound.setDateOfBirth(SCANNER.nextLine());
                    break;
                case "3":
                    System.out.println("Mời bạn nhập giới tính mới:");
                    employeeFound.setGender(CommonService.enterGenderCommonProcess());
                    break;
                case "4":
                    System.out.println("Mời bạn nhập số CMND/CCCD mới:");
                    employeeFound.setID(SCANNER.nextLine());
                    break;
                case "5":
                    System.out.println("Mời bạn nhập số điện thoại mới:");
                    employeeFound.setPhoneNumber(SCANNER.nextLine());
                    break;
                case "6":
                    System.out.println("Mời bạn nhập email mới:");
                    employeeFound.setEmail(SCANNER.nextLine());
                    break;
                case "7":
                    System.out.println("Mời bạn nhập mã số nhân viên mới:");
                    employeeFound.setEmployeeID(SCANNER.nextLine());
                    break;
                case "8":
                    System.out.println("Mời bạn nhập thông tin về trình độ mới:");
                    employeeFound.setAcademicLevel(SCANNER.nextLine());
                    break;
                case "9":
                    System.out.println("Mời bạn nhập thông tin về vị trí đảm nhiệm mới:");
                    employeeFound.setJobPosition(SCANNER.nextLine());
                    break;
                case "10":
                    System.out.println("Mời bạn nhập mức lương mới:");
                    employeeFound.setSalary(Long.parseLong(SCANNER.nextLine()));
                    break;
                case "11":
                    displayEmployeeManagementMenu();
                    break;
                default:
                    System.out.println("Nội dung bạn vừa chọn không có trong menu.");
                    return;
            }
            System.out.println("Hoàn thành chỉnh sửa thông tin.");
            System.out.println(employeeFound);
            System.out.println("\nMời bạn lựa chọn thao tác tiếp theo:");
            System.out.println("Nhấn phím 1 để TIẾP TỤC.");
            System.out.println("Nhấn bất kỳ phím khác để quay lại 'Menu Quản Lý Nhân Viên'.");
            System.out.print("Lựa chọn của bạn: ");
            selection = SCANNER.nextLine();
            if (!selection.equals("1")) {
                return;
            }
            i++;
        } while (i < 10);
    }
}
