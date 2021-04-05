package Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class EnemySquare extends Enemy implements Runnable{


    //cords
    private int x, y, w, h;
    private int direction;
    private static int panelWidth;
    private static int panelHeight;
    private int speedX = 10;
    private int speedY = 10;
    private static Color color;
    private Thread e;
//random color
//private int colorCode = (int) (Math.random() * 255 + 1);


    //constructors
    public EnemySquare(Color color, int x, int y, int w, int h) { //sets cords
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        setDoubleBuffered(true);

    }

    public EnemySquare(int w, int h) { //sets cords
        this.w = w;
        this.h = h;
        setDoubleBuffered(true);

    }

    public EnemySquare(Color color) { //sets cords
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
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public static void setPanelHeight(int panelHeight) {
        EnemySquare.panelHeight = panelHeight;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
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

    public void setColorCode(int colorCode) {
    }

    public void draw(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(color);
        g.fillRect(getX(), getY(), w, h);
    }

    //TODO get the Enemy to bounce off the walls of the screen
    @Override
    public void run(){bounce();}


//public void bounce() {
//    while (true) { // Execute one update step
//        // Calculate the ball's new position
//        x += speedX;
//        y += speedY;
//        // Check if the ball moves over the bounds
//        // If so, adjust the position and speed.
//        if (x - w < 0) {
//            speedX = -speedX; // Reflect along normal
//            x = w; // Re-position the ball at the edge
//        } else if (x + w > panelWidth) {
//            speedX = -speedX;
//            x = panelWidth - w;
//        }
//        // May cross both x and y bounds
//        if (y - w < 0) {
//            speedY = -y;
//            y = w;
//        } else if (y + w > panelWidth) {
//            speedY = -speedY;
//            y = panelHeight - w;
//        }
//        // Refresh the display
//        repaint(); // Callback paintComponent()
//        //Delay for timing control and give other threads a chance
//        try {
//            Thread.sleep(1000 / 10);  // milliseconds
//        } catch (InterruptedException ex) {
//
//            }
//        }
//    }


    public void bounce() {

        int xVal = getX();

        if (xVal + getWidth() > panelWidth) {  //include getWidth() so we bounce off on the right edge

            direction = 0; //negative;
            xVal -= speedX;
        } else if (xVal < 0) {

            xVal += speedX;
            direction = 1; //positive
        } else {
            if (direction == 1)
                xVal += speedX;
            else
                xVal -= speedX;
        }
        setX(xVal); //Sets the xPosition of the enemy so that when enemy is drawn this is the xPos of the left corner
    }

    public Rectangle getBounds(){
        return (new Rectangle(x,y,w,h));
    }


}
