/*Mô tả:
Thiết kế và triển khai lớp Circle (hình tròn) và lớp con của nó Cylinder (hình trụ).
Lớp Circle có những thuộc tính mô tả bán kính, màu sắc, các getter/setter cho các thuộc tính đó,
 và những thuộc tính liên đới như diện tích.
Lớp Cylinder mở rộng lớp Circle bằng cách bổ sung thuộc tính chiều cao
cũng như có thể có thêm phương thức lấy thể tích.

Cả hai lớp đều phải cài đè phương thức toString để in ra thông tin chi tiết các thuộc tính của đổi tượng.

Hãy vẽ giản đồ UML cho hai lớp trên, với mô tả về các thuộc tính,
các phương thức khởi tạo cần thiết, cũng như các phương thức tính ra các thuộc tính đặc trưng của mỗi lớp.

Hãy viết mã triển khai các lớp đó THEO NHƯ BẢN VẼ ĐÃ THIẾT KẾ.

Viết chương trình sử dụng tới hai lớp đối tượng kia với mục đích kiểm thử.*/

package circle_cylinder.Model;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getHeight(double height) {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public double getCylindricalVolume() {
        return height*super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height= " + height +
                ". Subclass of " + super.toString() +
                " volume= " + getCylindricalVolume() +
                '}';
    }
}
