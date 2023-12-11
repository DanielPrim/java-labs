import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel {
    private final java.util.List<Shape> shapes = new java.util.ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(VectorDrawingProgram.currentColor);

        for (Shape shape : shapes) {
            g2d.draw(shape);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    public void clearShapes() {
        shapes.clear();
        repaint();
    }
}