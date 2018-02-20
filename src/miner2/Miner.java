
package miner2;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Miner extends Carre{
    
    public Miner(Coords c) {
        super(c);
        try{
            this.sprite = ImageIO.read(getClass().getResource("Ressources/spr_miner.png"));
        } catch(IOException ex){
            System.out.println("erreur");
        }
    }

    void down() {
        coords.setY(coords.getY()+1);
    }

    void up() {
               coords.setY(coords.getY()-1);
    }

    void left() {
              coords.setX(coords.getX()-1);
    }

    void right() {
           coords.setX(coords.getX()+1);
    }
}