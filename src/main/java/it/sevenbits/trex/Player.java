package it.sevenbits.trex;


/**
 * Класс, описывающий модель Игрок
 */


public class Player extends GameTile {

    /**
     * Конструктор класса Player
     *
     * @param x - координаты по х
     * @param y - координаты по у
     *          // * @param groundY       - высота на которой находится земля для игрока
     *          // * @param maxJumpHeight - макисмальная высота прыжка
     *          //* @param maxSpeedY     - скорость взлета игрока после прыжка
     *          // * @param gravity       - гравитация
     */

    Player(final int x, final int y) {

        super('@', x, y);
    }
}
