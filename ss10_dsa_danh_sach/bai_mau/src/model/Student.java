package model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "point=" + point +
                ", nameClass='" + nameClass + '\'' +
                "} " + super.toString();
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
