import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JLabel implements Shape{
    private String kind = "Circle";
    private int ID;
    private int radius;
    private String color;
    private double area;
    private double perimeter;

    public Circle(int _radius, String _color, int id, JPanel _shapePanel) {

        // Sets the properties
        radius = _radius;
        area = radius * radius * 3.14;
        perimeter = radius * 2 * 3.14;
        color = _color;
        ID = id;

        //Draws out the circle into the panel in the parameter
        Graphics g = _shapePanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(100, 100, 100, 100);
        g2d.setColor(Color.BLUE);
        g2d.fill(circle);
    }
    public String toString() {
        return kind + " " + ID;
    }

    public String getKind() {
        return kind;
    }

    public String getDetailString() {
        return this.toString() + " Radius: " + this.getRadius() + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter() + " Color: " + this.getColor();
    }

    public int getID() {
        return ID;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String getColor() {
        return color;
    }
}