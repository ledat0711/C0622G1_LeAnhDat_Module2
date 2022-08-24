package package_quan_ly_ss16.service.impl;

import package_quan_ly_ss16.controller.MainController;
import package_quan_ly_ss16.model.Person;
import package_quan_ly_ss16.model.Teacher;
import package_quan_ly_ss16.service.ITeacherService;
import package_quan_ly_ss16.utils.exception.InvalidException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static package_quan_ly_ss16.service.impl.CheckAndEnter.checkAndEnterDate;
import static package_quan_ly_ss16.utils.read_write.WriteFileUtil.writeTeacherFile;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    private static final String SRC_DATA_TEACHERS =  "src\\package_quan_ly_ss16\\data\\teacher_source.csv";
    private static final String DES_LIST_TEACHERS =  "src\\package_quan_ly_ss16\\data\\teacher_source.csv";

    static {
        teachers.add(new Teacher(15, "Truong Le", "06/07/1991","Nam", "Tutor", 30));
        teachers.add(new Teacher(26, "Binh Nguyen", "24/07/1990","Nam", "Instructor", 20));
        teachers.add(new Teacher(78, "An Tran", "27/09/1996","Nữ", "Instructor", 25));
        teachers.add(new Teacher(18, "An Nguyen", "14/06/1993","Nữ", "Tutor", 23));
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.addInfoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void writeNewAndDisplayAllTeacher() throws IOException {
        MainController.numericalOrder = 0;
        writeTeacherFile(DES_LIST_TEACHERS, teachers);
        System.out.println("**** Danh sách giảng viên ****");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() throws IOException {
        System.out.println("Mời bạn nhập vào ID cần xóa");
        Teacher teacher = (Teacher)CheckAndEnter.enterIDToFindUpdateRemove(teachers);
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getID() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Xóa thành công!");
            }
        }
        writeTeacherFile(DES_LIST_TEACHERS, teachers);
    }

    @Override
    public void updateTeacher() throws IOException {
        System.out.println("Mời bạn nhập ID cần cập nhật ");
        Teacher teacherFinded = (Teacher)CheckAndEnter.enterIDToFindUpdateRemove(teachers);
        if (teacherFinded == null) {
            System.out.println("Không tìm thấy đối tượng cần cập nhật");
        } else {
            int i;
            for (i = 0; i < teachers.size(); i++) {
                if (teacherFinded.equals(teachers.get(i))) {
                    teachers.remove(teachers.get(i));
                    teachers.add(i, this.addInfoTeacher());
                    System.out.println("Đã cập nhập.");
                    break;
                }
            }
        }
        writeTeacherFile(DES_LIST_TEACHERS, teachers);
    }

    @Override
    public void findTeacherByID() {
        System.out.println("Mời bạn nhập ID cần tìm: ");
        Teacher teacher = (Teacher)CheckAndEnter.enterIDToFindUpdateRemove(teachers);
        if (teacher == null) {
            System.out.println("Không tìm thấy giảng viên với ID cần tìm");
        } else {
            System.out.println("Thông tin giảng viên mà bạn cần tìm: ");
            System.out.println(teacher.toString());
        }
    }

    @Override
    public void printResultTeacherFoundByName() {
        System.out.println("Mời bạn nhập tên cần tìm: ");
        List<Teacher> foundTeacherList = enterNameToFindTeacher();
        if (foundTeacherList == null) {
            System.out.println("Không tìm thấy giảng viên với tên cần tìm");
        } else {
            System.out.println("Thông tin giảng viên mà bạn cần tìm: ");
            MainController.numericalOrder=0;
            for (Teacher teacher : foundTeacherList) {
                System.out.println(teacher);
            }
        }
    }

    public List<Teacher> enterNameToFindTeacher() {
        String nameInput = scanner.nextLine();
        List<Teacher> foundTeachersList = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(nameInput)) {
                foundTeachersList.add(teacher);
            }
        }
        return foundTeachersList;
    }

    public double inputValidSalary(){
        double salary=0;
        int i=0;
        while (i<10){
            i++;
            try {
                salary = Double.parseDouble(scanner.nextLine());
                if(salary<0){
                    throw new InvalidException("\nBạn đã nhập số âm.");
                }
                break;
            }catch (InvalidException ie){
                System.out.println(ie.getMessage());
            }catch (NumberFormatException n){
                System.out.println("\nBạn đã dữ liệu không phải là số");
            }catch (Exception e){
                System.out.println("\nBạn đã nhập bị lỗi.");
            }
            System.out.print("Vui lòng nhập lại mức lương: ");
        }
        return salary;
    }

    public Teacher addInfoTeacher() {
        System.out.print("Mời bạn nhập ID: ");
        int id = CheckAndEnter.enterIDToAddObject(teachers);
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = checkAndEnterDate();
        System.out.print("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập vị trí công tác: ");
        String position = scanner.nextLine();
        System.out.print("Mời bạn nhập mức lương (đơn vị: triệu VND): ");
        double salary = inputValidSalary();
        return new Teacher(id, name, dateOfBirth,gender, position, salary);
    }

    @Override
    public void sortTeacherByNameAscending() throws IOException {
        teachers.sort(Comparator.comparing(Teacher::getName));
        writeNewAndDisplayAllTeacher();
    }
}