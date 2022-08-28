package case_study.model.person;

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
                    String dateOfBirth,
                    String gender,
                    String id,
                    String phoneNumber,
                    String email,
                    String customerID,
                    String customerType,
                    String address) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Mã khách hàng: '" + customerID + '\'' +
                super.toString() + "," +
                ", Loại khách: '" + customerType + '\'' +
                ", Địa chỉ: '" + address + '\'';
    }
}

