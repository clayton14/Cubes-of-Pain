/**
 * @(#)UserPanel.java
 * Simplified version of the SpaceInvaders UserPanel to show motion.
 * The two enemy objects move methods are called every 50 ms in response to a timer.
 * repaint() is called in response to that timer.  This call causes paintComponent to
 * be called.  paintComponent redraws the panel.
 *
 * The hero move method is called in response to the mouse events.
 * @author 
 * @version 1.00 2016/2/5
 */
package example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//UserPanel inherits from JPanel and uses the KeyListener and ActionListener interfaces


public class UserPanel extends JPanel implements KeyListener, ActionListener
{
   int points;
   private Hero myHero; //active Hero
   private javax.swing.Timer timer; //controls how often we updated the x, y pos of enemies and how often we repaint
   private javax.swing.Timer enemyTimer; //controls how often our points value change
   private Enemy enemyFast, enemySlow;  //two enemies: one will move fast, one slow
   private boolean start = false; 


   public UserPanel (int width, int height) {
    Color backColor=Color.black;
    int heroHeight, heroWidth, enemyWidth, enemyHeight, enemyX, enemyY;
    //Make hero proportional to height/width of panel.
    heroHeight = height / 22;  
    heroWidth = width / 27;
    
    enemySlow = new CircleEnemy(100, 20, 50, 50); //Parameters are xPos, yPos, width, height. Speed is defaulted to Circle speed of 3
    enemyFast = new ImageEnemy(100, 100, 50, 50); //Speed is set to 10 
    
    points = 0;
    
	  myHero = new Hero(10, height*4/5, heroWidth, heroHeight, Color.green);
	  myHero.activate();
    
  	  		  	     	         
      //Status check every 50 milliseconds
      timer = new javax.swing.Timer(50, this);
      //Timer invoked every 3 seconds, just a demo of using 2 timers - currently points value decrease
      enemyTimer = new javax.swing.Timer(3000, new EnemyAnimationListener());
     
      addKeyListener(this);//used for key controls
      addMouseMotionListener(new PanelMotionListener()); //used to listen to mouse events
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);      
      setBackground(backColor);
	  setPreferredSize(new Dimension(width, height));
   }

	  public void actionPerformed (ActionEvent e){ //invoked when timer expires every 5ms
   	  	  checkStats();
	    	  repaint(); //ensures PaintComponent is called
   	  }  
  
 
 //Because we implemented KeyListener interface, we must define these key methods
  public void keyTyped(KeyEvent e) { }
  public void keyReleased(KeyEvent e) { }
  public void keyPressed(KeyEvent e){
   
	    switch(e.getKeyCode())
	    {
	      case KeyEvent.VK_ENTER://actions performed if enter key is pressed
	      	timer.start();
	      	enemyTimer.start();
	      	
	      	start = true;
	      		
	      	break;
	      case KeyEvent.VK_SPACE://actions performed if enter key is pressed
	      	
	       
	      	
	      	break;   
        case KeyEvent.VK_LEFT://actions performed if enter key is pressed
	      	
	       myHero.moveLeft(); 
	      	//board.moveLeft();
	      	break;  
	       case KeyEvent.VK_RIGHT://actions performed if enter key is pressed
	      	
	       myHero.moveRight(); 
	      	
	      	break;  
     case KeyEvent.VK_UP://actions performed if enter key is pressed
	      	
	       myHero.moveNorth(); 
	      	
	      	break;  
	       case KeyEvent.VK_DOWN://actions performed if enter key is pressed
	      	
	       myHero.moveSouth(); 
	      	
	      	break;  

         case KeyEvent.VK_ESCAPE://actions performed if escape key is pressed
	        System.exit(0);
	       
	        break;
	      default:
	      	
       }
    
   
    }

   //draws everything
   public void paintComponent(Graphics g){
  
      super.paintComponent(g); //a call to JPanel's paintComponent	  		   
	    	
		  //Draw heroes
	    myHero.draw(g);
	 

		  //Draw enemies
	   enemyFast.draw(g);
	   enemySlow.draw(g);
	  
	   g.drawString("Points: " + points, 20, getHeight()-30);
	   
	  if(!start){//shows instructions in the beginning
	  	g.drawString("Instructions: Drag the ship with the mouse", (getWidth() /2) - 100, getHeight()/2 + 20);
	  	g.drawString("(Inactive) Press enter to shoot .", (getWidth() /2) - 100, getHeight()/2 + 40);
	  	g.drawString("You have 3 lives to kill the enemy", (getWidth() /2) - 100, getHeight()/2+ 60);
	  }

	  
  } 
	 

    
   
   //Invoked by EnemyTimer to show how you handle two timers. Need to create this private class
   //to implement another ActionListener
   private class EnemyAnimationListener implements ActionListener{
   
    //Because we are implementing ActionListener, we must define actionPerformed
   	  public void actionPerformed (ActionEvent e){
   	  	
   	 
   	  	points--; //Every 3 seconds, lose a point - motivate to win faster
   	  	
		   
   	  }
   }

   private class PanelMotionListener extends MouseMotionAdapter{//mouse dragged action that controls where slider is

      public void mouseDragged(MouseEvent e){
				/*if(start==true) //don't allow hero to move if not started            
         myHero.move(e.getX(), myHero.getWidth());*/
          //Component object1;
         if(start == true){
             myHero.move(e.getX(), myHero.getWidth());
         }
      }
   }
   
   private void checkStats(){ //called every 5ms, checks status of targets and hero
   
   //Set the width in case the panel gets resized.  All enemies share this value, therefore it is
   //static and its corresponding static method is called using the class name.
   
   	 Enemy.setPanelWidth(getWidth()); 
   	 enemyFast.move();
   	 enemySlow.move();
   }
	   	  
	   	  
	   	 
}
   
 
