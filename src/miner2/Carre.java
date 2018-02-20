
package miner2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Carre extends Component {
    public Coords coords;
    Image sprite;
    
    public Carre(Coords c){
        this.coords = c;
        try{
            this.sprite = ImageIO.read(getClass().getResource("Ressources/spr_rock.png"));
        } catch(IOException ex){
            System.out.println("erreur");
        }
    }

    @Override
    public void paint(Graphics g) {
        //Graphics2D g2d = (Graphics2D) g;

        int x = coords.getX();
        int y = coords.getY();
        int minerX = Mine.miner.coords.getX();
        int minerY = Mine.miner.coords.getY();
        g.drawImage(sprite, (x * Mine.BLOCK) + Mine.BLOCK, (y * Mine.BLOCK) + Mine.BLOCK , 50, 50, this);  
        if(!getClass().getName().equals("miner2.Miner")){
            if((x > minerX -2) && (x < minerX + 2) && (y > minerY - 2) && (y < minerY + 2) && (x == minerX || y == minerY)){
                g.setColor(new Color(0f, 0f, 0f, 0.5f));
                g.fillRect((x * Mine.BLOCK) + Mine.BLOCK, (y * Mine.BLOCK) + Mine.BLOCK , 50, 50);
            }else if((x > minerX -3) && (x < minerX + 3) && (y > minerY - 3) && (y < minerY + 3) && ((x > minerX -2 && x < minerX +2) || (y > minerY -2 && y < minerY +2))){
                g.setColor(new Color(0f, 0f, 0f, 0.75f));
                g.fillRect((x * Mine.BLOCK) + Mine.BLOCK, (y * Mine.BLOCK) + Mine.BLOCK , 50, 50);
            }else{
                g.setColor(new Color(0f, 0f, 0f, 1f));
                g.fillRect((x * Mine.BLOCK) + Mine.BLOCK, (y * Mine.BLOCK) + Mine.BLOCK , 50, 50);
            }
        }
    }
}

// && (x != minerX + 2 && y != minerY + 2)