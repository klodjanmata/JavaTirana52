package JavaAdv.Exercises.OOP.Task5;

public class Main {
    public static void main(String[] args) {
        Line l = new Line(2, 2, 5, 5);
        System.out.println(l);
        System.out.println("Length: " + l.getLineLength());
        System.out.println("Middle: " + l.getMiddleOfLine());
    }
}
