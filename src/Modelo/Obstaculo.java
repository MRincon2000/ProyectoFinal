/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 *
 * @author Profesor
 */
public class Obstaculo {

    protected int posX;
    protected int posY;
    protected Image textura;
    private boolean estado;
    public Obstaculo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.estado = true;
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public Image getTextura() {
        return textura;
    }

    public void setTextura(Image textura) {
        this.textura = textura;
    }
    
    }
    
