import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VectorDrawingProgram extends JFrame {

//    public static Color currentColor;
    public static Color currentColor = Color.BLACK;
    public static int shapeType = 0; // 0 - линия, 1 - прямоугольник, 2 - эллипс

    public VectorDrawingProgram() {
        super("Векторное рисование");

        JButton lineButton = new JButton("Линия");
        JButton rectangleButton = new JButton("Прямоугольник");
        JButton ellipseButton = new JButton("Эллипс");

        JButton colorButton = new JButton("Выбрать цвет");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(colorButton);

        DrawingPanel drawingPanel = new DrawingPanel();

        lineButton.addActionListener(e -> shapeType = 0);
        rectangleButton.addActionListener(e -> shapeType = 1);
        ellipseButton.addActionListener(e -> shapeType = 2);

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = JColorChooser.showDialog(VectorDrawingProgram.this, "Выберите цвет", currentColor);
                if (currentColor == null) {
                    currentColor = Color.BLACK;
                }
            }
        });

        drawingPanel.addMouseListener(new DrawingMouseListener(drawingPanel));

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}