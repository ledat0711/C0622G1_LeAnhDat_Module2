package utils.check_enter;

import utils.exception.InvalidException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAndEnter {
    public static Scanner scanner = new Scanner(System.in);

    public static String checkAndFormatName() {
        String serviceName = checkEnterName();
        String[] arr = serviceName.toLowerCase().trim().split("");
        StringBuilder str = new StringBuilder().append(arr[0].toUpperCase());
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(" ")) {
                if (arr[i - 1].equals(" ")) {
                    str.append(arr[i].toUpperCase());
                } else {
                    str.append(arr[i]);
                }
            } else if (!arr[i + 1].equals(" ")) {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }

    public static String checkEnterName() {
        int i = 0;
        String name = "";
        final String VALID_FORMAT = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ" +
                "a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]" +
                "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*" +
                "(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ" +
                "a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]" +
                "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";
        while (i < 10) {
            i++;
            name = scanner.nextLine();
            if (name.matches(VALID_FORMAT)) {
                break;
            } else {
                System.out.print("Bạn đã nhập tên không hợp lệ. vui lòng nhập lại tên: ");
            }
        }
        return name;
    }

//    public static int enterIDToAddObject(List<? extends Person> personList) {
//        int iD = 0;
//        int i = 0;
//        while (i < 10) {
//            i++;
//            try {
//                iD = Integer.parseInt(scanner.nextLine());
//                for (Person person : personList) {
//                    if (iD == person.getID()) {
//                        throw new InvalidException("\nBạn đã nhập trùng ID.");
//                    }
//                }
//                if (iD < 0) {
//                    throw new InvalidException("\nBạn đã nhập số âm.");
//                }
//                break;
//            } catch (InvalidException ie) {
//                System.out.println(ie.getMessage());
//            } catch (NumberFormatException n) {
//                System.out.println("\nBạn đã nhập kiểu dữ liệu không phải là số.");
//            } catch (Exception e) {
//                System.out.println("\nThông tin bạn đã nhập bị lỗi.");
//            }
//            System.out.print("Vui lòng nhập lại ID: ");
//        }
//        return iD;
//    }
//
//    public static Person enterIDToFindUpdateRemove(List<? extends Person> personList) {
//        int i;
//        int j = 0;
//        int iD = 0;
//        while (j < 10) {
//            j++;
//            try {
//                iD = Integer.parseInt(scanner.nextLine());
//                if (iD < 0) {
//                    throw new InvalidException("Bạn đã nhập số âm.");
//                }
//                break;
//            } catch (NumberFormatException n) {
//                System.out.println("Bạn đã nhập kiểu dữ liệu không phải là số.");
//            } catch (InvalidException p) {
//                System.out.println(p.getMessage());
//            } catch (Exception e) {
//                System.out.println("Thông tin bạn nhập đã bị lỗi");
//            }
//            System.out.print("Vui lòng nhập lại ID: ");
//        }
//        for (i = 0; i < personList.size(); i++) {
//            if (personList.get(i).getID() == iD) {
//                return personList.get(i);
//            }
//        }
//        return null;
//    }
}
