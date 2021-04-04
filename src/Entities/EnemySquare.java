package Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class EnemySquare extends Enemy  {


    //cords
private int x,y,w,h;
private int direction;
private static int panelWidth;
private int speed = 10;
private static Color color;

//random color
//private int colorCode = (int) (Math.random() * 255 + 1);


    //constructors
    public EnemySquare( Color color, int x, int y, int w, int h){ //sets cords
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        setDoubleBuffered(true);
    }
    public EnemySquare(int w, int h){ //sets cords
        this.w = w;
        this.h = h;
        setDoubleBuffered(true);

    }

    public EnemySquare(Color color){ //sets cords
        this.x = x;
        this.y = y;
        this.color = color;
        setDoubleBuffered(true);
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
    public void setPanelWidth(int pWidth) {
       panelWidth = pWidth;
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


    public void bounce(){
        //TODO get the Enemy to bounce off the walls of the screen

        int xVal = getX();


        if(xVal + getWidth() > panelWidth){  //include getWidth() so we bounce off on the right edge

            direction=0; //negative;
            xVal-=speed;
        }
        else if(xVal < 0){

            xVal+=speed;
            direction = 1; //positive
        }
        else
        {
            if(direction == 1)
                xVal+=speed;
            else
                xVal-=speed;
        }
        setX(xVal);
    }


    public Rectangle getBounds(){
        return (new Rectangle(x,y,w,h));
    }


}
