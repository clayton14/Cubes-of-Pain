package Engine;

import Entities.Player;
import Map.Ground;
import Map.Wall;
import sounds.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

//resolution stuff
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
double w = screen.getWidth();
double h = screen.getHeight();

    public UserPanel() {
        setBackground(Color.BLACK);
        player = new Player("default.png");

        timer = new Timer(30, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void checkCollision(){
        //TODO - if player intersects enemy end game

    }

    // control player and actions w/ keyboard
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }

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
        return isRunning = true;
    }

    @Override
    public void startGame() {
        //TODO - initialise timer and Entities and the map
        if(isRunning){
           timer.start();
        }
    }


    @Override
    public String getGameName() {
        return "Game";
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
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
    public void keyTyped(KeyEvent keyEvent) {}


    //thread for sound if needed
    @Override
    public void run() {

    }
}
