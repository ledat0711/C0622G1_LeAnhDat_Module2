package model;

import controller.MainController;

public class Teacher extends Person {
    private String position;
    private double salary;

    public Teacher() {
    }

    @Override
    public String toString() {
        ++MainController.numericalOrder;
        return "Teacher"+ MainController.numericalOrder+"{" + super.toString()+
                ", position= '" + position + '\'' +
                ", salary= " + salary + " million VND "+
                '}';
    }

    public Teacher(int id, String name, String dateOfBirth, String position, double salary) {
        super(id, name, dateOfBirth);
        this.position = position;
        this.salary= salary;
    }
}
