package package_quan_ly_ss19.model;

import package_quan_ly_ss19.controller.MainController;

import java.util.Locale;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }

    public Student(String name) {
        super(name);
    }

    public Student(int id, String name, String dateOfBirth, String gender, double point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
//
//    @Override
//    public String toString() {
//        ++MainController.numericalOrder;
//        return String.format(Locale.ROOT,"STT: %-5d,ID: %-6d, Tên: %-15s, Ngày sinh: %-10s, Giới tính: %-9s, Lớp: %-7s, Điểm: %-5.2f",
//                MainController.numericalOrder, this.getID(), this.getName(), this.getDateOfBirth(), this.getGender(), this.getNameClass(), this.getPoint());
//    }
    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return String.format(Locale.ROOT,"ID: %-6d, Tên: %-15s, Ngày sinh: %-10s, Giới tính: %-9s, Lớp: %-7s, Điểm: %-5.2f",
                this.getID(), this.getName(), this.getDateOfBirth(), this.getGender(), this.getNameClass(), this.getPoint());
    }
}