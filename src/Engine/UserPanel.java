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
private int currentScore;
private int highScore;


//map fields idk will be implemented later
//private Wall wall;
//private Ground ground;

//timers
private Timer timer;
private Timer enemyTimer;

//music
// needs to be run on separate thread
//wont render graphics if loop = true
private MusicManager musicManager;

//Entities
private Player player;
//private ArrayList<EnemySquare> enemySquare = new ArrayList<EnemySquare>();

 EnemySquare enemySquare = new EnemySquare(100, 100, Color.GREEN);

//resolution stuff
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
double w = screen.getWidth();
double h = screen.getHeight();

//rand spawn player
private int pRandx = (int) (Math.random() * (int) w) / 3;
private int pRandy = (int) (Math.random() * (int) w) / 3;


//rand spawn Eneny

    public UserPanel() {
        setBackground(Color.BLACK);
        //player = new Player("default.png");

        player = new Player("default.png",pRandx,pRandy);
        player.setSpeed(10);
        timer = new Timer(30, this);
        enemyTimer = new Timer(30, this);
        timer.start();
        enemyTimer.start();
        addKeyListener(this);
        addMouseMotionListener(new PanelMotionListener()); //used to listen to mouse events
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

//        for (int i = 0; i < enemySquare.size(); i++) {
//            enemySquare.add(new EnemySquare());
//        }


    }


    public void actionPerformed(ActionEvent e) {
        repaint();
        checkCollision();
    }

    public void checkCollision(){
        //TODO - if player intersects enemy end game
        if(player.getBounds().intersects(enemySquare.getBounds())){
            isRunning = false;
        }
    }

    // control player and actions w/ keyboard
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }
            //regular movement
//        if(e.getKeyCode() == KeyEvent.VK_W){
//            player.moveUp();
//        } if(e.getKeyCode() == KeyEvent.VK_D){
//            player.moveRight();
//        } if(e.getKeyCode() == KeyEvent.VK_A){
//            player.moveLeft();
//        } if(e.getKeyCode() == KeyEvent.VK_S) {
//            player.moveDown();
//        }
         //diagonal
//        } if(e.getKeyCode() == KeyEvent.VK_W){
//            if(e.getKeyCode() == KeyEvent.VK_D) {
//                player.moveUp();
//                player.moveRight();
//            }
//        }if(e.getKeyCode() == KeyEvent.VK_W && e.getKeyCode() == KeyEvent.VK_A){
//            player.moveUp();
//            player.moveLeft();
//        }

        if(isRunning) {
            switch (e.getKeyCode()) {

//                case KeyEvent.VK_ENTER:
//
//                    isRunning = true;
//                    break;

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
        if(isRunning){
            timer.start();
            return true;
        }else {
            return false;
        }
    }
    @Override
    public void startGame() {
         isRunning = true;
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
        return "movement: WASD\nAttack: space\nEsc: close game";
    }
    @Override
    public String getCredits() {
        return "Graphics Designer: Clayton Easley\n" +
                "Music by: Clayton Easley\n" +
                "Dev: Clayton Easley";
    }
    @Override
    public String getHighScore() {
        return highScore + "";
    }
    @Override
    public void stopGame() {
        isRunning = false;

    }
    @Override
    public int getPoints() {
        return currentScore;
    }

    @Override
    public void setDisplay(GameStats d) {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
        enemySquare.draw(g);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
    public void keyTyped(KeyEvent keyEvent) {}
    //thread for sound if needed
    @Override
    public void run() {

    }
//allows you to drag charter
    private class PanelMotionListener extends MouseMotionAdapter {//mouse dragged action that controls where slider is

        public void mouseDragged(MouseEvent e){
				/*if(start==true) //don't allow hero to move if not started
         myHero.move(e.getX(), myHero.getWidth());*/
            //Component object1;
            if(isRunning == true){
                player.move2(e.getY(), player.getWidth());
               player.move1(e.getX(), player.getHeight());
            }
        }
    }

}
