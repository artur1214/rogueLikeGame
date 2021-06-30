package it.sevenbits.trex;

import javax.swing.*;

import static it.sevenbits.trex.Main.TERMINAL;

/**
 * Класс игрового окна
 */
public class  GameScreen extends JFrame {
    public GameScreen(PlayerController control) {
        super();
        this.add(TERMINAL);
        this.addKeyListener(control);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
