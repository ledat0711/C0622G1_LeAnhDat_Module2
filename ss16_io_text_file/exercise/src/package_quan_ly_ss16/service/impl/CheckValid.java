package package_quan_ly_ss16.service.impl;

import package_quan_ly_ss16.utils.exception.InvalidException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckValid {
    public static Scanner scanner = new Scanner(System.in);

    public static String checkAndEnterDate() {
        int i = 0;
        boolean isValidDate = false;
        String inputDate = "";
        String trueFormat = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        while (i < 10) {
            i++;
            try {
                inputDate = scanner.nextLine();
                isValidDate = Pattern.matches(trueFormat, inputDate);
                if(!isValidDate){
                    throw new InvalidException("Bạn đã nhập ngày sinh chưa hợp lệ.\n" +
                            "Định dạng ngày sinh chúng tôi thiết lập là: dd/mm/yyyy\n" +
                            "Ngoài ra, chú ý giá trị giới hạn của ngày và tháng.");
                }
                break;
            }catch (InvalidException ie){
                System.out.println(ie.getMessage());
            }catch (Exception e){
                System.out.println("Bạn đã nhập lỗi. Vui lòng nhập lại.");
            }
            System.out.print("Vui lòng nhập lại ngày sinh: ");
        }
        return inputDate;
    }
}
