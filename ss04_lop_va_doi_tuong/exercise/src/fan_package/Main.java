package fan_package;

public class Main {
    public static void main(String[] args) {
        final int MEDIUM = 2;
        final int FAST = 3;
        FanClass fanObject1 = new FanClass();
        fanObject1.setOn(true);
        fanObject1.setRadius(10);
        fanObject1.setColor("yellow");
        fanObject1.setSpeed(FAST);
        System.out.println(fanObject1.toString());
        FanClass fanObject2= new FanClass();
        fanObject2.setOn(false);
        fanObject2.setRadius(5);
        fanObject2.setColor("blue");
        fanObject2.setSpeed(MEDIUM);
        System.out.println(fanObject2.toString());
    }
}