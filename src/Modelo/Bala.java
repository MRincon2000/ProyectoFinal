/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Miguel Rincon
 */
public class Bala {
    public int x;
    public int y;
    private boolean mA;
    private boolean mAB;
    private boolean mI;
    private boolean mD;
   
    
    
    public Bala(int x, int y,String g) {
        this.x = x;
        this.y = y;
        this.mA=false;
        this.mAB=false;
        this.mI=false;
        this.mD=false;
        if(g.equals("Arriba")){
            this.mA=true;
        }
        else if(g.equals("Abajo")){
            this.mAB=true;
        }
         else if(g.equals("Izquierda")){
            this.mI=true;
        }
        else if(g.equals("Derecha")){
            this.mD=true;
        }
  
    }

public void moverArriba(){
    this.y=y-5;
 
}    
 public void moverAbajo(){
    this.y=y+5;

}
 public void moverIzquierda(){
    this.x=x-5;

}
 public void moverDerecha(){
    this.x=x+5;

}

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

    public boolean ismA() {
        return mA;
    }

    public boolean ismAB() {
        return mAB;
    }

    public boolean ismI() {
        return mI;
    }

    public boolean ismD() {
        return mD;
    }
    
}
