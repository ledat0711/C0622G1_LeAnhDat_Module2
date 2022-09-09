package a_thi_module_2.model;

import java.time.LocalDate;

public class Employee extends Person{
    private Double salary;
    private String department;
    private String position;

    public Employee() {
    }

    public Employee(String personalID,
                    String name,
                    LocalDate dateOfBirth,
                    String address,
                    String phoneNumber,
                    Double salary,
                    String department,
                    String position) {
        super(personalID, name, dateOfBirth, address, phoneNumber);
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getPersonalID(),getName(),getDateOfBirth(),getAddress(),getPhoneNumber(),getSalary(),getDepartment(),getPosition());
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getPersonalID(),getName(),getDateOfBirth(),getAddress(),getPhoneNumber(),getSalary(),getDepartment(),getPosition());

    }

}
