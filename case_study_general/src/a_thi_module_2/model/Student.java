package a_thi_module_2.model;

import java.time.LocalDate;

public class Student extends Person {
    private double point;
    private String className;
   private LocalDate startDate;

    public Student() {
    }

    public Student(String personalID,
                   String name,
                   LocalDate dateOfBirth,
                   String address,
                   String phoneNumber,
                   double point,
                   String className,
                   LocalDate startDate) {
        super(personalID, name, dateOfBirth, address, phoneNumber);
        this.point = point;
        this.className = className;
        this.startDate = startDate;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getPersonalID(),getName(),getDateOfBirth(),getAddress(),getPhoneNumber(),getPoint(),getClassName(),getStartDate());
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getPersonalID(),getName(),getDateOfBirth(),getAddress(),getPhoneNumber(),getPoint(),getClassName(),getStartDate());
    }
}
