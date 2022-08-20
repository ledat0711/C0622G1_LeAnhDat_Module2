package package_quan_ly_ss15.service.impl;

import package_quan_ly_ss15.controller.MainController;
import package_quan_ly_ss15.model.Student;
import package_quan_ly_ss15.service.IStudentService;
import package_quan_ly_ss15.utils.exception.InvalidException;

import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(455, "An Nguyen", "12/12/1998", 4, "C06"));
        students.add(new Student(881, "Ngoc Tran", "06/07/1995", 14, "C07"));
        students.add(new Student(684, "Minh Le", "25/08/2999", 17, "C08"));
        students.add(new Student(334, "Tuan Phan", "11/09/2000", 21, "c09"));
        students.add(new Student(571, "Duong Hoang", "19/09/1996", 26, "c004"));
        students.add(new Student(656, "Ngoc Le", "18/04/1990", 26, "c004"));
    }

    @Override
    public void addStudent() {
        Student student = this.addInfoStudent();
        students.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void displayAllStudent() {
        MainController.numericalOrder = 0;
        System.out.println("****Danh sách học viên****");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        System.out.print("Mời bạn nhập vào ID cần xóa: ");
        Student student = this.findIDSimple();
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
            }
        }
    }

    @Override
    public void updateStudent() {
        System.out.println("Mời bạn nhập ID cần cập nhật ");
        Student studentFinded = this.findIDSimple();
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
        Student student = this.findIDSimple();
        if (student == null) {
            System.out.println("Không tìm thấy học viên với ID cần tìm");
        } else {
            System.out.println("Thông tin học viên mà bạn cần tìm: ");
            System.out.println(student.toString2());
        }
    }

    public Student findIDSimple() {
        int i;
        int j = 0;
        int iD = 0;
        do {
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
            System.out.println("Vui lòng nhập lại thông tin");
        } while (j < 10);
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == iD) {
                return students.get(i);
            }
        }
        return null;
    }

    @Override
    public void findStudentByName() {
        System.out.println("Mời bạn nhập tên cần tìm: ");
        List<Object> foundStudentList = this.findNameSimple();
        if (foundStudentList.isEmpty()) {
            System.out.println("Không tìm thấy học viên với tên cần tìm");
        } else {
            System.out.println("Thông tin mà bạn cần tìm: ");
            MainController.numericalOrder=0;
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

    public int inputValidID() {
        int iD = 0;
        int i = 0;
        while (i < 10) {
            i++;
            try {
                iD = Integer.parseInt(scanner.nextLine());
                for (Student student : students) {
                    if (iD == student.getID()) {
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
    public double inputValidPoint(){
        double point=0;
        int i=0;
        while (i<10){
            i++;
            try {
                point = Double.parseDouble(scanner.nextLine());
                if(point<0 || point >30){
                    throw new InvalidException("\nBạn đã nhập điểm vượt quá phạm vi." +
                            "\n(Trong khoảng 0-30 điểm)");
                }
                break;
            }catch (InvalidException ie){
                System.out.println(ie.getMessage());
            }catch (NumberFormatException n){
                System.out.println("\nBạn đã dữ liệu không phải là số");
            }catch (Exception e){
                System.out.println("\nBạn đã nhập bị lỗi.");
            }
            System.out.print("Vui lòng nhập lại điểm: ");
        }
        return point;
    }
    public Student addInfoStudent() {
        System.out.print("Mời bạn nhập ID: ");
        int iD = inputValidID();
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = inputValidPoint();
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        return new Student(iD, name, dateOfBirth, point, nameClass);
    }

    @Override
    public void sortStudentByName() {
        for (int i = 1; i < students.size(); i++) {
            Student tempVariable = students.get(i);
            int j;
            for (j = i - 1; j >= 0 && tempVariable.getName().compareTo(students.get(j).getName()) < 0; j--) {
                students.set(j + 1, students.get(j));
            }
            students.set(j + 1, tempVariable);
        }
        this.displayAllStudent();
    }
}