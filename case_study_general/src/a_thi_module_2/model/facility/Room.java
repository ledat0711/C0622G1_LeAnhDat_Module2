package a_thi_module_2.model.facility;

import case_study.model.facility.Facility;

import java.util.Objects;

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
                double area,
                double rentalPrice,
                int maxPeople,
                String typeOfRental,
                String freeServices) {
        super(serviceID, serviceName, area, rentalPrice, maxPeople, typeOfRental);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getFreeServices());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",getServiceID(),getServiceName(),getArea(),getRentalPrice(),getMaxPeople(),getTypeOfRental(),getFreeServices());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(freeServices, room.freeServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeServices);
    }
}
