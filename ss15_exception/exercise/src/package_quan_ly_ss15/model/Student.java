package package_quan_ly_ss15.model;

import package_quan_ly_ss15.controller.MainController;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }

    public Student(String name) {
        super(name);
    }

    public Student(int id, String name, String dateOfBirth, double point, String nameClass) {
        super(id, name, dateOfBirth);
        this.point = point;
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return "Student " + MainController.numericalOrder + "{" + super.toString() +
                ", point=" + point +
                ", nameClass= '" + nameClass + '\''
                +
                "} ";
    }

    public String toString2() {
        return "Student {" + super.toString() +
                ", point=" + point +
                ", nameClass= '" + nameClass + '\''
                +
                "} ";
    }
}