/*Sử dụng mã triển khai các lớp hình học ở repository này (checkout sang nhánh develop để lấy source code).
Hãy tạo một interface Colorable với một phương thức void có tên howToColor().
Cho lớp Square triển khai interface này với phương thức howToColor() hiển thị thông điệp Color all four sides..

Tạo một mảng các đối tượng hình học trong đó có ít nhất một Square.
Với mỗi phần tử trong mảng, hiển thị diện tích của nó, nếu phần tử đó là một Colorable,
gọi phương thức howToColor().*/
package colorable.model;

import java.text.DecimalFormat;

public class Square extends Shape {
    private double squareEdge;

    public Square() {
    }

    public Square(String color) {
        super(color);
    }

    public Square(double squareEdge) {
        this.squareEdge = squareEdge;
    }

    public Square(String color, boolean filled, double squareEdge) {
        super(color, filled);
        this.squareEdge = squareEdge;
    }

    public double getSquareEdge() {
        return squareEdge;
    }

    public void setSquareEdge(double squareEdge) {
        this.squareEdge = squareEdge;
    }

    public double getArea() {
        return Math.pow(this.squareEdge, 2);
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##.00");
        return "Square{" +
                "edge= " + squareEdge +
                ", area = " + f.format(getArea()) + " ," +
                super.toString() +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}