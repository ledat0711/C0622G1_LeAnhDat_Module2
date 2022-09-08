package case_study.model.person;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person {
    private String employeeID;
    private String academicLevel;
    private String jobPosition;
    private double salary;

    public Employee() {
    }

    public Employee(String name,
                    LocalDate dateOfBirth,
                    String gender,
                    String personalID,
                    String phoneNumber,
                    String email,
                    String employeeID,
                    String academicLevel,
                    String jobPosition,
                    double salary) {
        super(name, dateOfBirth, gender, personalID, phoneNumber, email);
        this.employeeID = employeeID;
        this.academicLevel = academicLevel;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",getName(),getDateOfBirth(),getGender(),getPersonalID(),getPhoneNumber(),getEmail(),getEmployeeID(),getAcademicLevel(),getJobPosition(),getSalary());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",getName(),getDateOfBirth(),getGender(),getPersonalID(),getPhoneNumber(),getEmail(),getEmployeeID(),getAcademicLevel(),getJobPosition(),getSalary());
    }
}

