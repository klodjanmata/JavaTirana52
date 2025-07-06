package JavaAdv.Exercises.OOP.Task1;

public class Point2D {
    private float x;
    private float y;

    public Point2D(){}

    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setX(float x){
        if (validateValue(x)){
            this.x = x;
        }
        else{
            System.out.println("Incorrect value (X)!");
        }
    }

    public float getX(){
        return x;
    }

    public void setY(float y){
        if (validateValue(y)){
            this.y = y;
        }
        else {
            System.out.println("Incorrect value (Y)!");
        }
    }

    public float getY(){
        return y;
    }

    private boolean validateValue(float value){
        if (value < 0){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

}
