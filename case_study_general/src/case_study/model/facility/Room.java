package case_study.model.facility;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }
    public Room(String serviceID, String serviceName){
        super.setServiceID(serviceID);
        super.setServiceName(serviceName);
    }

    public Room(String serviceID,
                String serviceName,
                String area,
                double rentalPrice,
                int maxPeople,
                String typeOfRental,
                String freeServices) {
        super(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental);
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString()+
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
