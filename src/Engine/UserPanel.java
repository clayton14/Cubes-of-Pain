package Engine;

import Entities.EnemySquare;
import Entities.Player;
import sounds.MusicManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserPanel extends JPanel implements JavaArcade, KeyListener, ActionListener {

private boolean isRunning = false;

int points;
int highScore;
int numOfEntities;

//Threads
private Thread enemyThread;
private Thread soundThread;

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

//list of enemies
private ArrayList<EnemySquare> enemySquare = new ArrayList<EnemySquare>();


//resolution stuff
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
double ScreenWith = screen.getWidth();
double ScreenHeight = screen.getHeight();

//rand spawn player
//rand spawn Enemy

    public UserPanel() {
        //random spawn point for Player (Player random x and Enemy Player y)\
        int pRandx = (int) (Math.random() * (int) ScreenWith) / 3;
        int pRandy = (int) (Math.random() * (int) ScreenHeight) / 3;

        points = 0;
        setBackground(Color.black);
        //enemySquare.add(0 , new EnemySquare(Color.GREEN, 20,20,20,20));
        //enemySquare.get(0).setPanelWidth((int)ScreenWith);
        //enemySquare.get(0).bounce();

        player = new Player("default.png",pRandx,pRandy);

        player.setSpeed(25);
        timer = new Timer(30, this);


        enemyTimer = new Timer(30, new EnemyAnimationListener());

       // spawnEnemy(isRunning);
        timer.start();
        enemyTimer.start();

        //listeners
        addKeyListener(this);
        addMouseMotionListener(new PanelMotionListener()); //used to listen to mouse events
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }


    public void spawnEnemy(boolean flag){

        //TODO spawn new enemy based off score with random spawn

        //random spawn point for Enemy (Enemy random x and Enemy random y)
        int eRandx = (int) (Math.random() * (int) ScreenWith) ;
        int eRandy = (int) (Math.random() * (int) ScreenHeight);

           if(flag) {
               if (points % 100 == 0) {
                   enemySquare.add(new EnemySquare(Color.GREEN,eRandx,eRandy,20,20));
                   numOfEntities++;
               }
           }

        }


    public void actionPerformed(ActionEvent e) {
        if(checkCollision()){
            isRunning = false;
        }
        spawnEnemy(isRunning);
        repaint();
        points++;
    }


    //if player intersects enemy end game
    public boolean checkCollision() {
        Rectangle e = new Rectangle();
        for (int i = 0; i < numOfEntities; i++) {
           e = enemySquare.get(i).getBounds();
        }
        Rectangle p = player.getBounds();
        return p.intersects(e);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);

        for (int i = 0; i < numOfEntities; i++) {
            enemySquare.get(i).draw(g);
        }
        //getPoints();
        screenBounds();
    }


    public void screenBounds(){
        if(player.getX() > (int)ScreenWith){
            player.setX(((int)ScreenWith));
        }else if(player.getX() < 0){
            player.setX(0);

        }else if(player.getY() > (int)ScreenWith){
            player.setY((int)ScreenWith);
        }else if(player.getY() < 0){
            player.setY(0);
            //-200 because of menu
        }else if(player.getY() > ((int) ScreenHeight -200)){
            player.setY(((int)ScreenHeight -200));
        }

    }

    //interface stuff

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
         enemyTimer.start();
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
        if(points > highScore){
            highScore = points;
        }
            return highScore + "";
    }
    @Override
    public void stopGame() {
        isRunning = false;
        timer.stop();
        enemyTimer.stop();
        points = 0;
        //clear enemies
         enemySquare.clear();
         numOfEntities=0;
        //reset random location
        player.setX((int) (Math.random() * (int) ScreenWith / 3));
        player.setY((int) (Math.random() * (int) ScreenHeight) / 3);
    }
    @Override
    public int getPoints() {
        return points;
    }
    @Override
    public void setDisplay(GameStats d) {
        d.update(getPoints());

    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {}
    public void keyTyped(KeyEvent keyEvent) {}



    //thread for sound if needed





//allows you to drag charter copied from example
private class PanelMotionListener extends MouseMotionAdapter {//mouse dragged action that controls where slider is
    public void mouseDragged(MouseEvent e){
        if(isRunning){
            player.move2(e.getY(), player.getWidth());
           player.move1(e.getX(), player.getHeight());
        }
    }
}

//listener for enemy
private class EnemyAnimationListener implements ActionListener{

    //Because we are implementing ActionListener, we must define actionPerformed
    public void actionPerformed (ActionEvent e){
        if (isRunning) {
            for (int i = 0; i < numOfEntities ; i++) {
                enemySquare.get(i).bounce();
            }
            points++;
        }
    }
}


}
