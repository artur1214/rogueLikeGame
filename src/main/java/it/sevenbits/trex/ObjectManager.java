package it.sevenbits.trex;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ObjectManager {
    public int scores = 0;
    public int moves = 0;
    private Map<Coords, GameTile> objects = new HashMap<>();

    private int width, height;

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public ObjectManager(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public ObjectManager(){}

    public void addObject(final GameTile tile) {
        this.objects.put(tile.getCoords(), tile);
    }

    public void removeObject(final int x, final int y) {
        objects.remove(new Coords(x, y));
    }

    public void updateAll() {
        ArrayList<GameTile> gameTiles = new ArrayList<>(objects.values());
        for (int i = 0; i < gameTiles.size(); i++) {

            gameTiles.get(i).update();
        }
    }

    public boolean isObstacle(final int x, final int y) {
        GameTile obj = objects.get(new Coords(x, y));
        if (obj != null) {
            if (obj.getX() == x && obj.getY() == y) {
                if (obj.getClass() == Obstacle.class) {
                    System.out.println("(" + x + ", " + y + ")" + "   " + "(" + obj.getX() + ", " + obj.getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCoin(final int x, final int y) {
        GameTile obj = objects.get(new Coords(x, y));
        if (obj != null) {
            if (obj.getX() == x && obj.getY() == y) {
                if (obj.getClass() == Coin.class) {
                    System.out.println("(" + x + ", " + y + ")" + "   " + "(" + obj.getX() + ", " + obj.getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public void randomMoveObject(final int x, final int y) {
        GameTile obj = objects.get(new Coords(x, y));
        obj.setX(ThreadLocalRandom.current().nextInt(0, width));
        obj.setY(ThreadLocalRandom.current().nextInt(2, height));
        Coords newCoords = new Coords(obj.getX(), obj.getY());

        objects.put(newCoords, obj);
        objects.remove(new Coords(x, y));
    }

    public Player getPlayer() {
        ArrayList<GameTile> gameTiles = new ArrayList<>(objects.values());
        for (int i = 0; i < gameTiles.size(); i++) {
            if (gameTiles.get(i).getClass() == Player.class) {
                return (Player) gameTiles.get(i);
            }
        }
        return null;
    }
    public boolean isDoor(final int x, final int y){
        GameTile obj = objects.get(new Coords(x, y));
        if (obj != null) {
            if (obj.getX() == x && obj.getY() == y) {
                if (obj.getClass() == Door.class) {
                    System.out.println("(" + x + ", " + y + ")" + "   " + "(" + obj.getX() + ", " + obj.getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }
}
