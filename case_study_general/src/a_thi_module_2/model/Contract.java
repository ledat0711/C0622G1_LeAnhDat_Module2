package a_thi_module_2.model;

public class Contract {
    private String contractID;
    private String bookingID;
    private String depositMoney;
    private double totalPayment;
    private String customerID;

    public Contract() {
    }

    public Contract(String contractID,
                    String bookingID,
                    String depositMoney,
                    double totalPayment,
                    String customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.depositMoney = depositMoney;
        this.totalPayment = totalPayment;
        this.customerID = customerID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(String depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

//    @Override
//    public String toString() {
//        return "Số hợp đồng: '" + contractID + '\'' +
//                ", Mã booking: '" + bookingID + '\'' +
//                ", Số tiền cọc trước: '" + depositMoney + '\'' +
//                ", Tổng thanh toán" + totalPayment +
//                ", Mã khách hàng: '" + customerID + '\''
//                ;
//    }

    @Override
    public String toString() {
        return contractID + "," +
                bookingID + "," +
                depositMoney + "," +
                totalPayment + "," +
                customerID;
    }
}
