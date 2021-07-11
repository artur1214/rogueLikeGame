package it.sevenbits.trex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static it.sevenbits.trex.Main.gameOver;

public class KeyReader implements KeyListener {

    private boolean isUp = false;
    private boolean isDown = false;
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isExit = false;
    private PlayerController controller;

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    public KeyReader(final PlayerController controller) {
        this.isUp = false;
        this.isDown = false;
        this.isLeft = false;
        this.isDown = false;
        this.isExit = false;
        this.controller = controller;
    }

    public void setController(PlayerController controller) {
        this.controller = controller;
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
            case KeyEvent.VK_ENTER:
                if (gameOver){
                    gameOver = false;
                }
            default:
                break;
        }
        controller.movePlayer(isUp, isLeft, isDown, isRight);
        //resetInput();
    }

    public void resetInput() {
        this.isUp = false;
        this.isDown = false;
        this.isLeft = false;
        this.isRight = false;
        this.isExit = false;
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }

    public boolean isExit() {
        return isExit;
    }
}
