package z_test;

import case_study.common.CheckAndReturnPeopleInfo;
import case_study.model.person.Employee;
import case_study.utils.read_write_data.ReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class Test1 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        remove();
    }

    public static void remove() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployeeFromFile("src\\case_study\\data\\person\\employee.csv");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Employee employeeFound = (Employee) CheckAndReturnPeopleInfo.checkIDReturnObject(employeeList, "nhân viên", "EMP-[0-9]{4}", "xóa");
        if (employeeFound == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
            return;
        }
        System.out.println("Bạn có chắc muốn xóa nhân viên có mã số " + employeeFound.getEmployeeID() + " không?");
        System.out.println("Phím 1: Có" +
                "\nBất kỳ phím khác: không");
        String selection = SCANNER.nextLine();
        if (selection.equals("1")) {
            employeeList.remove(employeeFound);
            System.out.println("Xóa thành công.");
            ReadAndWriteFile.writeEmployeeToFile("src\\case_study\\data\\person\\employee.csv", employeeList, false);
        } else {
            System.out.println("Bạn đã chọn không xóa thông tin.");
        }
    }
}