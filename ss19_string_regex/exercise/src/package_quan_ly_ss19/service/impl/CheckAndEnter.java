package package_quan_ly_ss19.service.impl;

import package_quan_ly_ss19.model.Person;
import package_quan_ly_ss19.utils.exception.InvalidException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAndEnter {
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
                if (!isValidDate) {
                    throw new InvalidException("Bạn đã nhập ngày sinh chưa hợp lệ.\n" +
                            "Định dạng ngày sinh chúng tôi thiết lập là: dd/mm/yyyy\n" +
                            "Ngoài ra, chú ý giá trị giới hạn của ngày và tháng.");
                }
                break;
            } catch (InvalidException ie) {
                System.out.println(ie.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi. Vui lòng nhập lại.");
            }
            System.out.print("Vui lòng nhập lại ngày sinh: ");
        }
        return inputDate;
    }

    public static int enterIDToAddObject(List<? extends Person> personList) {
        int iD = 0;
        int i = 0;
        while (i < 10) {
            i++;
            try {
                iD = Integer.parseInt(scanner.nextLine());
                for (Person person : personList) {
                    if (iD == person.getID()) {
                        throw new InvalidException("\nBạn đã nhập trùng ID.");
                    }
                }
                if (iD < 0) {
                    throw new InvalidException("\nBạn đã nhập số âm.");
                }
                break;
            } catch (InvalidException ie) {
                System.out.println(ie.getMessage());
            } catch (NumberFormatException n) {
                System.out.println("\nBạn đã nhập kiểu dữ liệu không phải là số.");
            } catch (Exception e) {
                System.out.println("\nThông tin bạn đã nhập bị lỗi.");
            }
            System.out.print("Vui lòng nhập lại ID: ");
        }
        return iD;
    }

    public static Person enterIDToFindUpdateRemove(List<? extends Person> personList) {
        int i;
        int j = 0;
        int iD = 0;
        while (j < 10) {
            j++;
            try {
                iD = Integer.parseInt(scanner.nextLine());
                if (iD < 0) {
                    throw new InvalidException("Bạn đã nhập số âm.");
                }
                break;
            } catch (NumberFormatException n) {
                System.out.println("Bạn đã nhập kiểu dữ liệu không phải là số.");
            } catch (InvalidException p) {
                System.out.println(p.getMessage());
            } catch (Exception e) {
                System.out.println("Thông tin bạn nhập đã bị lỗi");
            }
            System.out.print("Vui lòng nhập lại ID: ");
        }
        for (i = 0; i < personList.size(); i++) {
            if (personList.get(i).getID() == iD) {
                return personList.get(i);
            }
        }
        return null;
    }
}
