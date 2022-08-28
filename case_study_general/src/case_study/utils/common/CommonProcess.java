package case_study.utils.common;

import case_study.model.person.*;
import case_study.model.person.Person;
import case_study.utils.exception.WrongInformationException;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class CommonProcess {
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
//        String iD;
//        while (j < 10) {
//            j++;
//            iD = scanner.nextLine();
//            for (i = 0; i < personList.size(); i++) {
//                if (personList.get(i).getID().equals(iD)) {
//                    return personList.get(i);
//                }
//            }
//        }
//        return null;
//    }

    public static Object checkIDReturnObject(List<?> objectList, String stringInside) {
        String id = null;
        int i = 0;
        while (i < 10) {
            i++;
            try {
                System.out.printf("Mời bạn nhập ID của %s cần cập nhật: ", stringInside);
                id = scanner.nextLine();
                if (id.isEmpty()) {
                    throw new WrongInformationException("Bạn chưa nhập thông tin.\nHãy nhập lại.");
                }
                break;
            } catch (WrongInformationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Đã nhập thông tin bị lỗi.\nHãy nhập lại.");
            }
        }
        if (stringInside.equals("nhân viên")) {
            List<Employee> employeeList = (List<Employee>) objectList;
            for (i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeID().equals(id)) {
                    return objectList.get(i);
                }
            }
        } else {
            List<Customer> customerList = (List<Customer>) objectList;
            for (i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getCustomerID().equals(id)) {
                    return objectList.get(i);
                }
            }
        }
        return null;
    }

    public static String enterGenderCommonProcess() {
        String[] genderArray = {"", "Nam", "Nữ", "Khác"};
        String selection = "";
        while (true) {
            System.out.println("Để nhập giới tính. Điền từ số 1 đến số 3: ");
            System.out.printf("%s-%s\n%s-%s\n%s-%s", 1, "Nam", 2, "Nữ", 3, "Khác");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    return genderArray[1];
                case "2":
                    return genderArray[2];
                case "3":
                    return genderArray[3];
                default:
                    System.out.println("Bạn đã nhập bị lỗi. Vui lòng nhập lại các số từ 1 đến 3.");
            }
        }
    }
}
