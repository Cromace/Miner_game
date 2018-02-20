
package miner2;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Diamond extends Carre{

    public Diamond(Coords c) {
        super(c);
        try{
            this.sprite = ImageIO.read(getClass().getResource("Ressources/spr_diamond.png"));
        } catch(IOException ex){
            System.out.println("erreur");
        }
    }
}