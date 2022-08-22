package package_quan_ly_ss16.model;

import package_quan_ly_ss16.controller.MainController;

public class Teacher extends Person {
    private String position;
    private double salary;

    public Teacher() {
    }

    public Teacher(int id, String name, String dateOfBirth,String gender, String position, double salary) {
        super(id, name, dateOfBirth,gender);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return "Giảng viên: " + MainController.numericalOrder + " {" + super.toString() +
                ", vị trí: '" + position + '\'' +
                ", mức lương:  " + salary + " triệu VND " +
                '}';
    }

    public String toString2() {
        return "Giảng viên { " + super.toString() +
                ", vị trí: '" + position + '\'' +
                ", mức lương: " + salary + " triệu VND " +
                '}';
    }

}
