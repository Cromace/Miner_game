
package miner2;

public class Start {
    
    public static void start(){
        Mine m = new Mine();
        InterfaceGraphique ig = new InterfaceGraphique(m);
        ig.revalidate();
        ig.setVisible(true);
    }
}
