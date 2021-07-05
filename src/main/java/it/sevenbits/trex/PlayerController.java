package it.sevenbits.trex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Класс для обработки упрвления
 */

public class PlayerController {

    private Player player;
    private ObjectManager screenManager;

    public PlayerController(Player player, ObjectManager screenManager){
        this.player = player;
        this.screenManager = screenManager;
    }

    public void movePlayer(boolean up, boolean left, boolean down, boolean right) {
        int x = player.getX();
        int y = player.getY();
        y = y - (up ? 1:0) + (down ? 1:0);
        x = x - (left ? 1:0) + (right ? 1:0);
        if(x < 0){
            x = 0;
        }
        if(x >= screenManager.getWidth()){
            x = screenManager.getWidth()-1;
        }
        if(y < 0){
            y = 0;
        }
        if (y >= screenManager.getHeight()){
            y = screenManager.getHeight()-1;
        }


        if (!screenManager.isObstacle(x, y)){
            if(screenManager.isCoin(x, y)){
                screenManager.scores += 1;
                screenManager.randomMoveObject(x, y);
            }
            player.setX(x);
            player.setY(y);
            screenManager.moves += 1;
        }

    }

}
