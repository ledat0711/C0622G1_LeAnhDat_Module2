package case_study.model.facility;

public class House extends Facility {
    private String roomStandard;
    private int floorNumber;

    public House() {
    }

    public House(String serviceID,String serviceName) {
        super.setServiceID(serviceID);
        super.setServiceName(serviceName);
    }

    public House(String serviceID,
                 String serviceName,
                 String area,
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
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
