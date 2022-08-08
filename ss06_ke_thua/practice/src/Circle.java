/*Lớp Circle
Có thêm thuộc tính radius (double).

Có ba phương thức khởi tạo.
Phương thức khởi tạo mà không cần đối số đầu vào sẽ đặt giá trị mặc định cho radius là 1.0.

Có các getter và setter cho cả ba phương thức.

Có phương thức getArea và getPerimeter trả về diện tích và chu vi của hình.

Được cài đè phương thức toString trả về chuỗi ký tự theo mẫu "A Circle with radius=xxx, which is a subclass of yyy".
Trong đó yyy là kết quả thực thi từ phương thức toString của lớp Shape.*/

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI*Math.pow(this.radius, 2);
    }

    public double getPerimeter(){
        return this.radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " +
                this.radius +
                " , which is a subclass of " +
                super.toString(); //yyy: kết quả toString() của lớp Shape.
    }
}
