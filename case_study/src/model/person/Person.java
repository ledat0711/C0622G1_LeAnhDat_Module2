package model.person;

public abstract class Person {
    private String name;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String id;
    private long phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String address, String dateOfBirth, String gender, String id, long phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tên: '" + name + '\'' +
                ", Địa chỉ: '" + address + '\'' +
                ", Ngày sinh: '" + dateOfBirth + '\'' +
                ", Giới tính: '" + gender + '\'' +
                ", Số CMND/CCCD: '" + id + '\'' +
                ", Số điện thoại: " + phoneNumber +
                ", Email: '" + email + '\''
                ;
    }
}