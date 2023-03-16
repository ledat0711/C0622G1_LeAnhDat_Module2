package case_study.model;

public abstract class Facility {
    private String serviceId;
    private String serviceName;
    private double areaUse;
    private int rentalCosts;
    private int maxNumberOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceId, String serviceName, double areaUse, int rentalCosts, int maxNumberOfPeople, String rentalType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentalType = rentalType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Mã dịch vụ: " + getServiceId() +
                ", Tên dịch vụ: " + getServiceName() +
                ", Diện tích sử dụng (m2): " + getAreaUse() +
                ", Chi phí thuê (VNĐ): " + getRentalCosts() +
                ", Số người tối đa: " + getMaxNumberOfPeople() +
                ", Kiểu thuê: " + getRentalType();
    }
}
