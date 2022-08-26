package model.facility;

public abstract class Facility {
    private String typeName;
    private String address;
    private double area;
    private double rentalPrice;
    private int maxGuests;
    private String typeOfRental;

    public Facility() {
    }

    public Facility(String typeName, String address, double area, double rentalPrice, int maxGuests, String typeOfRental) {
        this.typeName = typeName;
        this.address = address;
        this.area = area;
        this.rentalPrice = rentalPrice;
        this.maxGuests = maxGuests;
        this.typeOfRental = typeOfRental;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    @Override
    public String toString() {
        return "Facility{" +
                ", Tên:'" + typeName + '\'' +
                ", Địa chỉ'" + address + '\'' +
                ", Diện tích:" + area +
                ", Giá cho thuê: " + rentalPrice +
                ", Lương khách tối đa: " + maxGuests +
                ", Kiểu cho thuê: '" + typeOfRental + '\'' +
                '}';
    }
}
