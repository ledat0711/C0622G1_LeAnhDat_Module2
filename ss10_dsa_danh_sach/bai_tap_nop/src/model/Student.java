package model;

import controller.MainController;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
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

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student(int id, String name, String dateOfBirth, double point, String nameClass) {
        super(id, name, dateOfBirth);
        this.point = point;
        this.nameClass = nameClass;
    }
}
