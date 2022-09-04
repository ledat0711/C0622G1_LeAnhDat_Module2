package case_study.common;
import java.util.Scanner;

public class CommonController {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputValidChoice(String regex) {
        String choiceString;
        while (true) {
            choiceString = SCANNER.nextLine().trim();
            if (choiceString.matches(regex)) {
                return choiceString;
            } else {
                System.err.println("\nBạn đã nhập không hợp lệ.");
                System.out.println("Vui lòng nhập lại lựa chọn: ");
            }
        }
    }
}