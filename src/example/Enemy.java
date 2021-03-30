/**
 * Enemy extends Shooter class. Provides a point value for enemy
 * @version 1.00 2016/2/7
 */
package example;
import java.awt.*;
import java.util.ArrayList;

public class Enemy extends Shooter{
 
   private int points;
   private static int panelWidth; //All enemies will share this information
   
   private int direction; //moving forward or backward on screen
   private int speed; //value determines how much x is increased by on a move call
   
   public Enemy(int x, int y, int w, int h, Color c, int s, int pts) {
    
    	super(x, y, w, h, c);
   
    	points=pts;
    	direction = 1; //positive x motion
      
      speed=s;
    
    }
   
    public int getPoints(){
    	return points;
    }
    
    public static void setPanelWidth(int w)
    {
    	panelWidth = w;
    }
    
  
    
    
    //Basic Enemy looks like a rectangle
    public void draw(Graphics g){
      
      g.setColor(getColor());
      
      g.fillRect(getX(), getY(), getWidth(), getHeight());
       
     
   }
   
  
 /* The move method is called every time the timer goes off (currently every 50ms) -
  * checkStats() is called at which point both enemies move method is called.  
  * They appear to move at different speeds because of the way the xVal value is updated.
  * It is increased/decreased by the speed value.  For the Circle Enemy, the speed was set
  * to 3 in the constructor.  For the basic Enemy, the speed is 10 */

    public void move()
    {
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
    	setX(xVal); //Sets the xPosition of the enemy so that when enemy is drawn this is the xPos of the left corner
    }    
   
   
}
 