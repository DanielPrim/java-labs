package view;

import javax.swing.*;
import java.awt.Color;

/**
 * Создание окна
 */
public class Frame extends JFrame {

    private int width = 1920;
    private int height = 1080;

    /**
     * Создание окна с фиксированными размерами и вызываемым содержимым
     */
    public Frame() {
        setTitle("Графики");
        setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.WHITE);

        this.add(new Component());
    }
}