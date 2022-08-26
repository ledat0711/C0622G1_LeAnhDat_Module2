package package_quan_ly_ss19.service.impl;

import package_quan_ly_ss19.controller.MainController;
import package_quan_ly_ss19.model.Student;
import package_quan_ly_ss19.service.IStudentService;
import package_quan_ly_ss19.utils.exception.InvalidException;
import package_quan_ly_ss19.utils.read_write.WriteFileUtil;

import java.io.IOException;
import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static final String SRC_DATA_STUDENTS = "src\\package_quan_ly_ss19\\data\\students_source.csv";
    private static final String DES_LIST_STUDENTS = "src\\package_quan_ly_ss19\\data\\students_destionation.csv";

    static {
        students.add(new Student(455, "An Nguyen", "12/12/1998", "Nam", 4, "C06"));
        students.add(new Student(881, "Ngoc Tran", "06/07/1995", "Nữ", 14, "C07"));
        students.add(new Student(684, "Minh Le", "25/08/2999", "Nam", 17, "C08"));
        students.add(new Student(334, "Tuan Phan", "11/09/2000", "Nam", 21, "C09"));
        students.add(new Student(571, "Duong Hoang", "19/09/1996", "Nữ", 26, "C04"));
        students.add(new Student(656, "Ngoc Le", "18/04/1990", "Nữ", 26, "C04"));
    }

    @Override
    public void addStudent() throws IOException {
        Student student = this.addInfoStudent();
        students.add(student);
        WriteFileUtil.writeStudentFile(DES_LIST_STUDENTS, students);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void writeNewAndDisplayAllStudent() throws IOException {
        MainController.numericalOrder = 0;
        WriteFileUtil.writeStudentFile(DES_LIST_STUDENTS, students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() throws IOException {
        System.out.print("Mời bạn nhập vào ID cần xóa: ");
        Student student = (Student) CheckAndEnter.enterIDToFindUpdateRemove(students);
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có ID là " + student.getID() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa thành công!");
                WriteFileUtil.writeStudentFile(SRC_DATA_STUDENTS, students);
            } else {
                System.out.println("Bạn chưa thực hiện xóa thông tin.");
            }
        }
    }

    @Override
    public void updateStudent() {
        System.out.println("Mời bạn nhập ID cần cập nhật ");
        Student studentFinded = (Student) CheckAndEnter.enterIDToFindUpdateRemove(students);
        if (studentFinded == null) {
            System.out.println("Không tìm thấy đối tượng cần cập nhật");
        } else {
            int i;
            for (i = 0; i < students.size(); i++) {
                if (studentFinded.equals(students.get(i))) {
                    students.remove(students.get(i));
                    students.add(i, this.addInfoStudent());
                    System.out.println("Đã cập nhập.");
                    break;
                }
            }
        }
    }

    @Override
    public void findStudentByID() {
        System.out.println("Mời bạn nhập ID cần tìm: ");
        Student student = (Student) CheckAndEnter.enterIDToFindUpdateRemove(students);
        if (student == null) {
            System.out.println("Không tìm thấy học viên với ID cần tìm");
        } else {
            System.out.println("Thông tin học viên mà bạn cần tìm: ");
            MainController.numericalOrder = 0;
            System.out.println(student);
        }
    }


    @Override
    public void findStudentByName() {
        System.out.println("Mời bạn nhập tên cần tìm: ");
        List<Object> foundStudentList = this.findNameSimple();
        if (foundStudentList.isEmpty()) {
            System.out.println("Không tìm thấy học viên với tên cần tìm");
        } else {
            System.out.println("Thông tin mà bạn cần tìm: ");
            MainController.numericalOrder = 0;
            for (Object student : foundStudentList) {
                System.out.println(student);
            }
        }
    }

    public List<Object> findNameSimple() {
        String nameInput = scanner.nextLine();
        List<Object> foundStudentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(nameInput)) {
                foundStudentList.add(student);
            }
        }
        return foundStudentList;
    }

    public double inputValidPoint() {
        double point = 0;
        int i = 0;
        while (i < 10) {
            i++;
            try {
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 30) {
                    throw new InvalidException("\nBạn đã nhập điểm vượt quá phạm vi." +
                            "\n(Trong khoảng 0-30 điểm)");
                }
                break;
            } catch (InvalidException ie) {
                System.out.println(ie.getMessage());
            } catch (NumberFormatException n) {
                System.out.println("\nBạn đã dữ liệu không phải là số");
            } catch (Exception e) {
                System.out.println("\nBạn đã nhập bị lỗi.");
            }
            System.out.print("Vui lòng nhập lại điểm: ");
        }
        return point;
    }

    public Student addInfoStudent() {
        System.out.print("Mời bạn nhập ID (ID hợp lệ là một dãy 5 chữ số): ");
        int iD = CheckAndEnter.enterIDToAddObject(students);
        System.out.print("Mời bạn nhập tên: ");
        String name = CheckAndEnter.checkAndFormatName();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = CheckAndEnter.checkAndEnterDate();
        System.out.print("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = inputValidPoint();
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        return new Student(iD, name, dateOfBirth, gender, point, nameClass);
    }

    @Override
    public void sortStudentByNameUseLambda1() throws IOException {
        students.sort(Comparator.comparing(Student::getName));
        writeNewAndDisplayAllStudent();
    }

    @Override
    public void sortStudentByNameUseLambda2() throws IOException {
        students.sort((a, b) -> b.getName().compareTo(a.getName()));
        writeNewAndDisplayAllStudent();
    }

    @Override
    public void sortStudentByPointUseLambda1() throws IOException {
        students.sort(Comparator.comparingDouble(Student::getPoint));
        writeNewAndDisplayAllStudent();
    }

    @Override
    public void sortStudentByPointUseLambda2() throws IOException {
        students.sort((p1, p2) -> Double.compare(p2.getPoint(), p1.getPoint()));
        writeNewAndDisplayAllStudent();
    }
}