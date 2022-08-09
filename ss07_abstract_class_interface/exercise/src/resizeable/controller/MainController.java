/*Sử dụng mã triển khai các lớp hình học ở repository này (checkout sang nhánh develop để lấy source code).
Hãy tạo một interface Resizeable với một phương thức void có tên resize(double percent).
Phương thức này tăng kích thước các hình lên tỷ lệ phần trăm được cho bởi đối số đầu vào.
Cho lớp Circle, Rectangle và Square triển khai phương thức này.

Viết một chương trình tạo ra một mảng các hình.
Với mỗi phần tử trong mảng, tăng kích thước phần tử đó lên theo một tỉ lệ ngẫu nhiên từ 1-100.
Thông báo ra màn hình diện tích của phần tử trước và sau khi tăng kích thước.*/
package resizeable.controller;

import resizeable.model.Circle;
import resizeable.model.Rectangle;
import resizeable.model.Shape;
import resizeable.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(8,8);
        shapes[2] = new Square(7);//for (kieuDuLieu bienDaiDien : tenMang) {
        for(Shape represent : shapes){
            System.out.println("Before: ");
            System.out.println(represent);
            System.out.println("After");
            represent.resize(30);
            System.out.println(represent+"\n\n");
        }
    }
}
