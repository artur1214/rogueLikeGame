package it.sevenbits.trex;

import asciiPanel.AsciiPanel;


/**
 * Главный класс, точка входа в игру
 */
public class Main {
    private static final int width = 80;
    private static final int height = 40;
    public static AsciiPanel TERMINAL;


    public static boolean GAME_OVER = false;

    /**
     * Старт нашего приложения
     *
     * @param args - аргументы командной строки
     */
    public static void main(final String[] args) {
        final long sleepTime = 40;
        final long beforeExitTime = 1500;
        ObjectManager objects = new FileMapLoader().getMap("map.txt");
        TERMINAL = new AsciiPanel(objects.getWidth(), objects.getHeight());
        Player player = objects.getPlayer();

        PlayerController playerController = new PlayerController(player, objects);
        KeyReader reader = new KeyReader(playerController);
        GameScreen screen = new GameScreen(reader);
        System.out.println(objects.getWidth() + " " + objects.getHeight());

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
            TERMINAL.write("Score:" + objects.scores, objects.getWidth()-11, 0);
            TERMINAL.write("Moves:" + objects.moves, objects.getWidth()-11, 1);
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
