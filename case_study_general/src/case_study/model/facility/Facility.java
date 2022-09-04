package case_study.model.facility;

public abstract class Facility {
    private String serviceID;
    private String serviceName;
    private double area;
    private double rentalPrice;
    private int maxPeople;
    private String typeOfRental;

    public Facility() {
    }

    public Facility(String serviceID,
                    String serviceName,
                    double area,
                    double rentalPrice,
                    int maxPeople,
                    String typeOfRental) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalPrice = rentalPrice;
        this.maxPeople = maxPeople;
        this.typeOfRental = typeOfRental;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    public String displayInfoToUser() {
        return ", Mã dịch vụ: '" + serviceID + '\'' +
                ", Tên:'" + serviceName + '\'' +
                ", Diện tích:" + area +
                ", Chi phí thuê: " + rentalPrice +
                ", Số lượng người tối đa: " + maxPeople +
                ", Kiểu cho thuê: '" + typeOfRental + '\'';
    }

    public String toString() {
        return serviceID + "," +
                serviceName + "," +
                area + "," +
                rentalPrice + "," +
                maxPeople + "," +
                typeOfRental;
    }
}
