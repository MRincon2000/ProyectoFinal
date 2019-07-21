/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import javafx.scene.image.Image;
/**
 *
 * @author rodri
 */
public class Puas extends Obstaculo {
    private int width;
    private int height;
    public Puas(int width, int height, int posX, int posY) {
        super(posX, posY);
        textura=new Image("Imagenes/cactus.jpg");
        this.height =height ; 
         this.width =width ; 
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

 
    
    
}

