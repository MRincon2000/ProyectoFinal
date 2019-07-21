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
public class Cactus extends Obstaculo {
    private int radio;
    public Cactus(int posX, int posY,int radio) {
        super(posX, posY);
        textura=new Image("Imagenes/cactus.jpg");
        this.radio=radio;
    }

    public int getRadio() {
        return radio;
    }
    
}
