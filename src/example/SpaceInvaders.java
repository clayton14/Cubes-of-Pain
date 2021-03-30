/**
 * @(#)SpaceInvaders.java
 *
 * SpaceInvaders application
 *
 * @author 
 * @version 1.00 2016/2/5
 */

package example;
    
import javax.swing.*;
import java.awt.*;

public class SpaceInvaders{

   public static void main(String[] args){
  
      JFrame arcade = new JFrame();
      arcade.setTitle("AP Java Game Room");
      arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
      JPanel panel = new UserPanel(600, 450);
      
      Container pane = arcade.getContentPane();
      pane.setLayout(new GridLayout(1, 1));
      pane.add(panel);

      arcade.pack();
      arcade.setVisible(true);
      panel.requestFocus();
   }
   

}
