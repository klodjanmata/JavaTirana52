package JavaAdv.Exercises.Task3;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Red", true, 3));
        shapes.add(new Rectangle("Blue", true, 5, 7));
        shapes.add(new Square("Green", true, 3));

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }

    }
}
