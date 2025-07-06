package JavaAdv.Exercises.Task3;

public abstract class Shape {
    private String color;
    private boolean isFilled;

    public Shape(){
        this.color = "Unknown";
        this.isFilled = false;
    }

    public Shape(String color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public String toString() {
        return "Shape with color of " + color + " and "
                + (isFilled ? " filled" : " not filled");
    }
}
