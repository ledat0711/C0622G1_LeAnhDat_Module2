package case_study.model.facility;

public class Villa extends Facility {
    private String roomStandard;
    private String poolArea;
    private int floor;

    public Villa() {
    }

    public Villa(String serviceID,
                 String serviceName,
                 double area,
                 double rentalPrice,
                 int maxPeople,
                 String typeOfRental,
                 String roomStandard,
                 String poolArea,
                 int floor) {
        super(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String getInfo() {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getRoomStandard(),getPoolArea(),getFloor());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getRoomStandard(),getPoolArea(),getFloor());
    }
}
