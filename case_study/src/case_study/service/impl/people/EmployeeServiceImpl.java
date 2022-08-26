/*
            System.out.println("1. Display list employees.");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            */
package service.impl.people;

import model.person.Employee;
import service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        EMPLOYEE_LIST.add(new Employee("Đức Nguyễn", "12/08/1995", "Nam", "201616456",
                "0967114677", "ducng123@gmail.com", "NV11678",
                "Cao Đẳng", "Lễ tân", 500000));
        EMPLOYEE_LIST.add(new Employee("Vi Lê", "22/09/1996", "nữ", "201515211",
                "0967114677", "ducng123@gmail.com", "NV11678",
                "Cao Đẳng", "Lễ tân", 500000));
        EMPLOYEE_LIST.add(new Employee("Đức Nguyễn", "12/08/1995", "Nam", "201312433",
                "0967114677", "ducng123@gmail.com", "NV11678",
                "Cao Đẳng", "Lễ tân", 500000));
    }

    @Override
    public void display() {
        int i;
        for (i = 0; i < EMPLOYEE_LIST.size(); i++) {
            System.out.println((i + 1) + EMPLOYEE_LIST.get(i).toString());
        }
    }

    @Override
    public void add() {
    }

    @Override
    public void update() {
    }

    public Employee addInfoStudent() {
        System.out.print("Mời bạn nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh : ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập số CMND/CCCD: ");
        String id = scanner.nextLine();
        System.out.print("Mời bạn nhập số điện thoại : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Mời bạn nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Mời bạn nhập mã số nhân viên: ");
        String employeeID = scanner.nextLine();
        System.out.print("Mời bạn nhập trình độ học vấn: ");
        String academicLevel = scanner.nextLine();
        System.out.print("Mời bạn nhập vị trí: ");
        String jobPosition = scanner.nextLine();
        System.out.print("Mời bạn nhập mức lương: ");
        int salary = Integer.parseInt(scanner.nextLine());
        return new Employee(name, dateOfBirth, gender, id, phoneNumber,
                email, employeeID, academicLevel, jobPosition, salary);
    }
}
