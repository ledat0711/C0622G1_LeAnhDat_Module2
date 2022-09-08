package case_study.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
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


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", getBookingID(), getStartDate(), getEndDate(), getCustomerID(), getServiceName(), getServiceType());
    }

    @Override
    public int compareTo(Booking o) {
        if (!this.startDate.equals(o.startDate)) {
            return startDate.compareTo(o.startDate);
        } else if (!this.endDate.equals(o.endDate)) {
            return endDate.compareTo(o.endDate);
        } else {
            return this.bookingID.compareTo(o.bookingID);
        }
    }

}
