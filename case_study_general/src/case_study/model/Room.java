package case_study.model;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String serviceId, String serviceName, double areaUse, int rentalCosts, int maxNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(serviceId, serviceName, areaUse, rentalCosts, maxNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                this.getServiceId(),
                this.getServiceName(),
                this.getAreaUse(),
                this.getRentalCosts(),
                this.getMaxNumberOfPeople(),
                this.getRentalType(),
                this.getFreeServiceIncluded());
    }

    @Override
    public String toString() {
        return super.toString() + ", Dịch vụ miễn phí đi kèm: " + getFreeServiceIncluded();
    }
}
