package service.impl;

import controller.MainController;
import model.Teacher;
import service.ITeacherService;

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
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getId() + " không?");
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
        Teacher teacherFind = this.findTeacher();
        if (teacherFind == null) {
            System.out.println("Không tìm thấy đối tượng cần cập nhật");
        } else {
            int i;
            for (i = 0; i < teachers.size(); i++) {
                if (teacherFind == teachers.get(i)) {
                    teachers.remove(teachers.get(i));
                    teachers.add(i, this.addInfoTeacher());
                    System.out.println("Đã cập nhập.");
                    break;
                }
            }
        }
    }

    public Teacher findTeacher() {
        int id = Integer.parseInt(scanner.nextLine());
        int i;
        for (i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }

    public Teacher addInfoTeacher() {
        System.out.print("Mời bạn nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập vị trí công tác: ");
        String position = scanner.nextLine();
        System.out.print("Mời bạn nhập mức lương (đơn vị: triệu VND): ");
        double salary = Double.parseDouble(scanner.nextLine());
        Teacher teacher = new Teacher(id, name, dateOfBirth, position, salary);
        return teacher;
    }
}
