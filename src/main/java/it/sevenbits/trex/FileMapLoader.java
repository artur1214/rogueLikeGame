package it.sevenbits.trex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMapLoader implements Loader {
    public ObjectManager getMap(String s) {
        try {

            File file = new File(s);

            Scanner scanner = new Scanner(file);
            ObjectManager manager = new ObjectManager();
            int width = 0;
            int height = 0;

            int curY = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int curX = 0;
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case ('@'):
                            manager.addObject(new Player(curX, height));
                            break;
                        case ('#'):
                            manager.addObject(new Obstacle(curX, height));
                            break;
                        case ('$'):
                            manager.addObject(new Coin(curX, height));
                    }
                    curX +=1;
                }
                if(width < curX){
                    width = curX;
                }
                height +=1;
            }
            manager.setWidth(width);
            manager.setHeight(height);
            return manager;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ObjectManager getMap() {
        return null;
    }
}
