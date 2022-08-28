package case_study.utils.common;
import java.util.Scanner;
public class CommonController {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static String inputValidChoice(String regex) {
        while (true) {
            String choiceString = SCANNER.nextLine();
            if (choiceString.matches(regex)) {
                return choiceString;
            } else {
                System.out.println("\nBạn đã nhập không hợp lệ.");
                System.out.print("Vui lòng nhập lại lựa chọn: ");
            }
        }
    }
}
