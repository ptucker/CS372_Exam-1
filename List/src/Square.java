import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends JLabel implements Shape {
    private String kind = "Square";
    private int ID;
    private int side;
    private String color;
    private int area;
    private int perimeter;

    public Square(int _side, int id, String _color, JPanel _shapePanel) {

        side = _side;
        ID = id;
        color = _color;
        area = side * side;
        perimeter = side * 4;

        // Creates the square
        Graphics g = _shapePanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double square = new Rectangle2D.Double(100, 100, 100, 100);
        g2d.setColor(Color.GREEN);
        g2d.fill(square);


    }
    public String toString() {
        return kind + " " + ID;
    }

    public String getKind() {
        return kind;
    }

    public String getDetailString() {
        return this.toString() + " Side: " + this.getSide() + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter() + " Color: " + this.getColor();
    }

    public int getID() {
        return ID;
    }

    public int getSide() {
        return side;
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
