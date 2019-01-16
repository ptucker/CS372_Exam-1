import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
    private String kind = "Rectangle";
    private int ID;
    private int length;
    private int width;
    private String color;
    private int area;
    private int perimeter;

    public Rectangle(int _length, int _width, int id, String _color, JPanel _shapePanel) {

        length = _length;
        width = _width;
        ID = id;
        color = _color;
        area = length * width;
        perimeter = length * 2 + width * 2;

        // Creates the square
        Graphics g = _shapePanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double square = new Rectangle2D.Double(100, 100, 150, 100);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(square);
    }
    public String toString() {
        return kind + " " + ID;
    }

    public String getKind() {
        return kind;
    }

    public String getDetailString() {
        return this.toString() + " Length: " + this.getLength() + " Width: " + this.getWidth() + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter() + " Color: " + this.getColor();
    }

    public int getID() {
        return ID;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public String getColor() {
        return color;
    }

}
