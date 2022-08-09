package colorable.model;

public abstract class Shape implements Colorable {
    private String color = "red";
    private boolean filled = false;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return String.format("color is %s, %s", this.color, (isFilled() ? "filled." : "not filled."));
    }

    @Override
    public void howToColor() {
    }
}
