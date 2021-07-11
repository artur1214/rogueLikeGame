package it.sevenbits.trex;

import javax.swing.JFrame;

import static it.sevenbits.trex.Main.terminal;

/**
 * Класс игрового окна
 */
public class  GameScreen extends JFrame {
    public GameScreen(final KeyReader control) {
        super();
        this.add(terminal);
        this.addKeyListener(control);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
