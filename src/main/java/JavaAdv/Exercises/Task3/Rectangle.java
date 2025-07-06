package JavaAdv.Exercises.Task3;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(){
        super();
        this.length = 1;
        this.width = 1;
    }

    @Override
    public double getPerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    public Rectangle(String color, boolean isFilled, double length, double width) {
        super(color, isFilled);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
