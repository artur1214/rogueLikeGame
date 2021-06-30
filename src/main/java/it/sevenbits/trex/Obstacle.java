package it.sevenbits.trex;

public class Obstacle extends GameTile{
    /**
     * Конструктор класса GameTile
     *
     * @param x      - координаты по х
     * @param y      - координаты по у
     */
    Obstacle(int x, int y) {
        super('#', x, y);
    }
}
