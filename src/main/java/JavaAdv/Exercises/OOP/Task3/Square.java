package JavaAdv.Exercises.OOP.Task3;

public class Square extends Rectangle{

    public Square(String color, boolean isFilled, double width){
        super(color, isFilled, width,width);
    }

    @Override
    public void setWidth(double width){
        super.setWidth(width);
        super.setLength(width);
    }
    @Override
    public void setLength(double height){
        super.setLength(height);
        super.setWidth(height);
    }
    @Override
    public String toString(){
        return "Square with width " + getWidth() + "and height " + getLength() + "which is a subclass of " +  super.toString();
    }
}