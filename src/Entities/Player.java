package Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {

    //image stuff
    private BufferedImage charter;
    private File file;
    //cords
    private int x,y,w,h;
    private int speed = 10;


//constructors
    public Player (String imgName, int x, int y){ //sets cords
       file = new File(imgName);
       this.x = x;
       this.y = y;
        charter = null;
        try {
            charter = ImageIO.read(new File(file.getAbsolutePath()));
        } catch (IOException e) {
            System.err.println("could not find player model");
            e.printStackTrace();
        }
    }


    public Player (String imgName){ //cords
        file = new File(imgName);
        charter = null;
        try {
            charter = ImageIO.read(new File(file.getAbsolutePath()));
        } catch (IOException e) {
            System.err.println("could not find player model");
            e.printStackTrace();
        }

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
        g2d.drawImage(charter, getX(), getY(), this);
      // g.drawRect(getX(), getY(), 10, 10);
    }

//movement
    public void move1(int y, int w){//moves side to side
        setX(y - w);
    }
    public void move2(int x, int w){//moves side to side
        setY(x - w);
    }
    public void moveLeft(){//moves side to side
        setX(getX()-speed);
    }
    public void moveRight(){//moves side to side
        setX(getX()+speed);
    }
    public void moveDown(){//moves side to side
        setY(getY()+speed);
    }
    public void moveUp(){
        setY((int) (getY()-speed));
    }


    public String getFile() {
        return file.getAbsolutePath();
    }


}
