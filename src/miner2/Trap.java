
package miner2;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Trap extends Carre{
  
    public Trap(Coords c){
        super(c);
        try{
            this.sprite = ImageIO.read(getClass().getResource("Ressources/spr_trap.png"));
        } catch(IOException ex){
            System.out.println("erreur");
        }
    }  
}