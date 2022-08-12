package model;

import service.impl.MemberService;

public class Teacher extends Person {
    private String position;
    private double salary;

    public Teacher() {
    }

    @Override
    public String toString() {
        ++MemberService.numericalOrder;
        return "Teacher"+MemberService.numericalOrder+"{" + super.toString()+
                ", position= '" + position + '\'' +
                ", salary= " + salary + " million VND "+
                '}';
    }

    public Teacher(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }

    public Teacher(int id, String name, String dateOfBirth, String position, double salary) {
        super(id, name, dateOfBirth);
        this.position = position;
        this.salary= salary;
    }
}
