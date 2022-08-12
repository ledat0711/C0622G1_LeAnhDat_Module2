package model;

public class Teacher extends Person {
    private double point;
    private String nameClass;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "point=" + point +
                ", nameClass='" + nameClass + '\'' +
                "} " + super.toString();
    }

    public Teacher(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Teacher(int id, String name, String dateOfBirth, double point, String nameClass) {
        super(id, name, dateOfBirth);
        this.point = point;
        this.nameClass = nameClass;
    }
}
