package point2d_point3d.Controller;

import point2d_point3d.Model.Point2D;
import point2d_point3d.Model.Point3D;

public class MainController {
    public static void main(String[] args) {
        Point2D point2D1= new Point2D();
        System.out.println(point2D1);
        point2D1 = new Point2D(4.2f,7.1f);
        System.out.println(point2D1);

        Point3D point3D1 = new Point3D();
        System.out.println(point3D1);
        point3D1 = new Point3D(1.4f,4.6f, 6.7f );
        System.out.println(point3D1);
    }
}
