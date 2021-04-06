package Entities;

import javax.swing.*;
import java.awt.*;

public abstract class Enemy extends JPanel {

    private int x,y,w,h;
    private int direction;
    private static int panelWidth;
    private int speed = 10;
    private static Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getDirection() {
        return direction;
    }

    public static int getPanelWidth() {
        return panelWidth;
    }

    public static Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }
    public void setH(int h) {
        this.h = h;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setPanelWidth(int panelWidth) {
        Enemy.panelWidth = panelWidth;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setColor(Color color) {
        Enemy.color = color;
    }
}