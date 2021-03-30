/**
 * Enemy that is using an image
 * @version 1.00 2016/2/7
 */
package example;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;




public class ImageEnemy extends Enemy {

  	private BufferedImage img;
  	File file = new File("sample_img.png");
    public ImageEnemy(int x, int y, int w, int h)  {
    	super(x, y, w, h, Color.orange, 10, 100); //3 speed, 100 points      
    	img = null;
        try
        {
            img = ImageIO.read(new File(file.getAbsolutePath()));
        }
        catch (IOException e)
        {
        	System.out.println("Could not get picture");
        }
   
    }

    public void draw(Graphics g){
      
      g.drawImage(img, getX(), getY(), null);

     
   }



   
   
}
 