package it.sevenbits.trex;

import asciiPanel.AsciiPanel;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static it.sevenbits.trex.Main.GAME_OVER;
import static it.sevenbits.trex.Main.TERMINAL;

/**
 * Главный класс, точка входа в игру
 */
public class Main {
    public static final AsciiPanel TERMINAL = new AsciiPanel();
    public static boolean GAME_OVER = false;

    /**
     * Старт нашего приложения
     *
     * @param args - аргументы командной строки
     */
    public static void main(final String[] args) {
        final int width = 80;
        final int groundY = 15;

        final long sleepTime = 40;
        final long beforeExitTime = 1500;

        ScreenManager objects = new ScreenManager();
        Player player = new Player(5,5);
        PlayerController playerController = new PlayerController(player, objects);
        objects.addObject(player);
        objects.addObject(new Obstacle(10, 10));
        objects.addObject(new Obstacle(10, 11));
        objects.addObject(new Obstacle(10, 12));
        objects.addObject(new Obstacle(10, 13));
        objects.addObject(new Obstacle(10, 14));
        GameScreen screen = new GameScreen(playerController);



        while (true) {
            TERMINAL.clear();

            if (playerController.isExit()) {
                break;
            }

            if (GAME_OVER) {
                TERMINAL.writeCenter("Game over!", 10, AsciiPanel.brightBlue);
                screen.repaint();
                try {
                    Thread.sleep(beforeExitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            objects.updateAll();
            playerController.resetControl();
            screen.repaint();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        screen.dispose();
    }
}
