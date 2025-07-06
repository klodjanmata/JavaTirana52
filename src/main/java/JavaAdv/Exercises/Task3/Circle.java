package JavaAdv.Exercises.Task3;


public class Circle extends Shape {
    private double radius;

    public Circle(){
        super();
        this.radius = 1;
    }

    public Circle(String color, boolean isFilled,  double radius){
        super(color, isFilled);
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
