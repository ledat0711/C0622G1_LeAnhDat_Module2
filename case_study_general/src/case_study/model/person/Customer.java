package case_study.model.person;

import java.time.LocalDate;
import java.util.Objects;

public class Customer extends Person {
    private String customerID;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String customerID, String customerType, String address) {
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String name,
                    LocalDate dateOfBirth,
                    String gender,
                    String personalID,
                    String phoneNumber,
                    String email,
                    String customerID,
                    String customerType,
                    String address) {
        super(name, dateOfBirth, gender, personalID, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getName(),getDateOfBirth(),getGender(),getPersonalID(),getPhoneNumber(),getEmail(),getCustomerID(),getCustomerType(),getAddress());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getName(),getDateOfBirth(),getGender(),getPersonalID(),getPhoneNumber(),getEmail(),getCustomerID(),getCustomerType(),getAddress());
    }
}

