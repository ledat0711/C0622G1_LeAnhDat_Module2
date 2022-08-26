package model.person;

public class Customer extends Person {
    private String customerID;
    private String customerType;

    public Customer() {
    }

    public Customer(String customerID, String customerType) {
        this.customerID = customerID;
        this.customerType = customerType;
    }

    public Customer(String name, String address, String dateOfBirth, String gender, String id, long phoneNumber, String email, String customerID, String customerType) {
        super(name, address, dateOfBirth, gender, id, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}

