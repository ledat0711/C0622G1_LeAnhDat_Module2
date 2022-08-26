package model.person;

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

    public Customer(String name, String dateOfBirth, String gender, String id, long phoneNumber, String email, String customerID, String customerType, String address) {
        super(name, dateOfBirth, gender, id, phoneNumber, email);
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

    @Override
    public String toString() {
        return "Mã khách hàng: '" + customerID + '\'' +
                ", Loại khách: '" + customerType + '\'' +
                ", Địa chỉ: '" + address + '\'';
    }
}

