package case_study.model.person;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String personalID;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name,
                  LocalDate dateOfBirth,
                  String gender,
                  String personalID,
                  String phoneNumber,
                  String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.personalID = personalID;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(personalID, person.personalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personalID);
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",getName(),getDateOfBirth(),getGender(),getPersonalID(),getPhoneNumber(),getEmail());
    }
}