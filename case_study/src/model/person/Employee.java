package model.person;

public class Employee extends Person {
    private String employeeID;
    private String jobPosition;
    private String academicLevel;
    private long salary;

    public Employee() {
    }

    public Employee(String employeeID, String jobPosition, String academicLevel, long salary) {
        this.employeeID = employeeID;
        this.jobPosition = jobPosition;
        this.academicLevel = academicLevel;
        this.salary = salary;
    }

    public Employee(String name, String address, String dateOfBirth, String gender, String id, long phoneNumber, String email, String employeeID, String jobPosition, String academicLevel, long salary) {
        super(name, address, dateOfBirth, gender, id, phoneNumber, email);
        this.employeeID = employeeID;
        this.jobPosition = jobPosition;
        this.academicLevel = academicLevel;
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
                ", Vị trí công việc: '" + jobPosition + '\'' +
                ", Trình độ học vấn: '" + academicLevel + '\'' +
                ", Mức lương: " + salary
                ;
    }
}
