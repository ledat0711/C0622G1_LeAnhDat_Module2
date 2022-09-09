package a_thi_module_2.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private String personalID;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;

    public Person() {
    }

    public Person(String personalID,
                  String name,
                  LocalDate dateOfBirth,
                  String address,
                  String phoneNumber) {
        this.personalID = personalID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",getPersonalID(),getName(),getDateOfBirth(),getAddress(),getPhoneNumber());
    }

    public abstract String getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person2 = (Person) o;
        return Objects.equals(personalID, person2.personalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalID);
    }
}
