package JavaAdv.Exercises.OOP.Task1;

public class Main {
    public static void main(String[] args) {
        Point2D point = new Point2D();
        point.setX(5);
        point.setY(15);
        System.out.println(point);

        Point3D point3D = new Point3D(10, 15, -5);
        System.out.println(point3D);

        float[] values = point3D.getXYZ();

        for (int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }
    }
}
