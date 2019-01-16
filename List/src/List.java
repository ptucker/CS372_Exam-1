import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class List {
    JList<String> list1;
    protected JPanel shapePanel;
    protected JPanel textPanel;
    java.util.List<String[]> lines = new ArrayList<>(96);
    DefaultListModel<String>model;
    JScrollPane scrollPane;

    // Sets the position of the shape panel
    public void setShapePanel() {
        shapePanel.setBounds(300,0, 400,400);
    }

    // Sets the position of the text panel
    public void setTextPanel() {
        textPanel.setBounds(200, 0, 600, 50);
    }

    public List() {

        // Reads the csv file into the array
        try(FileInputStream is = new FileInputStream("shapes.csv")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            while(line != null) {
                String[] parts = line.split(",");
                lines.add(parts);
                for(String p: parts) {
                    if (p.length() > 0 && p.charAt(0) == '"')
                        System.out.println(p.substring(1, p.length() - 1));
                    else
                        System.out.println(p);
                }
                System.out.println();
                line = rdr.readLine();
            }
        } catch (Exception ex) { System.out.println("Failed for shapes.csv"); }

        // Creates the frame
        JFrame frame = new JFrame("List test");
        frame.setVisible(true);
        frame.setBounds(500, 100, 1000,500 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates and defines the shape panel
        shapePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        shapePanel.setSize(300, 300);
        shapePanel.setBounds(100,100,500,400);
        shapePanel.setLayout(new FlowLayout());
        shapePanel.setOpaque(false);
        frame.add(shapePanel);

        // Creates and defines the text panel
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        textPanel.setSize(300, 300);
        textPanel.setBounds(100,0,500,400);
        textPanel.setLayout(new FlowLayout());
        textPanel.setOpaque(false);
        frame.add(textPanel);

        // Puts the panel that holds the list into the frame
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        // Creates model and reads the csv file into it
        model = new DefaultListModel<>();
        for(int i = 0; i < lines.size(); i++) {
            String fullID = lines.get(i)[0] + " " + lines.get(i)[1];
            model.addElement(fullID);
        }

        // Puts the information from model in the list
        list1 = new JList<>();
        list1.setModel(model);
        list1.setVisibleRowCount(5);

        // Adds scroller to list (Not Working)
        /*scrollPane = new JScrollPane(list1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVisible(true);
        list1.setVisible(true);
        scrollPane.setViewportView(list1); */

        // Adds the list to its panel
        panel.add(list1, BorderLayout.CENTER);

        // Creates a mouse listener to tell if something on the list was double clicked on
        // Then outputs a shape and information about what was clicked on
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList<String> theList = (JList) mouseEvent.getSource();
                int index = theList.locationToIndex(mouseEvent.getPoint());
                if (mouseEvent.getClickCount() == 2) {
                    Object o = theList.getModel().getElementAt(index);
                    textPanel.removeAll();
                    textPanel.revalidate();
                    textPanel.repaint();
                    /*shapePanel.removeAll();       // Not removing previous shapes
                    shapePanel.revalidate();
                    shapePanel.repaint(); */
                    if(o.toString().contains("triangle")) {
                        Triangle t1 = new Triangle(Integer.parseInt(lines.get(index)[2]), Integer.parseInt(lines.get(index)[3]), Integer.parseInt(lines.get(index)[4]), Integer.parseInt(lines.get(index)[1]), lines.get(index)[5], shapePanel);
                        textPanel.add(new JLabel(t1.getDetailString()));
                    }
                    if(o.toString().contains("square")) {
                        Square s1 = new Square(Integer.parseInt(lines.get(index)[2]), Integer.parseInt(lines.get(index)[1]), lines.get(index)[3], shapePanel);
                        textPanel.add(new JLabel(s1.getDetailString()));
                    }
                    if(o.toString().contains("rectangle")) {
                        Rectangle r1 = new Rectangle(Integer.parseInt(lines.get(index)[2]), Integer.parseInt(lines.get(index)[3]), Integer.parseInt(lines.get(index)[1]), lines.get(index)[4], shapePanel);
                        textPanel.add(new JLabel(r1.getDetailString()));
                    }
                    if(o.toString().contains("circle")) {
                        Circle c1 = new Circle(Integer.parseInt(lines.get(index)[2]), lines.get(index)[3], Integer.parseInt(lines.get(index)[1]), shapePanel);
                        textPanel.add(new JLabel(c1.getDetailString()));
                    }
                }
            }

        };
        list1.addMouseListener(mouseListener);
    }
    public static void main(String[] args) {
        List l1 = new List();
        l1.setShapePanel();
        l1.setTextPanel();
    }


}
