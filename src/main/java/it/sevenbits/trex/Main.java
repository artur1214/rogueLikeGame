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
    private static int width = 80;
    private static int height = 40;
    public static final AsciiPanel TERMINAL = new AsciiPanel(width, height);
    public static boolean GAME_OVER = false;

    /**
     * Старт нашего приложения
     *
     * @param args - аргументы командной строки
     */
    public static void main(final String[] args) {
        final long sleepTime = 40;
        final long beforeExitTime = 1500;

        //ScreenManager objects = new ScreenManager();
        ObjectManager objects = new ObjectManager(width, height);
        Player player = new Player(5,5);
        PlayerController playerController = new PlayerController(player, objects);
        KeyReader reader = new KeyReader(playerController);
        GameScreen screen = new GameScreen(reader);
        objects.addObject(player);
        objects.addObject(new Obstacle(10, 10));
        objects.addObject(new Obstacle(10, 11));
        objects.addObject(new Obstacle(10, 12));
        objects.addObject(new Obstacle(10, 13));
        objects.addObject(new Obstacle(10, 14));
        objects.addObject(new Coin(20, 30));
        objects.addObject(new Coin(30, 20));




        while (true) {
            TERMINAL.clear();

            if (reader.isExit()) {
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
            reader.resetInput();
            TERMINAL.write("Score:" + String.valueOf(objects.scores), width-11, 0);
            TERMINAL.write("Moves:" + String.valueOf(objects.moves), width-11, 1);
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
