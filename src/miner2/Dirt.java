
package miner2;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Dirt extends Carre{
  
    public Dirt(Coords c){
        super(c);
        try{
            this.sprite = ImageIO.read(getClass().getResource("Ressources/spr_dirt.png"));
        } catch(IOException ex){
            System.out.println("erreur");
        }
    }  
}