package a_thi_module_2.service.impl.people_impl;

import case_study.common.*;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String LINK_EMPLOYEE_FILE = "src\\case_study\\data\\person\\employee.csv";

    @Override
    public void display() {
        int i;
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        System.out.println("--------------Danh sách nhân viên--------------");
        if(employeeList.size() == 0){
            System.out.println("Danh sách nhân viên đang trống.");
        }
        for (i = 0; i < employeeList.size(); i++) {
            System.out.println("STT " + (i + 1) + ": " + employeeList.get(i));
        }
    }
    private void showInfo(List<Employee> employeeList) {
        System.out.println("EMPLOYEE_LIST");
        System.out.printf("|%-7s|%-20s|%-12s|%-7s|%-10s|%-10s|%-25s|%-12s|%-12s|%-12s|\n",
                "ID", "NAME", "DAY_OF_BIRTH", "GENDER", "IDENTITY",
                "PHONE", "EMAIL", "LEVEL", "POSITION", "SALARY");
        String infoE = "";
        for (Employee e : employeeList) {
            infoE = String.format("|%-7s|%-20s|%-12s|%-7s|%-10s|%-10s|%-25s|%-12s|%-12s|%12.2f|",
                    e.getEmployeeID(), e.getName(), e.getDateOfBirth(), e.getGender(), e.getPersonalID(),
                    e.getPhoneNumber(), e.getEmail(), e.getAcademicLevel(), e.getJobPosition(), e.getSalary());
            System.out.println(infoE);
        }
    }
    @Override
    public void add() {
        System.out.println("-------------------------------------------" +
                "\nBạn đang sử dụng chức năng thêm thông tin nhân viên. ");
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        Employee employeeAdding = this.addInfoEmployee(null);
        employeeList.add(employeeAdding);
        ReadAndWriteFile.writeEmployeeToFile(LINK_EMPLOYEE_FILE, employeeList, false);
        System.out.println("Thêm mới thành công!");
        System.out.println("Đã thêm thông tin sau vào danh sách:");
        System.out.println(employeeAdding.toString());
    }

    public Employee addInfoEmployee(String employeeID) {
        String name = EnterPeopleInfo.formatAndEnterPeopleName();
        LocalDate dateOfBirth = EnterPeopleInfo.enterBirthDate(18, 100);
        String gender = EnterPeopleInfo.enterGender();
        String personalID = EnterPeopleInfo.enterPersonalID();
        String phoneNumber = EnterPeopleInfo.enterPhoneNumber();
        String email = EnterPeopleInfo.enterEmail();

        if (employeeID == null) {
            employeeID = EnterPeopleInfo.enterEmployeeID();
        }

        String academicLevel = EnterPeopleInfo.enterEmployeeAcademicLevel();
        String jobPosition = EnterPeopleInfo.enterEmployeePosition();
        double salary = Double.parseDouble(EnterPeopleInfo.enterEmployeeSalary());
        return new Employee(name, dateOfBirth, gender, personalID,
                phoneNumber, email, employeeID, academicLevel, jobPosition, salary);
    }

    @Override
    public void edit() {
        int j;
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        Employee employeeFound = (Employee) EnterPeopleInfo.checkIDReturnObject(employeeList, "nhân viên", "EMP-[0-9]{4}", "edit");
        if (employeeFound == null) {
            System.out.println("Không tồn tại nhân viên với ID đã nhập.");
            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Thông tin nhân viên cần chỉnh sửa:");
        System.out.println(employeeFound);
        String selection;
        do {
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Tên nhân viên.");
            System.out.println("2. Ngày sinh.");
            System.out.println("3. Giới tính");
            System.out.println("4. Số CMND/CCCD");
            System.out.println("5. Số điện thoại.");
            System.out.println("6. Email");
            System.out.println("8. Trình độ học vấn");
            System.out.println("9. Vị trí");
            System.out.println("10. Mức lương");
            System.out.println("11. Chỉnh sửa toàn bộ thông tin.");
            System.out.println("12. Quay lại menu quản lý nhân viên.");
            System.out.println("Lựa chọn của bạn (Nhập một số từ 1 -> 12): ");
            selection = SCANNER.nextLine().trim();
            switch (selection) {
                case "1":
                    employeeFound.setName(EnterPeopleInfo.formatAndEnterPeopleName());
                    break;
                case "2":
                    employeeFound.setDateOfBirth(EnterPeopleInfo.enterBirthDate(18, 100));
                    break;
                case "3":
                    employeeFound.setGender(EnterPeopleInfo.enterGender());
                    break;
                case "4":
                    employeeFound.setPersonalID(EnterPeopleInfo.enterPersonalID());
                    break;
                case "5":
                    employeeFound.setPhoneNumber(EnterPeopleInfo.enterPhoneNumber());
                    break;
                case "6":
                    employeeFound.setEmail(EnterPeopleInfo.enterEmail());
                    break;
                case "8":
                    employeeFound.setAcademicLevel(EnterPeopleInfo.enterEmployeeAcademicLevel());
                    break;
                case "9":
                    employeeFound.setJobPosition(EnterPeopleInfo.enterEmployeePosition());
                    break;
                case "10":
                    employeeFound.setSalary(Double.parseDouble(EnterPeopleInfo.enterEmployeeSalary()));
                    break;
                case "11":
                    employeeFound = addInfoEmployee(employeeFound.getEmployeeID());
                    break;
                case "12":
                    return;
                default:
                    System.err.println("Bạn đã nhập lỗi.");
                    System.out.println("Vui lòng nhập lại.");
                    continue;
            }
            for (j = 0; j < employeeList.size(); j++) {
                if (employeeFound.getEmployeeID().equals(employeeList.get(j).getEmployeeID())) {
                    employeeList.set(j, employeeFound);
                    break;
                }
            }
            ReadAndWriteFile.writeEmployeeToFile(LINK_EMPLOYEE_FILE, employeeList, false);
            System.out.println("Hoàn thành chỉnh sửa thông tin.");
            System.out.println(employeeFound);
            System.out.println("\nMời bạn lựa chọn thao tác tiếp theo:");
            System.out.println("Nhấn phím 1 để TIẾP TỤC.");
            System.out.println("Nhấn bất kỳ phím khác để QUAY LẠI 'Menu Quản Lý Nhân Viên'.");
            System.out.print("Lựa chọn của bạn: ");
            selection = SCANNER.nextLine().trim();
            if (!selection.equals("1")) {
                return;
            }
        } while (true);
    }

    public static void remove() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        System.out.println("\nDanh sách nhân viên: ");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Employee employeeFound = (Employee) EnterPeopleInfo.checkIDReturnObject(employeeList, "nhân viên", "EMP-[0-9]{4}", "xóa");
        if (employeeFound == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
            return;
        }
        System.out.println("Bạn có chắc muốn xóa đối tượng bên dưới không?");
        System.out.println(employeeFound + "\n");
        System.out.println("Phím 1: Có" +
                "\nBất kỳ phím khác: không");
        String selection = SCANNER.nextLine().trim();
        if (selection.equals("1")) {
            employeeList.remove(employeeFound);
            System.out.println("Xóa thành công.");
            ReadAndWriteFile.writeEmployeeToFile(LINK_EMPLOYEE_FILE, employeeList, false);
        } else {
            System.out.println("Bạn đã chọn không xóa thông tin.");
        }
    }

    public static void findEmployee() {
        String selection;
        do {
            System.out.println("Các lựa chọn tìm kiếm:" +
                    "\n1.Tìm theo ID" +
                    "\n2.Tìm theo tên" +
                    "\n3.Thoát chức năng.");
            System.out.println("Lựa chọn của bạn: ");
            selection = SCANNER.nextLine();
            switch (selection) {
                case "1":
                    findByEmployeeID();
                    break;
                case "2":
                    findEmpployeeByName();
                    break;
                case "3":
                    return;
                default:
                    System.err.println("Bạn đã nhập sai.");
            }
        } while (true);
    }

    public static void findByEmployeeID() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        Employee employeeFound = (Employee) EnterPeopleInfo.checkIDReturnObject(employeeList, "nhân viên", "EMP-[0-9]{4}", "tìm kiếm");
        if (employeeFound == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
            return;
        }
        System.out.println("Thông tin nhân viên bạn cần tìm:");
        System.out.println(employeeFound);
    }

    public static void findEmpployeeByName() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        System.out.print("Nhập tên nhân viên muốn tìm: ");
        String nameToFind = SCANNER.nextLine();
        if(!checkEmployeeExitByName(nameToFind)){
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }
        System.out.println("Thông tin bạn muốn tìm: ");
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(nameToFind.toLowerCase())) {
                System.out.println(employee);
            }
        }
    }

    public static boolean checkEmployeeExitByName(String nameToFind) {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile(LINK_EMPLOYEE_FILE);
        for(Employee employee:employeeList){
            if(employee.getName().toLowerCase().contains(nameToFind.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
