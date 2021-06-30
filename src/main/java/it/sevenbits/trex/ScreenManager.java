package it.sevenbits.trex;

import java.util.ArrayList;

public class ScreenManager {
    private ArrayList<GameTile> objects = new ArrayList<>();
    public ScreenManager(){

    }
    public void addObject(GameTile tile){
        this.objects.add(tile);
        //System.out.println(objects.get(objects.size()-1).getClass() == Obstacle.class);

    }
    public void removeObject(int x, int y){
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i).getX() == x && objects.get(i).getY() == y){
                objects.remove(i);
                break;
            }
        }
    }
    public void updateAll(){
        for(int i = 0; i < objects.size(); i++){
            objects.get(i).update();
        }
    }
    public boolean isObstacle(int x, int y){
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i).getX() == x && objects.get(i).getY() == y){
                if(objects.get(i).getClass() == Obstacle.class){
                    System.out.println("(" + x + ", "+ y + ")" + "   " + "(" + objects.get(i).getX() + ", "+ objects.get(i).getY() + ")");
                    return true;
                }
            }
        }
        return false;
    }
}
