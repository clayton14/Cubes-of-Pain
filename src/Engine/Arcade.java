package Engine;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class Arcade extends JFrame
{

//ok
  public Arcade()
  {

    super("AP Java Arcade");

    JavaArcade game = new UserPanel();

    GameStats display = new GameStats(game); //passing in a JavaArcade, therefore I know I can call getHighScore(), getScore()

		
    ControlPanel controls = new ControlPanel(game, display); //Also passing in JavaArcade to ControlPanel, I know you will respond to buttons
    
    game.setDisplay(display); //provides game ability to update display
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBorder(new EmptyBorder(0, 5, 0, 5));
    panel.add(display, BorderLayout.NORTH);
    panel.add((JPanel)game, BorderLayout.CENTER);
    panel.add(controls, BorderLayout.SOUTH);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);


  }

  public static void main(String[] args)
  {
    //fullscreen thing
    GraphicsEnvironment gE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gD = gE.getDefaultScreenDevice();

    Arcade window = new Arcade();
    //window.setBounds(0, 0, (int)w, (int)h);
    // window.setBounds(10, 10, 600, 600);
    gD.setFullScreenWindow(window);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

