package z_test;

import case_study.utils.exception.InvalidDateException;
import case_study.utils.exception.OutOfValuesRange;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.lang.String;
public class TestDay {

    public static void main(String[] args) {
        enterDate(18,100);
    }
    public static LocalDate enterDate(int minAge, int maxAge) {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthday = null;
        int i = 0;
        do {
            i++;
            try {
                String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String dateString = scanner.nextLine().trim();
                if (!dateString.matches(regexDate)) {
                    throw new InvalidDateException("Ban da nhap sai dinh dang.");
                }
                birthday = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int age = birthday.until(LocalDate.now()).getYears();
                if (age > minAge && age < maxAge) {
                    System.out.println(birthday + ", tuoi: " + age);
                    return birthday;
                }
                throw new OutOfValuesRange("Bạn đã nhập ngoài phạm vi độ tuổi.\nPhạm vi độ tuổi: " + minAge + " -> " + maxAge);
            } catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng.");
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ban da nhap loi.");
            }
        } while (i < 10);
        return birthday;
    }
}
