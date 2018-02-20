
package miner2;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

public class Mine {
    static final short BLOCK= 50;
    static final short TAILLE = 15;
    static Miner miner;
    static Diamond diamond;
    static ArrayList<Trap> traps;
    Dirt d = new Dirt(new Coords(0,0));
 
    public ArrayList<Component> elements = new ArrayList(TAILLE * TAILLE);

    public static Coords getRandDiam() {
        int x = (int)   Math.floor(Math.random() * ((TAILLE) - 3)) + 3;
        int y = (int)   Math.floor(Math.random() * ((TAILLE) - 3)) + 3;
        return new Coords(x,y);
    }
    
    public static Coords getRandTrap() {
        int x = 0;
        int y = 0;
        while(x == 0 && y == 0){
            x = (int)   Math.floor(Math.random() * ((TAILLE) - 2)) + 2;
            y = (int)   Math.floor(Math.random() * ((TAILLE) - 2)) + 2;
            if(x != diamond.coords.getX() && y != diamond.coords.getY()){
                return new Coords(x,y);
            } else{
                x = 0;
                y = 0;
            }
        } 
        return null;
    }

    public Mine() {
        miner = new Miner(new Coords(0,0));
        diamond = new Diamond(getRandDiam());
        traps = new ArrayList();
        for(int i = 0 ; i < TAILLE * TAILLE ; i ++){
            elements.add(new Carre(new Coords(i)) ); 
        }
        elements.set(miner.coords.transpose(), miner);
        elements.set(diamond.coords.transpose(), diamond);
        for(int i = 0; i < TAILLE; i ++){
            traps.add(new Trap(getRandTrap()));
            elements.set(traps.get(i).coords.transpose(), traps.get(i));
        }
    }
    
    public Component get(int i) {
        return elements.get(i);
    }

    public Component set(int i, Component e) {
        return elements.set(i, e);
    }

    public Component get(int x, int y){
        return get(new Coords(x,y).transpose());
    }
    
    public Component set(int x, int y, Component e){
        return set(new Coords(x,y).transpose(), e);
    }
    
    public Component set(Coords c, Component e){
        return set(c.transpose(), e);
    }
}
