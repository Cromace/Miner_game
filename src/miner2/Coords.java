
package miner2;

public class Coords {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int transpose(){
       return Mine.TAILLE*y + x;
    }

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coords(int index){
        this.x = index % Mine.TAILLE;
        this.y = (int) index / Mine.TAILLE;
    }
    
    public Coords clone(){
        return new Coords(x, y);
    }
    
    public boolean equals (Coords other){
        return ((x == other.x) && (y == other.y));
    }
}
