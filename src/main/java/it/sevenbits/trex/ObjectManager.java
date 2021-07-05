package it.sevenbits.trex;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ObjectManager {
    public int scores=0;
    public int moves = 0;
    private Map<List<Integer>, GameTile> objects = new HashMap<>();

    private int width, height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ObjectManager(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addObject(GameTile tile) {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(tile.getX());
        coords.add(tile.getY());
        this.objects.put(coords, tile);
        //System.out.println(objects.get(objects.size()-1).getClass() == Obstacle.class);
    }

    public void removeObject(int x, int y) {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        objects.remove(coords);
    }

    public void updateAll() {
        ArrayList<GameTile> gameTiles = new ArrayList<>(objects.values());
        for (int i = 0; i < gameTiles.size(); i++) {
            gameTiles.get(i).update();
        }
    }

    public boolean isObstacle(int x, int y) {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        GameTile obj = objects.get(coords);
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
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        GameTile obj = objects.get(coords);
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
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        GameTile obj = objects.get(coords);
        obj.setX(ThreadLocalRandom.current().nextInt(0, width));
        obj.setY(ThreadLocalRandom.current().nextInt(0, height));

        ArrayList<Integer> newCoords = new ArrayList<>();
        newCoords.add(obj.getX());
        newCoords.add(obj.getY());
        objects.put(newCoords, obj);
        objects.remove(coords);
    }
}
