import javax.swing.*;
import java.awt.*;

import static java.lang.StrictMath.sqrt;

public class Triangle extends JPanel implements Shape{
    private String kind = "Triangle";
    private int ID;
    private int side1;
    private int side2;
    private int side3;
    private String color;
    private double area;
    private int perimeter;

    public Triangle(int _side1, int _side2, int _side3, int id, String _color, JPanel _shapePanel) {

        ID = id;
        side1 = _side1;
        side2 = _side2;
        side3 = _side3;
        perimeter = side1 + side2 + side3;
        area = sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));
        color = _color;

        Graphics g = _shapePanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        int x[]={150,100,200};
        int y[]={100,200,200};
        Polygon p = new Polygon(x, y, 3);
        g2d.setColor(Color.RED);
        g2d.fill(p);


    }
    public String toString() {
        return kind + " " + ID;
    }

    public String getKind() {
        return kind;
    }

    public String getDetailString() {
        return this.toString() + " Side 1: " + this.getSide1() + " Side 2: " + this.getSide2() + " Side 3: " + this.getSide3() + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter() + " Color: " + this.getColor();
    }

    public int getID() {
        return ID;
    }

    public double getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    public String getColor() {
        return color;
    }
}