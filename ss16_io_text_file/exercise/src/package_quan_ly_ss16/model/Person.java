package package_quan_ly_ss16.model;

public abstract class Person {
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(int id, String name,String dateOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender=gender;
    }

    public int getID() {
        return id;
    }

    public void setID(int iD) {
        this.id = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return " Mã số ID:" + id +
                ", tên: '" + name + '\'' +
                ", ngày sinh: '" + dateOfBirth + '\'' +
                ", giới tính: " + gender + '\''
                ;
    }
}
