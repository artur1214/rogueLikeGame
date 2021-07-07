package it.sevenbits.trex;

import static it.sevenbits.trex.Main.TERMINAL;

public class GameTile {
    /**
     * Константа, которая отвечает за символ игрока
     */
    public char symbol = ' ';

    protected int x;

    protected int y;

    /**
     * Конструктор класса GameTile
     *
     * @param x             - координаты по х
     * @param y             - координаты по у
     */


    GameTile(char symbol, final int x, final int y) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }


    private void render() {
        TERMINAL.write(symbol, x, y);
    }


    public void update() {
        render();
    }

    /**
     * Геттер для координаты x
     *
     * @return координату x
     */
    public int getX() {
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    /**
     * Геттер для координаты y
     *
     * @return координату y
     */
    public int getY() {
        return this.y;
    }

    public Coords getCoords(){
        return new Coords(this.x, this.y);
    }
}
