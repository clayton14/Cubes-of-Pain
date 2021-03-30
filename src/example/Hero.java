/**
 * Extends Shooter for Hero
 * @version 1.00 2016/1/7
 */

package example;
import example.Shooter;
import java.awt.*;
import java.util.ArrayList;

public class Hero extends Shooter {
 
   boolean activated; //Can only shoot when activated. One active Hero at a time      
 
    public Hero(int x, int y, int w, int h, Color c) {
    	super(x, y, w, h, c);
    	activated=false;
      }
    
   //Activate causes the Hero to enlarge and provides bullets
    public void activate()
    {
    	setHeight(getHeight()*2);  //active life is larger
    	setWidth(getWidth()*2);
    	setX(getWidth()*4);
    
    }
    
    //Hero is drawn to look like a ship (kind of)
    
    public void draw(Graphics g){

      g.setColor(getColor());
      g.fillRect(getX()-5,getY(),10,getHeight()+10);
      g.fillRect(getX(),getY(),getWidth(),getHeight());
      g.fillRect(getX()+getWidth(), getY(), 10, getHeight()+10);
      g.setColor(new Color(0,255,0));            
   
      g.drawLine(getX(), getY(), getWidth()/2+getX(), getY()-10);
      g.drawLine(getX()+getWidth()/2, getY()-10, getWidth()+getX(), getY());

   } 
   
 
    
  //moves X value of Hero
   public void move(int x, int w){//moves side to side
       setX(x - w);
      
   }
   
 public void moveLeft(){//moves side to side
       setX(getX()-10);
      
   }

public void moveRight(){//moves side to side
       setX(getX()+10);
      
   }
   
 public void moveSouth(){//moves side to side
       setY(getY()+10);
      
   }

public void moveNorth(){//moves side to side
       setX(getY()-10);
      
   }

  
   
    
 
}
 