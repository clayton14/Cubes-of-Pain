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
private int colorCode = (int) (Math.random() * 255 + 1);


    //constructors
    public EnemySquare(int x, int y, Color color){ //sets cords
        this.x = x;
        this.y = y;
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

    //setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) {
        this.y = y;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void draw(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(color);
        g.drawRect(getX(), getY(), 10, 10);

    }

    //movement
    public void move(int x, int w){//moves side to side
        setX(x - w);
    }
//    public void moveLeft(){//moves side to side
//        setX((int) (getX()-Math.random()* 10));
//    }
//    public void moveRight(){//moves side to side
//        setX((int) (getX()+Math.random()* 10));
//    }
//    public void moveDown(){//moves side to side
//        setY((int) (getY()+Math.random()* 10));
//    }
//    public void moveUp(){
//        setY((int) (getY()-Math.random()* 10));
//    }




}
