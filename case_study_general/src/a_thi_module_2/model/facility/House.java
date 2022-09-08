package a_thi_module_2.model.facility;

import case_study.model.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private int floorNumber;

    public House() {
    }

    public House(String serviceID, String serviceName) {
        super.setServiceID(serviceID);
        super.setServiceName(serviceName);
    }

    public House(String serviceID,
                 String serviceName,
                 double area,
                 double rentalPrice,
                 int maxPeople,
                 String typeOfRental,
                 String roomStandard,
                 int floorNumber) {
        super(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental);
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getRoomStandard(),getFloorNumber());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getRoomStandard(),getFloorNumber());
    }
}
