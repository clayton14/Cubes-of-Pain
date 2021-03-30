package example;
/**
 * Basic Enemy, Circle Shaped - slower speed, worth 100 points
 * @version 1.00 2016/2/7
 */
import java.awt.*;
import java.util.ArrayList;

public class CircleEnemy extends Enemy{
 
   
    public CircleEnemy(int x, int y, int w, int h) {
    	super(x, y, w, h, Color.orange, 3, 100); //3 speed, 100 points      
   
    }
   
   
    
    public void draw(Graphics g){
      
      g.setColor(getColor());
      
      g.fillOval(getX(), getY(), getHeight(), getWidth());
     
   }

 
   

     
   
   
}
 