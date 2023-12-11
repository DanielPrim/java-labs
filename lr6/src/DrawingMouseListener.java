import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;


public class DrawingMouseListener implements java.awt.event.MouseListener {
    private final DrawingPanel drawingPanel;
    private Point startPoint;

    public DrawingMouseListener(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        int width = e.getX() - startPoint.x;
        int height = e.getY() - startPoint.y;

        Shape shape = null;
        switch (VectorDrawingProgram.shapeType) {
            case 0:
                shape = new Line2D.Double(startPoint, new Point(e.getX(), e.getY()));
                break;
            case 1:
                shape = new Rectangle(startPoint.x, startPoint.y, width, height);
                break;
            case 2:
                shape = new Ellipse2D.Double(startPoint.x, startPoint.y, width, height);
                break;
        }

        if (shape != null) {
            drawingPanel.addShape(shape);
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // Not used
    }
}