package JavaAdv.Exercises.OOP.Task5;

import JavaAdv.Exercises.OOP.Task1.Point2D;

public class Line {
    public Point2D begin;
    public Point2D end;

    public Line(Point2D begin, Point2D end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(float beginX, float beginY, float endX, float endY) {
        this.begin = new Point2D(beginX, beginY);
        this.end = new Point2D(endX, endY);
    }

    public double getLineLength(){
        return Math.sqrt(
                Math.pow((begin.getX() - end.getX()), 2) +
                Math.pow((begin.getY()) - end.getY(), 2)
        );
    }

    public Point2D getMiddleOfLine(){
        return new Point2D(
                (begin.getX() + end.getX())/2,
                (begin.getY() + end.getY())/2
        );
    }

    public Point2D getBegin() {
        return begin;
    }

    public void setBegin(Point2D begin) {
        this.begin = begin;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
