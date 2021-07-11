package it.sevenbits.trex;

import asciiPanel.AsciiPanel;


/**
 * Главный класс, точка входа в игру
 */
public class Main {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    public static AsciiPanel terminal;


    public static boolean gameOver = false;

    /**
     * Старт нашего приложения
     *
     * @param args - аргументы командной строки
     */
    public static void main(final String[] args) {
        final long sleepTime = 40;
        final long beforeExitTime = 10500;
        ObjectManager objects = new FileMapLoader().getMap("map.txt");
        terminal = new AsciiPanel(objects.getWidth(), objects.getHeight());
        Player player = objects.getPlayer();

        PlayerController playerController = new PlayerController(player, objects);
        KeyReader reader = new KeyReader(playerController);
        GameScreen screen = new GameScreen(reader);
        System.out.println(objects.getWidth() + " " + objects.getHeight());

        final int gameOverTextPosition = objects.getHeight() / 2 - 1;
        final int scoreTextPositionX = objects.getWidth() - 12;
        final int scoreTextPositionY = 0;
        final int movesTextPositionX = objects.getWidth() - 12;
        final int movesTextPositionY = 1;

        while (true) {
            terminal.clear();

            if (reader.isExit()) {
                break;
            }

            if (gameOver) {
                terminal.writeCenter("Game over!", gameOverTextPosition, AsciiPanel.brightBlue);
                terminal.writeCenter("Score: " + objects.scores, gameOverTextPosition + 1, AsciiPanel.brightBlue);
                terminal.writeCenter("Moves: " + objects.moves, gameOverTextPosition + 2, AsciiPanel.brightBlue);
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
            terminal.write("Score: " + objects.scores, scoreTextPositionX, scoreTextPositionY);
            terminal.write("Moves: " + objects.moves, movesTextPositionX, movesTextPositionY);
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
