package point_moveable_point.Controller;

import point_moveable_point.Model.MovablePoint;
import point_moveable_point.Model.Point;

public class MainController {
    public static void main(String[] args) {
        Point point1=new Point();
        System.out.println(point1);
        point1 =new Point(4,6);

        MovablePoint movablePoint1=new MovablePoint();
        System.out.println(movablePoint1);
        MovablePoint movablePoint2=new MovablePoint(4,6,7,8);
        System.out.println(movablePoint2);
        movablePoint2.move();
        System.out.println(movablePoint2);
    }
}
