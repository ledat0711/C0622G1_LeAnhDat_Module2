package product_manager.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String iD;
    private String name;
    private String manufacturer;
    private long price;

    public Product() {
    }

    public Product(String iD, String name, String manufacturer, long price) {
        this.iD = iD;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "iD='" + iD + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
