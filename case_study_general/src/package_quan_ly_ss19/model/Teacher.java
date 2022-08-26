package package_quan_ly_ss19.model;

import package_quan_ly_ss19.controller.MainController;

import java.util.Locale;

public class Teacher extends Person {
    private String position;
    private double salary;

    public Teacher() {
    }

    public Teacher(int id, String name, String dateOfBirth, String gender, String position, double salary) {
        super(id, name, dateOfBirth, gender);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return String.format(Locale.ROOT, "ID: %-6d, Tên: %-15s, Ngày sinh: %-10s, Giới tính: %-9s, Vị trí: %-7s, Mức lương: %-5s triệu.",
                this.getID(), this.getName(), this.getDateOfBirth(), this.getGender(), this.getPosition(), this.getSalary());
    }
}
