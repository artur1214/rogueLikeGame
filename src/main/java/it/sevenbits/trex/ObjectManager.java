package it.sevenbits.trex;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ObjectManager {
    public int scores=0;
    public int moves = 0;
    private Map<Coords, GameTile> objects = new HashMap<>();

    private int width, height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public ObjectManager(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ObjectManager(){}

    public void addObject(GameTile tile) {
        this.objects.put(tile.getCoords(), tile);
    }

    public void removeObject(int x, int y) {
        objects.remove(new Coords(x,y));
    }

    public void updateAll() {
        ArrayList<GameTile> gameTiles = new ArrayList<>(objects.values());
        for (int i = 0; i < gameTiles.size(); i++) {

            gameTiles.get(i).update();
        }
    }

    public boolean isObstacle(int x, int y) {
        GameTile obj = objects.get(new Coords(x,y));
        if (obj !=null){
            if (obj.getX() == x && obj.getY() == y) {
                if (obj.getClass() == Obstacle.class) {
                    System.out.println("(" + x + ", " + y + ")" + "   " + "(" + obj.getX() + ", " + obj.getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCoin(int x, int y) {
        GameTile obj = objects.get(new Coords(x, y));
        if (obj !=null){
            if (obj.getX() == x && obj.getY() == y) {
                if (obj.getClass() == Coin.class) {
                    System.out.println("(" + x + ", " + y + ")" + "   " + "(" + obj.getX() + ", " + obj.getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public void randomMoveObject(int x, int y) {
        GameTile obj = objects.get(new Coords(x, y));
        obj.setX(ThreadLocalRandom.current().nextInt(0, width));
        obj.setY(ThreadLocalRandom.current().nextInt(0, height));
        Coords newCoords = new Coords(obj.getX(), obj.getY());

        objects.put(newCoords, obj);
        objects.remove(new Coords(x, y));
    }

    public Player getPlayer(){
        ArrayList<GameTile> gameTiles = new ArrayList<>(objects.values());
        for (int i = 0; i < gameTiles.size(); i++) {
            if(gameTiles.get(i).getClass() == Player.class){
                return (Player) gameTiles.get(i);
            }
        }
        return null;
    }
}
