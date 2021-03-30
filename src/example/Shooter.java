/**
 * Abstract class for an object that shoots.  Abstract method is draw
 * 
 * @version 1.00 2016/2/7
 */
package example;
import java.awt.*;
import java.util.ArrayList;

public abstract class Shooter  {
   
   
   private int cornerX, cornerY; //top left corner of shooter
   private int height, width; //width and height of shooter
   private Color color; //color of shooter
    
   
    public Shooter(int x, int y, int w, int h, Color c) {
    	cornerX = x;
    	cornerY = y;
    	height = h;
    	width = w;
    	color = c;
       	
    }
    
    
  
 
    
    public Color getColor(){
    	return color;
    }
   

   public int getHeight(){
   	  return height;
   }
   
   public void setHeight(int h)
   {
   	height = h;
   }
   
   public void setWidth(int w)
   {
   	width = w;
   }
   
   public int getWidth(){
   	  return width;
   }
   
   public int getX(){
   	  return cornerX;
   }
   
   public int getY(){
   	  return cornerY;
   }
   
   public void setX(int x){
   	  cornerX = x;
   }

  public void setY(int x){
   	  cornerY = x;
   }
 

  
 
   //Must be defined by child classes
    public abstract void draw(Graphics g);
  
   
 

}
 