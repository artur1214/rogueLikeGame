package it.sevenbits.trex;

/**
 * Класс для обработки упрвления
 */

import static it.sevenbits.trex.Main.gameOver;

public class PlayerController {

    private Player player;
    private ObjectManager screenManager;

    public PlayerController(final Player player, final ObjectManager screenManager) {
        this.player = player;
        this.screenManager = screenManager;
    }

    public void movePlayer(final boolean up, final boolean left, final boolean down, final boolean right) {
        int x = player.getX();
        int y = player.getY();
        y = y - (up ? 1 : 0) + (down ? 1 : 0);
        x = x - (left ? 1 : 0) + (right ? 1 : 0);
        if (x < 0) {
            x = 0;
        }
        if (x >= screenManager.getWidth()) {
            x = screenManager.getWidth() - 1;
        }
        if (y < 0) {
            y = 0;
        }
        if (y >= screenManager.getHeight()) {
            y = screenManager.getHeight() - 1;
        }


        if (!screenManager.isObstacle(x, y)) {
            if (screenManager.isCoin(x, y)) {
                screenManager.scores += 1;
                screenManager.randomMoveObject(x, y);
            }
            else if (screenManager.isDoor(x, y)){
                gameOver = true;
            }
            player.setX(x);
            player.setY(y);
            screenManager.moves += 1;

        }

    }

}
