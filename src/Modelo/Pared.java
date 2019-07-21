/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.image.Image;

/**
 *
 * @author usuario
 */
public class Pared extends Obstaculo{
    private int width;
    private int height;

    public Pared(int width, int height, int posX, int posY) {
        super(posX, posY);
        textura=new Image ("Imagenes/textura2.jpg");
        this.width = width;
        this.height = height;
        
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    
    
}
