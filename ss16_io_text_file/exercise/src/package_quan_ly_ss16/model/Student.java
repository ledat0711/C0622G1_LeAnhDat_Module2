package package_quan_ly_ss16.model;

import package_quan_ly_ss16.controller.MainController;

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
//    @Override
//    public String toString() {
//        ++MainController.numericalOrder;
//        return "Học viên  " + MainController.numericalOrder + " {" + super.toString() +
//                ", điểm: " + point +
//                ", lớp:  '" + nameClass + '\'' +
//                "} ";
//    }


    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return String.format("|%-5d|%-6d|%-15s|%-10s|%-9s|%-7s|%-5.2f|",
                MainController.numericalOrder, this.getID(), this.getName(), this.getDateOfBirth(),
                this.getGender(), this.getNameClass(), this.getPoint());
    }

    public String toString2() {
        return String.format("|%-6d|%-15s|%-10s|%-9s|%-7s|%-5.2f|",this.getID(), this.getName(), this.getDateOfBirth(),
                this.getGender(), this.getNameClass(), this.getPoint());
    }
}