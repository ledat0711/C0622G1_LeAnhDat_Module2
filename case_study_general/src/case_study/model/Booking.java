package case_study.model;

import case_study.service.IBookingService;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerID;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingID,
                   LocalDate startDate,
                   LocalDate endDate,
                   String customerID,
                   String serviceName,
                   String serviceType) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    //    @Override
//    public String toString() {
//        return "Mã booking: '" + bookingID + '\'' +
//                ", Ngày bắt đầu: '" + startDate + '\'' +
//                ", Ngày kết thúc: '" + endDate + '\'' +
//                ", Mã khách hàng: '" + customerID + '\'' +
//                ", Tên dịch vụ: '" + serviceName + '\'' +
//                ", Loại dịch vụ:  '" + serviceType + '\''
//                ;
//    }
    @Override
    public String toString() {
        return bookingID + "," +
                startDate + "," +
                endDate + "," +
                customerID + "," +
                serviceName + "," +
                serviceType;
    }
}
