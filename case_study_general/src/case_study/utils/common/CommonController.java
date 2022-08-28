package case_study.utils.common;
import java.util.Scanner;
public class CommonController {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputValidChoice(String regex) {
        String choiceString = null;
        int i=0;
        while (i<10) {
            i++;
            choiceString = SCANNER.nextLine();
            if (choiceString.matches(regex)) {
                break;
            } else {
                System.out.println("\nBạn đã nhập không hợp lệ.");
                System.out.print("Vui lòng nhập lại lựa chọn: ");
            }
        }
        return choiceString;
    }
}
