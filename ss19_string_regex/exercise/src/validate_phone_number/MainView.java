package validate_phone_number;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        PhoneNumberSample phoneNumberSample = new PhoneNumberSample();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại để kiểm tra hợp lệ: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumberSample.validate(phoneNumber)) {
            System.out.println("Bạn đã nhập hợp lệ.");
        } else {
            System.out.println("Bạn đã nhập KHÔNG hợp lệ.");
        }
    }
}
