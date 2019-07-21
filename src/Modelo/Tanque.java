/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 *
 * @author Miguel Rincon
 */
public class Tanque {
    private int x;
    private int y;
    private ArrayList<Bala>balas;
    private boolean mA;
    private boolean mAB;
    private boolean mI;
    private boolean mD;
    private boolean disparar;
    private double salud;
    private boolean fast;
    private boolean poder;
    private boolean doble;
    private boolean chorro;
    private double danio;
    private double saludmax;
    private boolean lento;
    private boolean atras;
    private boolean choquea;
    private boolean choqueab;
    private boolean choquei;
    private boolean choqued;

    public Tanque(int x, int y) {
    this.x=x;
    this.y=y;
    this.balas= new ArrayList<>();
    this.mA=true;
    this.mAB=false;
    this.mI=false;
    this.mD=false;
    this.disparar=true;
    this.fast=false;
    this.poder=false;
    this.doble=false;
    this.chorro=false;
    this.lento=false;
    this.atras=false;
    this.salud=100;
    this.danio=25;
    this.saludmax=100;
    this.choquea=false;
    this.choqueab=false;
    this.choqued=false;
    this.choquei=false;
    }

    public ArrayList<Bala> getBalas() {
        return balas;
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
 
public void moverArriba(){
    if (this.fast==true){
        this.y=y-3;
    }
    else if(this.lento==true){
        this.y=y-1;
        
    }else if(this.atras==true){
        this.y=y+2;
        
    }else{
    this.y=y-2;
    }
   this.mA=true;
    this.mAB=false;
    this.mI=false;
    this.mD=false;
}    
 public void moverAbajo(){
       if (this.fast==true){
        this.y=y+3;
    }else if(this.lento==true){
        this.y=y+1;
        
    }else if(this.atras==true){
        this.y=y-2;
        
    }else{
    this.y=y+2;
    }

   this.mA=false;
    this.mAB=true;
    this.mI=false;
    this.mD=false;
}
 public void moverIzquierda(){
     if (this.fast==true){
         this.x=x-3;
    }else if(this.lento==true){
        this.x=x-1;
        
    }else if(this.atras==true){
        this.x=x+2;
        
    }else{
     this.x=x-2;
    }

    this.mA=false;
    this.mAB=false;
    this.mI=true;
    this.mD=false;

}
 public void moverDerecha(){
     if (this.fast==true){
         this.x=x+3;
    }else if(this.lento==true){
        this.x=x+1;
        
    }else if(this.atras==true){
        this.x=x-2;
        
    }else{
     this.x=x+2;
    }
    this.mA=false;
    this.mAB=false;
    this.mI=false;
    this.mD=true;
}

    public boolean ismA() {
        return mA;
    }

    public void setmA(boolean mA) {
        this.mA = mA;
    }

    public boolean ismAB() {
        return mAB;
    }

    public void setmAB(boolean mAB) {
        this.mAB = mAB;
    }

    public boolean ismI() {
        return mI;
    }

    public void setmI(boolean mI) {
        this.mI = mI;
    }

    public boolean ismD() {
        return mD;
    }

    public void setmD(boolean mD) {
        this.mD = mD;
    }

    public boolean isDisparar() {
        return disparar;
    }

    public void setDisparar(boolean disparar) {
        this.disparar = disparar;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public boolean isFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public boolean isPoder() {
        return poder;
    }

    public void setPoder(boolean poder) {
        this.poder = poder;
    }

    public boolean isDoble() {
        return doble;
    }

    public void setDoble(boolean doble) {
        this.doble = doble;
    }

    public boolean isChorro() {
        return chorro;
    }

    public void setChorro(boolean chorro) {
        this.chorro = chorro;
    }

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }

    public double getSaludmax() {
        return saludmax;
    }

    public void setSaludmax(double saludmax) {
        this.saludmax = saludmax;
    }

    public boolean isLento() {
        return lento;
    }

    public void setLento(boolean lento) {
        this.lento = lento;
    }

    public boolean isAtras() {
        return atras;
    }

    public void setAtras(boolean atras) {
        this.atras = atras;
    }

    public boolean isChoquea() {
        return choquea;
    }

    public void setChoquea(boolean choquea) {
        this.choquea = choquea;
    }

    public boolean isChoqueab() {
        return choqueab;
    }

    public void setChoqueab(boolean choqueab) {
        this.choqueab = choqueab;
    }

    public boolean isChoquei() {
        return choquei;
    }

    public void setChoquei(boolean choquei) {
        this.choquei = choquei;
    }

    public boolean isChoqued() {
        return choqued;
    }

    public void setChoqued(boolean choqued) {
        this.choqued = choqued;
    }
    
}
