package case_study.model;

public class Contract {
    private String numberContract;
    private String bookingId;
    private int depositMoney;
    private int sumMoney;
    private String customerId;

    public Contract() {
    }

    public Contract(String numberContract, String bookingId, int depositMoney, int sumMoney, String customerId) {
        this.numberContract = numberContract;
        this.bookingId = bookingId;
        this.depositMoney = depositMoney;
        this.sumMoney = sumMoney;
        this.customerId = customerId;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s\n",
                this.getNumberContract(),
                this.getBookingId(),
                this.getDepositMoney(),
                this.getSumMoney(),
                this.getCustomerId());
    }

    @Override
    public String toString() {
        return "HỢP ĐỒNG - " +
                "Số hợp đồng: " + getNumberContract() +
                ", Mã booking: " + getBookingId() +
                ", Số tiền cọc trước (VNĐ): " + getDepositMoney() +
                ", Tổng số tiền thanh toán (VNĐ): " + getSumMoney() +
                ", Mã khách hàng: " + getCustomerId();
    }
}
