package Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class EnemySquare extends JPanel {


    //image stuff
    //cords
private int x,y,w,h;

private int speed = 10;
Color color;

//random stuff
//private int colorCode = (int) (Math.random() * 255 + 1);


    //constructors
    public EnemySquare( Color color, int x, int y, int w, int h){ //sets cords
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    public EnemySquare(){ //sets cords
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public EnemySquare(Color color){ //sets cords
        this.x = x;
        this.y = y;
        this.color = color;
    }


//getters

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

    //setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) {
        this.y = y;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setW(int w) {
        this.w = w;
    }
    public void setH(int h) {
        this.h = h;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setColorCode(int colorCode) {}

    public void draw(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(color);
        g.fillRect(getX(), getY(), w, h);
    }


    public Rectangle getBounds(){
        return (new Rectangle(x,y,w,h));
    }





}
