package a_thi_module_2.common;

import a_thi_module_2.utils.exception.InvalidFormatException;

import java.util.Scanner;

public class CommonController {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputValidChoice(String regex) {
        String choiceString;
        while (true) {
            try {
                choiceString = SCANNER.nextLine().trim();
                if (!choiceString.matches(regex)) {
                    throw new InvalidFormatException("Bạn đã nhập thông tin không hợp lệ");
                }
                return choiceString;
            } catch (InvalidFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Hãy nhập lại lựa chọn:");
        }
    }
}