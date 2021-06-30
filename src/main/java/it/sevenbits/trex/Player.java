package it.sevenbits.trex;

import static it.sevenbits.trex.Main.TERMINAL;


/**
 * Класс, описывающий модель Игрок
 */


public class Player extends GameTile{

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

    Player(int x, int y) {

        super('@', x, y);
    }
}