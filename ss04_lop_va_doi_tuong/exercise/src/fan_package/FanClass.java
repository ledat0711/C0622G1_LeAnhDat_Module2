package fan_package;

public class FanClass {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private boolean on;
    private int speed = SLOW;
    private double radius = 5;
    private String color = "blue";

    public FanClass() {
    }

    public void setOn(boolean trueOrFalse) {
        this.on = trueOrFalse;
    }

    public void setSpeed(int speedValue) {
        this.speed = speedValue;
    }

    public void setColor(String colorValue) {
        this.color = colorValue;
    }

    public void setRadius(int radiusValue) {
        this.radius = radiusValue;
    }

    public String getSpeed() {
        if (this.speed == 3) {
            return "FAST";
        } else if (this.speed == 2) {
            return "MEDIUM";
        } else {
            return "SLOW";
        }
    }

    public String getColor() {
        return this.color;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean getOn() {
        return this.on;
    }

    public String toString() {
        if (this.on) {
            return ("fan is on" +
                    "\nSpeed: " + getSpeed() +
                    "\nColor: " + this.color +
                    "\nRadius= " + this.radius + "\n");
        }
        return ("fan is off" +
                "\nColor: " + this.color +
                "\nRadius: " + this.radius +
                "\n");
    }
}