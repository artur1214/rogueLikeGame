package it.sevenbits.trex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Класс для обработки упрвления
 */

public class PlayerController implements KeyListener {
    private Player player;
    private boolean isUp = false;
    private boolean isDown = false;
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isExit = false;
    private ScreenManager screenManager;

    public PlayerController(Player player, ScreenManager screenManager){
        this.player = player;
        this.isUp = false;
        this.isDown = false;
        this.isLeft = false;
        this.isDown = false;
        this.isExit = false;
        this.screenManager = screenManager;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.isUp = true;
                break;
            case KeyEvent.VK_DOWN:
                this.isDown = true;
                break;
            case KeyEvent.VK_RIGHT:
                this.isRight = true;
                break;
            case KeyEvent.VK_LEFT:
                this.isLeft = true;
                break;
            case KeyEvent.VK_ESCAPE:
                this.isExit = true;
                break;
            default:
                break;
        }
        movePlayer();
    }

    private void movePlayer() {

        if(isDown && !screenManager.isObstacle(player.getX(), player.getY() + 1)){
            player.setY(player.getY()+1);
        }
        else if(isUp && !screenManager.isObstacle(player.getX(), player.getY() - 1)){
            player.setY(player.getY()-1);
        }
        else if(isLeft && !screenManager.isObstacle(player.getX()-1, player.getY())){
            player.setX(player.getX()-1);
        }
        else if(isRight && !screenManager.isObstacle(player.getX()+1, player.getY())){
            player.setX(player.getX()+1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isDown() {
        return isDown;
    }


    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void resetControl() {
        this.isUp = false;
        this.isDown = false;
        this.isLeft = false;
        this.isRight = false;
        this.isExit = false;
    }


    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }
}
