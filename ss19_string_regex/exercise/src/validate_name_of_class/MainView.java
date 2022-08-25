package validate_name_of_class;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        ClassNameSample classNameSample = new ClassNameSample();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();
        if (classNameSample.validate(className)) {
            System.out.println("Bạn đã nhập hợp lệ.");
        } else {
            System.out.println("Bạn đã nhập KHÔNG hợp lệ.");
        }
    }
}
