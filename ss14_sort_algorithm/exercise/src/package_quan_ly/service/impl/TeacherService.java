package package_quan_ly.service.impl;

import package_quan_ly.controller.MainController;
import package_quan_ly.model.Teacher;
import package_quan_ly.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(15, "Anh H", "06/07/1991", "Tutor", 30));
        teachers.add(new Teacher(26, "Anh C", "24/07/1990", "Instructor", 20));
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.addInfoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void displayAllTeacher() {
        MainController.numericalOrder = 0;
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.println("Mời bạn nhập vào ID cần xóa");
        Teacher teacher = this.findIDTeacherSimple();
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
    }

    @Override
    public void updateTeacher() {
        System.out.println("Mời bạn nhập ID cần cập nhật ");
        Teacher teacherFinded = this.findIDTeacherSimple();
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
    }

    @Override
    public void findTeacherByID() {
        System.out.println("Mời bạn nhập ID cần tìm: ");
        Teacher teacher = this.findIDTeacherSimple();
        if (teacher == null) {
            System.out.println("Không tìm thấy học viên với ID cần tìm");
        } else {
            System.out.println("Thông tin học viên mà bạn cần tìm: ");
            System.out.println(teacher.toString2());
        }
    }

    public Teacher findIDTeacherSimple() {
        int iD = Integer.parseInt(scanner.nextLine());
        int i;
        for (i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == iD) {
                return teachers.get(i);
            }
        }
        return null;
    }

    @Override
    public void findTeacherByName() {
        System.out.println("Mời bạn nhập tên cần tìm: ");
        Teacher teacher = this.findNameSimple();
        if (teacher == null) {
            System.out.println("Không tìm thấy học viên với tên cần tìm");
        } else {
            System.out.println("Thông tin học viên mà bạn cần tìm: ");
            System.out.println(teacher.toString2());
        }
    }

    public Teacher findNameSimple() {
        String nameInput = scanner.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(nameInput)) {
                return teacher;
            }
        }
        return null;
    }

    public int inputPositiveID() {
        int iD;
        boolean isInvalidID;
        do {
            isInvalidID = true;
            iD = Integer.parseInt(scanner.nextLine());
            for (Teacher teacher : teachers) {
                if (iD == teacher.getID()) {
                    isInvalidID = false;
                    System.out.print("Bạn đã nhập trùng ID.\nVui lòng nhập lại ID: ");
                    break;
                }
            }
        } while (!isInvalidID);
        return iD;
    }

    public Teacher addInfoTeacher() {
        System.out.print("Mời bạn nhập ID: ");
        int id = this.inputPositiveID();
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập vị trí công tác: ");
        String position = scanner.nextLine();
        System.out.print("Mời bạn nhập mức lương (đơn vị: triệu VND): ");
        double salary = Double.parseDouble(scanner.nextLine());
        return new Teacher(id, name, dateOfBirth, position, salary);
    }
}