package model;

public class Contract {
    private String contractID;
    private String bookingID;
    private String depositMoney;
    private long totalPayment;
    private String customerID;

    public Contract() {
    }

    public Contract(String contractID, String bookingID, String depositMoney, long totalPayment, String customerID) {
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

    public long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Số hợp đồng: '" + contractID + '\'' +
                ", Mã booking: '" + bookingID + '\'' +
                ", Số tiền cọc trước: '" + depositMoney + '\'' +
                ", Tổng thanh toán" + totalPayment +
                ", Mã khách hàng: '" + customerID + '\''
                ;
    }
}
