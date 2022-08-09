package resizeable.model;

import java.text.DecimalFormat;

public class Square extends Shape{
    private double squareEdge;

    public Square() {
        this(1.0);
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
    public double getArea(){
        return Math.pow(this.squareEdge,2);
    }
    @Override public void resize (double percent){
        setSquareEdge(getSquareEdge()+getSquareEdge()*percent/100);
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##.00");
        return "Square{" +
                "edge= " + squareEdge +
                ", area = " +  f.format(getArea())+ " ," +
                super.toString() +
                '}';
    }
}