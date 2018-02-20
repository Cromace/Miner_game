
package miner2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static miner2.Mine.traps;

public class InterfaceGraphique extends JFrame {
    private boolean drawBG = true;
    private boolean firstdraw = true;
    Mine mine;
    public final static short TAILLE= Mine.TAILLE;
    Coords was = new Coords(0, 0);
    
    public InterfaceGraphique(Mine m){
        this.mine = m;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(TAILLE*50 + 100, TAILLE*50 + 100);
        setLocationRelativeTo(null);
        initListeners();   
    }

    @Override
    public void paint(Graphics g) {
        if(drawBG){
            g.setColor(Color.black);
            g.fillRect(0, 0, this.getWidth(), this.getHeight()) ;
            drawBG= false;
        }
        if(firstdraw){
            for(Component e : mine.elements){
                e.paint(g);
            }
            firstdraw = false;
        }
        for(Component e : mine.elements){
           if((e.getX() > Mine.miner.getX() - 3) && (e.getX() < Mine.miner.getX() + 3) && (e.getY() > Mine.miner.getY() - 3) && (e.getY() < Mine.miner.getY() + 3)){
                e.paint(g);
            }
        } 
    }
    
    public void initListeners() {
        InterfaceGraphique self = this;

        addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                drawBG = true;// do stuff 
                firstdraw = true;
            }
            @Override
            public void componentMoved(ComponentEvent ce) {  
            }
            @Override
            public void componentShown(ComponentEvent ce) {
            }
            @Override
            public void componentHidden(ComponentEvent ce) {
            }
        });
         
        this.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(java.awt.event.KeyEvent evt) { 
                int keyCode = evt.getKeyCode();
                was = Mine.miner.coords.clone();
                switch( keyCode ) { 
                    case KeyEvent.VK_DOWN:
                        if(Mine.miner.coords.getY() >= Mine.TAILLE-1) return;
                        Mine.miner.down();
                    break;
                    case KeyEvent.VK_UP:
                        if(Mine.miner.coords.getY() <= 0) return;
                        Mine.miner.up();
                    break;
                    case KeyEvent.VK_LEFT:
                        if(Mine.miner.coords.getX()<= 0) return;
                        Mine.miner.left();
                    break;
                    case KeyEvent.VK_RIGHT:
                        if(Mine.miner.coords.getX() >= Mine.TAILLE-1) return;
                        Mine.miner.right();
                    break;
                }
                for (Trap trap : traps) {
                    if(Mine.miner.coords.equals(trap.coords)){
                        JOptionPane jop1 = new JOptionPane();
                        int option = JOptionPane.showConfirmDialog(null, "Try Again ?", "YOU LOSE !", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if(option == JOptionPane.OK_OPTION){
                            dispose();
                            Start.start();
                        }
                        if(option == JOptionPane.NO_OPTION){
                            dispose();
                        } 
                    }
                }
                mine.d = new Dirt(was);
                mine.set(was, mine.d);
                mine.set(mine.miner.coords, mine.miner);
                repaint();
                if(mine.miner.coords.equals(mine.diamond.coords)){
                    JOptionPane jop1 = new JOptionPane();
                    int option = jop1.showConfirmDialog(null, "Try Again ?", "YOU WIN!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if(option == JOptionPane.OK_OPTION){
                        dispose();
                        Start.start();
                    }
                    if(option == JOptionPane.NO_OPTION){
                        dispose();
                    }
                }
            }

            @Override
                public void keyTyped(KeyEvent ke) {
            }

            @Override
                public void keyReleased(KeyEvent ke) {
            
            }
        });
    }
}