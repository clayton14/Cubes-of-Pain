package Engine;

import Entities.EnemySquare;
import Entities.Player;
import sounds.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserPanel extends JPanel implements JavaArcade, KeyListener, ActionListener, Runnable {

private boolean isRunning = false;
int currentScore;
private int highScore;

//timers
private Timer timer;
private Timer enemyTimer;

//music
// needs to be run on separate thread
//wont render graphics if loop = true
//even if loop is not true the audio will still play before rendering graphics
//private MusicManager musicManager;

//Entities
private Player player;

private ArrayList<EnemySquare> enemySquare = new ArrayList<EnemySquare>();

 //EnemySquare enemySquare = new EnemySquare(100, 100, 10,80, Color.GREEN);

//resolution stuff
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
double w = screen.getWidth();
double h = screen.getHeight();

//rand spawn playe
//rand spawn Eneny

    public UserPanel() {
        int pRandx = (int) (Math.random() * (int) w) / 3;
        int pRandy = (int) (Math.random() * (int) h) / 3;

        currentScore = 0;

        setBackground(Color.black);
        enemySquare.add(0 , new EnemySquare(Color.GREEN, 20,20,20,20));
        enemySquare.get(0).setPanelWidth((int)w);
        enemySquare.get(0).bounce();


        player = new Player("default.png",pRandx,pRandy);
        player.setSpeed(10);
        timer = new Timer(30, this);
        enemyTimer = new Timer(30, this);


        timer.start();
        enemyTimer.start();

        //listeners
        addKeyListener(this);
        addMouseMotionListener(new PanelMotionListener()); //used to listen to mouse events
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }


    public void actionPerformed(ActionEvent e) {
        if(checkCollision()){
            isRunning = false;
        }

        repaint();
        //currentScore++;
       enemySquare.get(0).bounce();
    }

    //if player intersects enemy end game
    public boolean checkCollision() {
        Rectangle e = enemySquare.get(0).getBounds();
        Rectangle p = player.getBounds();
        return p.intersects(e);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
        enemySquare.get(0).draw(g);
    }


    // control player and actions w/ keyboard
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27)
            System.exit(0);

        if(isRunning) {
            switch (e.getKeyCode()) {

                case KeyEvent.VK_SPACE:
                    //shoot / attack
                    break;

                case KeyEvent.VK_W:
                    //move up
                    player.moveUp();
                    break;

                case KeyEvent.VK_S:
                    //move charter down
                    player.moveDown();
                    break;

                case KeyEvent.VK_D:
                    player.moveRight();
                    break;

                case KeyEvent.VK_A:
                    //move to left
                    player.moveLeft();
                    break;

                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
            }
        }
    }

    @Override
    public boolean running() {
        return isRunning;
    }
    @Override
    public void startGame() {
         isRunning = true;
         timer.start();

    }
    @Override
    public String getGameName() {
        return "Cubes-of-Pain";
    }
    @Override
    public void pauseGame() {
      isRunning = false;
    }
    @Override
    public String getInstructions() {
        return "movement: WASD\nAttack: space\nEsc: close game\nDOGE THE SQUARES";
    }
    @Override
    public String getCredits() {
        return "Graphics Designer: Clayton Easley\n" +
                "Music by: Clayton Easley\n" +
                "Dev: Clayton Easley";
    }
    @Override
    public String getHighScore() {
        if(currentScore > highScore){
            highScore = currentScore;
        }
            return highScore + "";
    }
    @Override
    public void stopGame() {
        isRunning = false;
        timer.stop();
        //clear enemies
        //reset random location
        player.setX((int) (Math.random() * (int) w) / 2);
        player.setY((int) (Math.random() * (int) h) / 2);
    }
    @Override
    public int getPoints() {
        return currentScore;
    }
    @Override
    public void setDisplay(GameStats d) {
        if(isRunning){
            d.update(getPoints());
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
    public void keyTyped(KeyEvent keyEvent) {}

    //thread for sound if needed
    @Override
    public void run() {

    }

//allows you to drag charter copied from example
    private class PanelMotionListener extends MouseMotionAdapter {//mouse dragged action that controls where slider is
        public void mouseDragged(MouseEvent e){
            if(isRunning){
                player.move2(e.getY(), player.getWidth());
               player.move1(e.getX(), player.getHeight());
            }
        }
    }

}
