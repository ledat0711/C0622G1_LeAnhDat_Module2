package model;

public class Teacher extends Person {
    private String position;
    private double salary;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "position= '" + position + '\'' +
                ", salary= " + salary + " million VND, "+
                super.toString()+
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
