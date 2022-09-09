package a_thi_module_2.service.impl;

import a_thi_module_2.common.EnterPeopleInfo;
import a_thi_module_2.model.Employee;
import a_thi_module_2.model.Student;
import a_thi_module_2.service.IStudentService;
import a_thi_module_2.utils.exception.EmptyInformationException;
import a_thi_module_2.utils.exception.InvalidDateException;
import a_thi_module_2.utils.exception.OutOfValuesRange;
import a_thi_module_2.utils.read_write_data.ReadAndWriteFile;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements IStudentService {
    private static final String LINK_STUDENT_FILE = "src\\a_thi_module_2\\data\\student_file.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void display() {
        int i;
        List<Student> employeeList = ReadAndWriteFile.readStudentFromFile(LINK_STUDENT_FILE);
        System.out.println("--------------Danh sách nhân viên--------------");
        if(employeeList.size() == 0){
            System.out.println("Danh sách nhân viên đang trống.");
        }
        for (i = 0; i < employeeList.size(); i++) {
            System.out.println("STT " + (i + 1) + ": " + employeeList.get(i));
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public void add() {
        System.out.println("-------------------------------------------" +
                "\nBạn đang sử dụng chức năng thêm thông tin học viên. ");
        List<Student> studentList = ReadAndWriteFile.readStudentFromFile(LINK_STUDENT_FILE);
        Student  studentAdding = this.addInfoStudent();
        studentList.add(studentAdding);
        ReadAndWriteFile.writeStudentToFile(LINK_STUDENT_FILE, studentList, false);
        System.out.println("Thêm mới thành công!");
        System.out.println("Đã thêm thông tin sau vào danh sách:");
        System.out.println(studentAdding.toString());
    }

    public Student addInfoStudent() {
        String personalID = EnterPeopleInfo.enterPersonalID();
        String name = EnterPeopleInfo.formatAndEnterPeopleName();
        LocalDate dateOfBirth = EnterPeopleInfo.enterBirthDate(18, 100);
        String address = SCANNER.nextLine().replace("," , "-");
        String phoneNumber = EnterPeopleInfo.enterPhoneNumber();
        System.out.println("Mời bạn nhập điểm");
        double point = Double.parseDouble(SCANNER.nextLine().trim());
        System.out.println("Mời bạn nhập tên lớp:");
        String className = SCANNER.nextLine().trim();
            LocalDate startDate = enterDate();
        return new Student(personalID,name, dateOfBirth,address,
                phoneNumber,point, className,startDate);
    }

    public static LocalDate enterDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDay;
        int age;
        String dateString;
        do {
            System.out.println("Mời bạn nhập ngày nhập học (dd/MM/yyyy): ");
            try {
                String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                dateString = scanner.nextLine().trim();
                if (dateString.isEmpty()) {
                    throw new EmptyInformationException("\nBạn chưa nhập thông tin ngày nhập học.");
                }
                if (!dateString.matches(regexDate)) {
                    throw new InvalidDateException("\nBạn đã nhập sai định dạng.");
                }
                birthDay = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                age = birthDay.until(LocalDate.now()).getYears();
                throw new OutOfValuesRange("\nBạn đã nhập ngoài phạm vi");
            } catch (DateTimeParseException e) {
                System.out.println("\nNhập sai định dạng.");
            } catch (InvalidDateException | OutOfValuesRange e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập lỗi.");
            }
            System.out.println("Vui lòng nhập lại.");
        } while (true);
    }
}
