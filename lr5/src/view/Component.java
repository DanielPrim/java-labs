package view;

import controller.Controller;
import model.ProductLog;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Построение графиков
 */
public class Component extends JComponent{
    ArrayList<Long> dataA10 = Controller.controllerComponentList(10);
    ArrayList<Long> dataA100 = Controller.controllerComponentList(100);
    ArrayList<Long> dataA1000 = Controller.controllerComponentList(1000);
    ArrayList<Long> dataA10000 = Controller.controllerComponentList(10000);
    ArrayList<Long> dataA100000 = Controller.controllerComponentList(100000);

    ArrayList<Long> dataH10 = Controller.controllerComponentMap(10);
    ArrayList<Long> dataH100 = Controller.controllerComponentMap(100);
    ArrayList<Long> dataH1000 = Controller.controllerComponentMap(1000);
    ArrayList<Long> dataH10000 = Controller.controllerComponentMap(10000);
    ArrayList<Long> dataH100000 = Controller.controllerComponentMap(100000);

    /**
     * Построение графиков
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // Рамки
        Rectangle2D border1 = new Rectangle2D.Double(5,20,950,970);
        Rectangle2D border2 = new Rectangle2D.Double(965,20,950,970);
        g2.draw(border1);
        g2.draw(border2);
        // Названия
        g2.drawString("Total Time", 430, 35);
        g2.drawString("Median Time", 430 + 955, 35);

        // Оси
        Line2D oY1 = new Line2D.Double(60,30,60,950);
        Line2D oX1 = new Line2D.Double(60,950,900,950);
        Line2D oY2 = new Line2D.Double(1020, 30, 1020,950);
        Line2D oX2 = new Line2D.Double(1020, 950, 1860, 950);

        g2.draw(oX1);
        g2.drawString("Count",870,935);
        g2.draw(oY1);
        g2.drawString("Time, ms",7,40);
        g2.draw(oX2);
        g2.drawString("Count",1830,935);
        g2.draw(oY2);
        g2.drawString("Time, ns",967,40);

        //Метки на осях
        Line2D numberOfElements10 = new Line2D.Double(60+160,945,60+160,955);
        Line2D numberOfElements100 = new Line2D.Double(60+160*2,945,60+160*2,955);
        Line2D numberOfElements1000 = new Line2D.Double(60+160*3,945,60+160*3,955);
        Line2D numberOfElements10000 = new Line2D.Double(60+160*4,945,60+160*4,955);
        Line2D numberOfElements100000 = new Line2D.Double(60+160*5,945,60+160*5,955);
        g2.draw(numberOfElements10);
        g2.drawString("10", 60+160-5,965);
        g2.draw(numberOfElements100);
        g2.drawString("100", 60+160*2-5,965);
        g2.draw(numberOfElements1000);
        g2.drawString("1000", 60+160*3-5,965);
        g2.draw(numberOfElements10000);
        g2.drawString("10000", 60+160*4-5,965);
        g2.draw(numberOfElements100000);
        g2.drawString("100000", 60+160*5-5,965);

        Line2D number1OfElements10 = new Line2D.Double(1020+160, 945, 1020+160, 955);
        Line2D number1OfElements100 = new Line2D.Double(1020+160*2, 945, 1020+160*2, 955);
        Line2D number1OfElements1000 = new Line2D.Double(1020+160*3, 945, 1020+160*3, 955);
        Line2D number1OfElements10000 = new Line2D.Double(1020+160*4, 945, 1020+160*4, 955);
        Line2D number1OfElements100000 = new Line2D.Double(1020+160*5, 945, 1020+160*5, 955);
        g2.draw(number1OfElements10);
        g2.drawString("10", 1020+160-5,965);
        g2.draw(number1OfElements100);
        g2.drawString("100", 1020+160*2-5,965);
        g2.draw(number1OfElements1000);
        g2.drawString("1000", 1020+160*3-5,965);
        g2.draw(number1OfElements10000);
        g2.drawString("10000", 1020+160*4-5,965);
        g2.draw(number1OfElements100000);
        g2.drawString("100000", 1020+160*5-5,965);

        Line2D time1 = new Line2D.Double(55,950-90,65,950-90);
        Line2D time2 = new Line2D.Double(55,950-90*2,65,950-90*2);
        Line2D time3 = new Line2D.Double(55,950-90*3,65,950-90*3);
        Line2D time4 = new Line2D.Double(55,950-90*4,65,950-90*4);
        Line2D time5 = new Line2D.Double(55,950-90*5,65,950-90*5);
        Line2D time6 = new Line2D.Double(55,950-90*6,65,950-90*6);
        Line2D time7 = new Line2D.Double(55,950-90*7,65,950-90*7);
        Line2D time8 = new Line2D.Double(55,950-90*8,65,950-90*8);
        Line2D time9 = new Line2D.Double(55,950-90*9,65,950-90*9);
        Line2D time10 = new Line2D.Double(55,950-90*10,65,950-90*10);
        g2.draw(time1);
        g2.drawString("8", 55+10, 950-90+5);
        g2.draw(time2);
        g2.drawString("16", 55+10, 950-90*2+5);
        g2.draw(time3);
        g2.drawString("24", 55+10, 950-90*3+5);
        g2.draw(time4);
        g2.drawString("32", 55+10, 950-90*4+5);
        g2.draw(time5);
        g2.drawString("40", 55+10, 950-90*5+5);
        g2.draw(time6);
        g2.drawString("48", 55+10, 950-90*6+5);
        g2.draw(time7);
        g2.drawString("56", 55+10, 950-90*7+5);
        g2.draw(time8);
        g2.drawString("64", 55+10, 950-90*8+5);
        g2.draw(time9);
        g2.drawString("72", 55+10, 950-90*9+5);
        g2.draw(time10);
        g2.drawString("80", 55+10, 950-90*10 + 5);

        Line2D time01 = new Line2D.Double(1015,950-90,1025,950-90);
        Line2D time02 = new Line2D.Double(1015,950-90*2,1025,950-90*2);
        Line2D time03 = new Line2D.Double(1015,950-90*3,1025,950-90*3);
        Line2D time04 = new Line2D.Double(1015,950-90*4,1025,950-90*4);
        Line2D time05 = new Line2D.Double(1015,950-90*5,1025,950-90*5);
        Line2D time06 = new Line2D.Double(1015,950-90*6,1025,950-90*6);
        Line2D time07 = new Line2D.Double(1015,950-90*7,1025,950-90*7);
        Line2D time08 = new Line2D.Double(1015,950-90*8,1025,950-90*8);
        Line2D time09 = new Line2D.Double(1015,950-90*9,1025,950-90*9);
        Line2D time010 = new Line2D.Double(1015,950-90*10,1025,950-90*10);
        g2.draw(time01);
        g2.drawString("1200", 1015+10, 950-90);
        g2.draw(time02);
        g2.drawString("2400", 1015+10, 950-90*2);
        g2.draw(time03);
        g2.drawString("3600", 1015+10, 950-90*3);
        g2.draw(time04);
        g2.drawString("4800", 1015+10, 950-90*4);
        g2.draw(time05);
        g2.drawString("6000", 1015+10, 950-90*5);
        g2.draw(time06);
        g2.drawString("7200", 1015+10, 950-90*6);
        g2.draw(time07);
        g2.drawString("8400", 1015+10, 950-90*7);
        g2.draw(time08);
        g2.drawString("9600", 1015+10, 950-90*8);
        g2.draw(time09);
        g2.drawString("10800", 1015+10, 950-90*9);
        g2.draw(time010);
        g2.drawString("12000", 1015+10, 950-90*10);

        // Точки
        Ellipse2D ArrAddTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - 0.0000115*dataA10.get(0) - 3, 6, 6);
        Ellipse2D ArrRemTotal10 = new Ellipse2D.Double(numberOfElements10.getX1()-3, 950 - 0.0000115*dataA10.get(2)-3, 6, 6);
        Ellipse2D ArrAddMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - 0.075*dataA10.get(1) - 3, 6, 6);
        Ellipse2D ArrRemMedian10 = new Ellipse2D.Double(number1OfElements10.getX1()-3, 950 - 0.075*dataA10.get(3)-3, 6, 6);

        Ellipse2D ArrAddTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - 0.0000115*dataA100.get(0) - 3, 6, 6);
        Ellipse2D ArrRemTotal100 = new Ellipse2D.Double(numberOfElements100.getX1()-3, 950 - 0.0000115*dataA100.get(2)-3, 6, 6);
        Ellipse2D ArrAddMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - 0.075*dataA100.get(1) - 3, 6, 6);
        Ellipse2D ArrRemMedian100 = new Ellipse2D.Double(number1OfElements100.getX1()-3, 950 - 0.075*dataA100.get(3)-3, 6, 6);

        Ellipse2D ArrAddTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - 0.0000115*dataA1000.get(0) - 3, 6, 6);
        Ellipse2D ArrRemTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1()-3, 950 - 0.0000115*dataA1000.get(2)-3, 6, 6);
        Ellipse2D ArrAddMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - 0.075*dataA1000.get(1) - 3, 6, 6);
        Ellipse2D ArrRemMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1()-3, 950 - 0.075*dataA1000.get(3)-3, 6, 6);

        Ellipse2D ArrAddTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - 0.0000115*dataA10000.get(0) - 3, 6, 6);
        Ellipse2D ArrRemTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1()-3, 950 - 0.0000115*dataA10000.get(2)-3, 6, 6);
        Ellipse2D ArrAddMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - 0.075*dataA10000.get(1) - 3, 6, 6);
        Ellipse2D ArrRemMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1()-3, 950 - 0.075*dataA10000.get(3)-3, 6, 6);

        Ellipse2D ArrAddTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - 0.0000115*dataA100000.get(0) - 3, 6, 6);
        Ellipse2D ArrRemTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1()-3, 950 - 0.0000115*dataA100000.get(2)-3, 6, 6);
        Ellipse2D ArrAddMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - 0.075*dataA100000.get(1) - 3, 6, 6);
        Ellipse2D ArrRemMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1()-3, 950 - 0.075*dataA100000.get(3)-3, 6, 6);

        Ellipse2D HashAddTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - 0.0000115*dataH10.get(0) - 3, 6, 6);
        Ellipse2D HashRemTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - 0.0000115*dataH10.get(2) - 3, 6, 6);
        Ellipse2D HashAddMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - 0.075*dataH10.get(1) - 3, 6, 6);
        Ellipse2D HashRemMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - 0.075*dataH10.get(3) - 3, 6, 6);

        Ellipse2D HashAddTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - 0.0000115*dataH100.get(0) - 3, 6, 6);
        Ellipse2D HashRemTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - 0.0000115*dataH100.get(2) - 3, 6, 6);
        Ellipse2D HashAddMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - 0.075*dataH100.get(1) - 3, 6, 6);
        Ellipse2D HashRemMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - 0.075*dataH100.get(3) - 3, 6, 6);

        Ellipse2D HashAddTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - 0.0000115*dataH1000.get(0) - 3, 6, 6);
        Ellipse2D HashRemTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - 0.0000115*dataH1000.get(2) - 3, 6, 6);
        Ellipse2D HashAddMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - 0.075*dataH1000.get(1) - 3, 6, 6);
        Ellipse2D HashRemMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - 0.075*dataH1000.get(3) - 3, 6, 6);

        Ellipse2D HashAddTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - 0.0000115*dataH10000.get(0) - 3, 6, 6);
        Ellipse2D HashRemTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - 0.0000115*dataH10000.get(2) - 3, 6, 6);
        Ellipse2D HashAddMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - 0.075*dataH10000.get(1) - 3, 6, 6);
        Ellipse2D HashRemMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - 0.075*dataH10000.get(3) - 3, 6, 6);

        Ellipse2D HashAddTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - 0.0000115*dataH100000.get(0) - 3, 6, 6);
        Ellipse2D HashRemTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - 0.0000115*dataH100000.get(2) - 3, 6, 6);
        Ellipse2D HashAddMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - 0.075*dataH100000.get(1) - 3, 6, 6);
        Ellipse2D HashRemMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - 0.075*dataH100000.get(3) - 3, 6, 6);

        // Рисуем точки и линии
        g2.setColor(Color.RED);
        g2.drawString("- ArrAddTotal", 860, 35);
        g2.draw(ArrAddTotal10);
        g2.draw(new Line2D.Double(ArrAddTotal10.getCenterX(), ArrAddTotal10.getCenterY(), ArrAddTotal100.getCenterX(), ArrAddTotal100.getCenterY()));
        g2.draw(ArrAddTotal100);
        g2.draw(new Line2D.Double(ArrAddTotal100.getCenterX(), ArrAddTotal100.getCenterY(), ArrAddTotal1000.getCenterX(), ArrAddTotal1000.getCenterY()));
        g2.draw(ArrAddTotal1000);
        g2.draw(new Line2D.Double(ArrAddTotal1000.getCenterX(), ArrAddTotal1000.getCenterY(), ArrAddTotal10000.getCenterX(), ArrAddTotal10000.getCenterY()));
        g2.draw(ArrAddTotal10000);
        g2.draw(new Line2D.Double(ArrAddTotal10000.getCenterX(), ArrAddTotal10000.getCenterY(), ArrAddTotal100000.getCenterX(), ArrAddTotal100000.getCenterY()));
        g2.draw(ArrAddTotal100000);

        g2.drawString("- ArrAddMedian", 1810, 35);
        g2.draw(ArrAddMedian10);
        g2.draw(new Line2D.Double(ArrAddMedian10.getCenterX(), ArrAddMedian10.getCenterY(), ArrAddMedian100.getCenterX(), ArrAddMedian100.getCenterY()));
        g2.draw(ArrAddMedian100);
        g2.draw(new Line2D.Double(ArrAddMedian100.getCenterX(), ArrAddMedian100.getCenterY(), ArrAddMedian1000.getCenterX(), ArrAddMedian1000.getCenterY()));
        g2.draw(ArrAddMedian1000);
        g2.draw(new Line2D.Double(ArrAddMedian1000.getCenterX(), ArrAddMedian1000.getCenterY(), ArrAddMedian10000.getCenterX(), ArrAddMedian10000.getCenterY()));
        g2.draw(ArrAddMedian10000);
        g2.draw(new Line2D.Double(ArrAddMedian10000.getCenterX(), ArrAddMedian10000.getCenterY(), ArrAddMedian100000.getCenterX(), ArrAddMedian100000.getCenterY()));
        g2.draw(ArrAddMedian100000);

        g2.setColor(Color.BLUE);
        g2.drawString("- ArrRemTotal", 860, 45);
        g2.draw(ArrRemTotal10);
        g2.draw(new Line2D.Double(ArrRemTotal10.getCenterX(), ArrRemTotal10.getCenterY(), ArrRemTotal100.getCenterX(), ArrRemTotal100.getCenterY()));
        g2.draw(ArrRemTotal100);
        g2.draw(new Line2D.Double(ArrRemTotal100.getCenterX(), ArrRemTotal100.getCenterY(), ArrRemTotal1000.getCenterX(), ArrRemTotal1000.getCenterY()));
        g2.draw(ArrRemTotal1000);
        g2.draw(new Line2D.Double(ArrRemTotal1000.getCenterX(), ArrRemTotal1000.getCenterY(), ArrRemTotal10000.getCenterX(), ArrRemTotal10000.getCenterY()));
        g2.draw(ArrRemTotal10000);
        g2.draw(new Line2D.Double(ArrRemTotal10000.getCenterX(), ArrRemTotal10000.getCenterY(), ArrRemTotal100000.getCenterX(), ArrRemTotal100000.getCenterY()));
        g2.draw(ArrRemTotal100000);

        g2.drawString("- ArrRemMedian", 1810, 45);
        g2.draw(ArrRemMedian10);
        g2.draw(new Line2D.Double(ArrRemMedian10.getCenterX(), ArrRemMedian10.getCenterY(), ArrRemMedian100.getCenterX(), ArrRemMedian100.getCenterY()));
        g2.draw(ArrRemMedian100);
        g2.draw(new Line2D.Double(ArrRemMedian100.getCenterX(), ArrRemMedian100.getCenterY(), ArrRemMedian1000.getCenterX(), ArrRemMedian1000.getCenterY()));
        g2.draw(ArrRemMedian1000);
        g2.draw(new Line2D.Double(ArrRemMedian1000.getCenterX(), ArrRemMedian1000.getCenterY(), ArrRemMedian10000.getCenterX(), ArrRemMedian10000.getCenterY()));
        g2.draw(ArrRemMedian10000);
        g2.draw(new Line2D.Double(ArrRemMedian10000.getCenterX(), ArrRemMedian10000.getCenterY(), ArrRemMedian100000.getCenterX(), ArrRemMedian100000.getCenterY()));
        g2.draw(ArrRemMedian100000);

        g2.setColor(Color.magenta);
        g2.drawString("- HashAddTotal", 860, 55);
        g2.draw(HashAddTotal10);
        g2.draw(new Line2D.Double(HashAddTotal10.getCenterX(), HashAddTotal10.getCenterY(), HashAddTotal100.getCenterX(), HashAddTotal100.getCenterY()));
        g2.draw(HashAddTotal100);
        g2.draw(new Line2D.Double(HashAddTotal100.getCenterX(), HashAddTotal100.getCenterY(), HashAddTotal1000.getCenterX(), HashAddTotal1000.getCenterY()));
        g2.draw(HashAddTotal1000);
        g2.draw(new Line2D.Double(HashAddTotal1000.getCenterX(), HashAddTotal1000.getCenterY(), HashAddTotal10000.getCenterX(), HashAddTotal10000.getCenterY()));
        g2.draw(HashAddTotal10000);
        g2.draw(new Line2D.Double(HashAddTotal10000.getCenterX(), HashAddTotal10000.getCenterY(), HashAddTotal100000.getCenterX(), HashAddTotal100000.getCenterY()));
        g2.draw(HashAddTotal100000);

        g2.drawString("- HashAddMedian", 1810, 55);
        g2.draw(HashAddMedian10);
        g2.draw(new Line2D.Double(HashAddMedian10.getCenterX(), HashAddMedian10.getCenterY(), HashAddMedian100.getCenterX(), HashAddMedian100.getCenterY()));
        g2.draw(HashAddMedian100);
        g2.draw(new Line2D.Double(HashAddMedian100.getCenterX(), HashAddMedian100.getCenterY(), HashAddMedian1000.getCenterX(), HashAddMedian1000.getCenterY()));
        g2.draw(HashAddMedian1000);
        g2.draw(new Line2D.Double(HashAddMedian1000.getCenterX(), HashAddMedian1000.getCenterY(), HashAddMedian10000.getCenterX(), HashAddMedian10000.getCenterY()));
        g2.draw(HashAddMedian10000);
        g2.draw(new Line2D.Double(HashAddMedian10000.getCenterX(), HashAddMedian10000.getCenterY(), HashAddMedian100000.getCenterX(), HashAddMedian100000.getCenterY()));
        g2.draw(HashAddMedian100000);

        g2.setColor(Color.BLACK);
        g2.drawString("- HashRemTotal", 860, 65);
        g2.draw(HashRemTotal10);
        g2.draw(new Line2D.Double(HashRemTotal10.getCenterX(), HashRemTotal10.getCenterY(), HashRemTotal100.getCenterX(), HashRemTotal100.getCenterY()));
        g2.draw(HashRemTotal100);
        g2.draw(new Line2D.Double(HashRemTotal100.getCenterX(), HashRemTotal100.getCenterY(), HashRemTotal1000.getCenterX(), HashRemTotal1000.getCenterY()));
        g2.draw(HashRemTotal1000);
        g2.draw(new Line2D.Double(HashRemTotal1000.getCenterX(), HashRemTotal1000.getCenterY(), HashRemTotal10000.getCenterX(), HashRemTotal10000.getCenterY()));
        g2.draw(HashRemTotal10000);
        g2.draw(new Line2D.Double(HashRemTotal10000.getCenterX(), HashRemTotal10000.getCenterY(), HashRemTotal100000.getCenterX(), HashRemTotal100000.getCenterY()));
        g2.draw(HashRemTotal100000);

        g2.drawString("- HashRemMedian", 1810, 65);
        g2.draw(HashRemMedian10);
        g2.draw(new Line2D.Double(HashRemMedian10.getCenterX(), HashRemMedian10.getCenterY(), HashRemMedian100.getCenterX(), HashRemMedian100.getCenterY()));
        g2.draw(HashRemMedian100);
        g2.draw(new Line2D.Double(HashRemMedian100.getCenterX(), HashRemMedian100.getCenterY(), HashRemMedian1000.getCenterX(), HashRemMedian1000.getCenterY()));
        g2.draw(HashRemMedian1000);
        g2.draw(new Line2D.Double(HashRemMedian1000.getCenterX(), HashRemMedian1000.getCenterY(), HashRemMedian10000.getCenterX(), HashRemMedian10000.getCenterY()));
        g2.draw(HashRemMedian10000);
        g2.draw(new Line2D.Double(HashRemMedian10000.getCenterX(), HashRemMedian10000.getCenterY(), HashRemMedian100000.getCenterX(), HashRemMedian100000.getCenterY()));
        g2.draw(HashRemMedian100000);
    }
}
