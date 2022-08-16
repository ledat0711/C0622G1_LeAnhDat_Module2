package product_management.model;

import java.util.Comparator;

import static product_management.controller.ProductController.numericalOrder;

public class Product implements Comparator<Product>{
    private int iD;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int iD, String name, int price) {
        this.iD = iD;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        ++numericalOrder;
        return "Sản phẩm " + numericalOrder + " {" +
                "ID:'" + iD + '\'' +
                ", tên: '" + name + '\'' +
                ", giá: " + price + " triệu VND" +
                '}';
    }
// Giải thích về phương thức toString2():
// Lúc tìm và hiển thị sản phẩm tìm được, khi gọi toString() (bên trên) thì số thứ tự (numericalOrder) hiển thị không đúng.
// Vì vậy, khi tìm và hiển thị được sản phẩm mà mình tìm được,
// Ta nên loại bỏ hẳn số thứ tự bằng cách gọi hàm toString2() bên dưới (chỉ áp dụng cho chức năng tìm kiếm s.phẩm):
    public String toString2() {
        return "Sản phẩm {" +
                "ID:'" + iD + '\'' +
                ", tên: '" + name + '\'' +
                ", giá: " + price + " triệu VND" +
                '}';
    }

    @Override
    public int compare(Product first, Product second) {
        return Integer.compare(first.getPrice(), second.getPrice());
    }
}
