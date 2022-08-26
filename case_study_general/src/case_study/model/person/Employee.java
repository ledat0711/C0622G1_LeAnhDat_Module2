package model.person;

public class Employee extends Person {
    private String employeeID;
    private String academicLevel;
    private String jobPosition;
    private long salary;

    public Employee() {
    }

    public Employee(String name,
                    String dateOfBirth,
                    String gender,
                    String id,
                    String phoneNumber,
                    String email,
                    String employeeID,
                    String academicLevel,
                    String jobPosition,
                    long salary) {
        super(name, dateOfBirth, gender, id, phoneNumber, email);
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Mã nhân viên: '" + employeeID + '\'' +
                super.toString() + "," +
                ", Trình độ: '" + academicLevel + '\'' +
                ", Vị trí: '" + jobPosition + '\'' +
                ", Mức lương: " + salary
                ;
    }
}
