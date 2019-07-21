/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Control.Controlador3;
import Modelo.Bala;
import Modelo.Boost;
import Modelo.Cactus;
import Modelo.Obstaculo;
import Modelo.Pared;
import Modelo.Tanque;
import Modelo.Tanquemovimiento;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.text.Font;

/**
 *
 * @author usuario
 */
public class Escena3 extends AnimationTimer implements Vista  {
private Pane panel;
private Canvas tablero;
private GraphicsContext lapiz;
private Scene escena;
private Image suelo=new Image ("Imagenes/suelo_guerra.jpg");
private Obstaculo [] obstaculos;
private Tanque tanque;
private Tanque tanque2;
private Image anim;
private Image anim2;
private ArrayList<String>pulsacionteclado= null;
private int numerot2=0;
private int numerot1=0;
private int numeroP1=0;
private int numeroP2=0;
private ArrayList<Boost> poder;
private Image caja;
private Controlador3 controlador;
private boolean finish;
private int ganador;
private int p1;
private int p2;





public Escena3(Controlador3 c, int p1, int p2) {
    this.p1=p1;
    this.p2=p2;
    this.controlador=c;
    this.finish=false;
     this.ganador=0;
    this.panel = new Pane();
    this.tablero = new Canvas(755,580);
    panel.getChildren().add(tablero);
    this.lapiz = 
              tablero.getGraphicsContext2D();
    this.escena=new Scene(panel,755,580);
   
 Boost m= new Boost(200,200);
    Boost w= new Boost(400,400);
  this.poder= new ArrayList<>();
    this.poder.add(m);
    this.poder.add(w);
    this.lapiz=tablero.getGraphicsContext2D(); 
    lapiz.setFill(Color.ORANGE);
    this.tanque= new Tanque(50,50);
    this.anim= new Image("Imagenes/na.png");
 this.tanque2= new Tanque(650,430);
 this.anim2= new Image("Imagenes/va.png");
    pulsacionteclado= new ArrayList<>();

    escena.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionteclado.contains(code) )
                        pulsacionteclado.add( code );
                }
            });

        escena.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionteclado.remove( code );
                }
            });  

this.obstaculos=new Obstaculo[16];
    obstaculos[0]=new Pared (80,25,0,170);
    obstaculos[1]=new Pared (150,25,0,350);
    obstaculos[2]=new Pared (25,195,170,0);
    obstaculos[3]=new Pared (25,500,280,250);
    obstaculos[4]=new Pared (25,350,450,0);
    obstaculos[5]=new Pared (80,25,675,375);
    obstaculos[6]=new Pared (150,25,605,250);
    obstaculos[7]=new Pared (25,250,560,375);
    obstaculos[8]=new Cactus (600,100,30);
    obstaculos[9]=new Cactus(320,490,30);
    obstaculos[10]=new Cactus (90,460,30);
    obstaculos[11]=new Cactus (375,30,30);
    obstaculos[12]=new Pared(20,560, 0, 0);
    obstaculos[13]=new Pared(735,20,0,0);
    obstaculos[14]=new Pared (20,580,735,0);
    obstaculos[15]=new Pared (755,20,0,560);
 this.caja= new Image("Imagenes/caja.jpeg");

}



    @Override
    public void handle(long now) {
    
            if(finish==true){
                try {
                    //Tanquemovimiento.esperar(2);
                    controlador.handle();
                } catch (FileNotFoundException ex) {
                    System.out.println("Fallo en el sistema de puntajes");
                    System.exit(1);
                }
    }
        else{ lapiz.clearRect(0, 0, 755, 580);




    
     lapiz.drawImage(suelo, 0, 0);
    lapiz.setFill(Color.BLACK);
    
     for(Obstaculo obstaculo:this.obstaculos){
        if(obstaculo instanceof Pared){
        lapiz.setFill(new ImagePattern (obstaculo.getTextura()));
        lapiz.fillRect(obstaculo.getPosX(),obstaculo.getPosY(),((Pared) obstaculo).getWidth(), ((Pared) obstaculo).getHeight());
    }if(obstaculo instanceof Cactus){
        lapiz.setFill(new ImagePattern(obstaculo.getTextura()));
        lapiz.fillOval(obstaculo.getPosX(),obstaculo.getPosY(),((Cactus) obstaculo).getRadio(),((Cactus) obstaculo).getRadio());   
    } 
    
    }
    
    if(numeroP1%600==0){
           tanque.setChorro(false);
           tanque.setDoble(false);
           tanque.setPoder(false);
           tanque.setFast(false);
           tanque.setLento(false);
           tanque.setAtras(false);
           tanque.setDanio(25);
       }
   
                    
    
    
    
    
    
              if(numeroP2%600==0){
           tanque2.setChorro(false);
           tanque2.setDoble(false);
           tanque2.setPoder(false);
           tanque2.setFast(false);
           tanque2.setLento(false);
           tanque2.setAtras(false);
           tanque2.setDanio(25);
       } 
  lapiz.setFill(Color.BLACK);
                lapiz.setFont(Font.font("Old English Text MT", 20));
    if (tanque.isFast()){
    lapiz.fillText("Velocidad", 50, 550);
    }
    if(tanque.isChorro()){
        lapiz.fillText("Metralleta", 50, 550);
    }
    if(tanque.isAtras()){
            lapiz.fillText("Al Reves", 50, 550);
        }
    if(tanque.isLento()){
        lapiz.fillText("Lento", 50, 550);
    }
    if(tanque.isDoble()){
        lapiz.fillText("Municion x2", 50, 550);
    }
    if(tanque.getDanio()==50){
        lapiz.fillText("Misil", 50, 550);
    }
    lapiz.setFill(Color.BLACK);
    lapiz.setFont(Font.font("Old English Text MT", 20));
   
                
                
                if (tanque2.isFast()){
    lapiz.fillText("Velocidad", 500, 550);
    }
    if(tanque2.isChorro()){
        lapiz.fillText("Metralleta", 500, 550);
    }
    if(tanque2.isAtras()){
            lapiz.fillText("Al Reves", 500, 550);
        }
    if(tanque2.isLento()){
        lapiz.fillText("Lento", 500, 550);
    }
    if(tanque2.isDoble()){
        lapiz.fillText("Municion x2", 500, 550);
    }
    if(tanque2.getDanio()==50){
        lapiz.fillText("Misil", 500, 550);
    }
    
lapiz.setFont(Font.font("Old English Text MT", 30));
if(this.p1==0){
   lapiz.fillText("0", 30,550); 
}
if(this.p1==1){
   lapiz.fillText("1", 30,550); 
}
if(this.p1==2){
   lapiz.fillText("2", 30,550); 
}
if(this.p1==3){
   lapiz.fillText("3", 30,550); 
}
if(this.p1==4){
   lapiz.fillText("4", 30,550); 
}
if(this.p2==0){
   lapiz.fillText("0", 480,550); 
}
if(this.p2==1){
   lapiz.fillText("1", 480,550); 
}
if(this.p2==2){
   lapiz.fillText("2", 480,550); 
}
if(this.p2==3){
   lapiz.fillText("3", 480,550); 
}
if(this.p2==4){
   lapiz.fillText("4", 480,550); 
}



    
        
        
        
        if (tanque.isChorro()){
            if(numerot1%10==0){
                 tanque.setDisparar(true);
            }
        }
        else{
        if (numerot1%40==0){
            tanque.setDisparar(true);
       
        }
        }
       
        
        
        if (tanque2.isChorro()){
           
            if (numerot2%10==0){
            tanque2.setDisparar(true);
       
        }
        }else{
        
       if (numerot2%40==0){
            tanque2.setDisparar(true);
       
        }
        }
       
        Shape p1= new Rectangle(tanque.getX(),tanque.getY(),30,30);
        Shape p2= new Rectangle(tanque2.getX(),tanque2.getY(),30,30);
        
           tanque.setChoquea(false);
           tanque.setChoqueab(false);
           tanque.setChoqued(false);
           tanque.setChoquei(false);
           tanque2.setChoquea(false);
           tanque2.setChoqueab(false);
           tanque2.setChoqued(false);
           tanque2.setChoquei(false);
       
           for(int z=0;z<this.obstaculos.length;z++){
      
       if(this.obstaculos[z] instanceof Pared){
               Pared p=(Pared)this.obstaculos[z];
        
        Shape par= new Rectangle(p.getPosX(),p.getPosY(),p.getWidth(),p.getHeight());
        Shape interg1= SVGPath.intersect(par, p1);
 
        if(interg1.getLayoutBounds().getWidth()!=-1 && tanque.ismA()){
            tanque.moverAbajo();
            tanque.setChoquea(true);
            tanque.setmAB(false);
            tanque.setmA(true);
            break;
        }
        else if(interg1.getLayoutBounds().getWidth()!=-1 && tanque.ismAB()){
            tanque.moverArriba();
            tanque.setChoqueab(true);
            tanque.setmA(false);
            tanque.setmAB(true);
            break;
        }
        else if(interg1.getLayoutBounds().getWidth()!=-1 && tanque.ismI()){
            tanque.moverDerecha();
            tanque.setChoquei(true);
            tanque.setmD(false);
            tanque.setmI(true);
            break;
        }
        else if(interg1.getLayoutBounds().getWidth()!=-1 && tanque.ismD()){
            tanque.moverIzquierda();
            tanque.setChoqued(true);
            tanque.setmI(false);
            tanque.setmD(true);
            break;
        }}}
        for(int u=0;u<this.obstaculos.length;u++){
            
            
            if(this.obstaculos[u] instanceof Pared){
                 Pared p=(Pared)this.obstaculos[u];
        
        Shape par= new Rectangle(p.getPosX(),p.getPosY(),p.getWidth(),p.getHeight());
        Shape interg2= SVGPath.intersect(par, p2);
                
                
        if(interg2.getLayoutBounds().getWidth()!=-1 && tanque2.ismA()){
            tanque2.moverAbajo();
            tanque2.setChoquea(true);
            tanque2.setmAB(false);
            tanque2.setmA(true);
            break;
        }
        else if(interg2.getLayoutBounds().getWidth()!=-1 && tanque2.ismAB()){
            tanque2.moverArriba();
            tanque2.setChoqueab(true);
            tanque2.setmA(false);
            tanque2.setmAB(true);

            break;
        }
        else if(interg2.getLayoutBounds().getWidth()!=-1 && tanque2.ismI()){
            tanque2.moverDerecha();
            tanque2.setChoquei(true);
            tanque2.setmD(false);
            tanque2.setmI(true);
            break;
        }
        else if(interg2.getLayoutBounds().getWidth()!=-1 && tanque2.ismD()){
            tanque2.moverIzquierda();
            tanque2.setChoqued(true);
            tanque2.setmI(false);
            tanque2.setmD(true);
            break;
        }
    }
           } 
        
        

                if (pulsacionteclado.contains("LEFT")&& !tanque.isChoquei()){
                   this.anim=new Image("imagenes/ni.png");
                    tanque.moverIzquierda();
               
                }
                  
                else if (pulsacionteclado.contains("RIGHT")&& !tanque.isChoqued()){
                   this.anim=new Image("imagenes/nd.png");
                    tanque.moverDerecha();
               
                }
                    
                else if (pulsacionteclado.contains("UP")&& !tanque.isChoquea())
                { 
                    this.anim=new Image("imagenes/na.png");
                    tanque.moverArriba();
             
                }
                else if (pulsacionteclado.contains("DOWN")&& !tanque.isChoqueab())
                {
                    this.anim=new Image("imagenes/nab.png");
                  tanque.moverAbajo(); 
               
                }
               
                if(tanque.isDoble()){
                 if (tanque.ismA()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar() ){
                    Bala b= new Bala(tanque.getX()+22,tanque.getY(),"Arriba");
                    Bala b2= new Bala(tanque.getX()+2, tanque.getY(), "Arriba");
                  tanque.getBalas().add(b);
                  tanque.getBalas().add(b2);
                  tanque.setDisparar(false);
                }    
                if (tanque.ismAB()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX()+22,tanque.getY()+30,"Abajo");
                    Bala b2= new Bala(tanque.getX()+2, tanque.getY()+30, "Abajo");
                  tanque.getBalas().add(b);
                  tanque.getBalas().add(b2);
                  tanque.setDisparar(false);
                } 
                if (tanque.ismI()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX(),tanque.getY()+22,"Izquierda");
                    Bala b2= new Bala(tanque.getX(), tanque.getY()+2, "Izquierda");
                  tanque.getBalas().add(b);
                  tanque.getBalas().add(b2);
                  tanque.setDisparar(false);
                } 
                if (tanque.ismD()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX()+30,tanque.getY()+22,"Derecha");
                    Bala b2= new Bala(tanque.getX()+30, tanque.getY()+2, "Derecha");
                  tanque.getBalas().add(b);
                  tanque.getBalas().add(b2);
                  tanque.setDisparar(false);
                }     
                }else{
                
                if (tanque.ismA()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar() ){
                    Bala b= new Bala(tanque.getX()+12,tanque.getY(),"Arriba");
                  tanque.getBalas().add(b);
                  tanque.setDisparar(false);
                }    
                if (tanque.ismAB()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX()+12,tanque.getY()+30,"Abajo");
                  tanque.getBalas().add(b);
                  tanque.setDisparar(false);
                } 
                if (tanque.ismI()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX(),tanque.getY()+12,"Izquierda");
                  tanque.getBalas().add(b);
                  tanque.setDisparar(false);
                } 
                if (tanque.ismD()&& pulsacionteclado.contains("ENTER")&& tanque.isDisparar()){
                    Bala b= new Bala(tanque.getX()+30,tanque.getY()+12,"Derecha");
                  tanque.getBalas().add(b);
                  tanque.setDisparar(false);
                }  
                }
                
                
               
                
                
                
                
                
                
                if (pulsacionteclado.contains("A")){
                   this.anim2=new Image("imagenes/vi.png");
                    tanque2.moverIzquierda();
                     
                }
                  
                else if (pulsacionteclado.contains("D")){
                   this.anim2=new Image("imagenes/vd.png");
                    tanque2.moverDerecha();
               
                }
                    
                else if (pulsacionteclado.contains("W"))
                { 
                    this.anim2=new Image("imagenes/va.png");
                    tanque2.moverArriba();
             
                }
                else if (pulsacionteclado.contains("S"))
                {
                    this.anim2=new Image("imagenes/vab.png");
                    tanque2.moverAbajo(); 
             
                }    
                if(tanque2.isDoble()){
                    if (tanque2.ismA() && pulsacionteclado.contains("SPACE") && tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX()+22,tanque2.getY(),"Arriba");
                    Bala b2= new Bala(tanque2.getX()+2, tanque2.getY(), "Arriba");
                  
                    
                    tanque2.getBalas().add(b);
                  tanque2.getBalas().add(b2);
                  
                  tanque2.setDisparar(false);

                }    
                if (tanque2.ismAB()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX()+22,tanque2.getY()+30,"Abajo");
                    Bala b2= new Bala(tanque2.getX()+2, tanque2.getY()+30, "Abajo");
                  tanque2.getBalas().add(b);
                  tanque2.getBalas().add(b2);
                  tanque2.setDisparar(false);
                } 
                if (tanque2.ismI()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX(),tanque2.getY()+22,"Izquierda");
                    Bala b2= new Bala(tanque2.getX(), tanque2.getY()+2, "Izquierda");
                  tanque2.getBalas().add(b);
                  tanque2.getBalas().add(b2);
                  tanque2.setDisparar(false);
                } 
                if (tanque2.ismD()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX()+30,tanque2.getY()+22,"Derecha");
                    Bala b2= new Bala(tanque2.getX()+30, tanque2.getY()+2, "Derecha");
                  tanque2.getBalas().add(b);
                  tanque2.getBalas().add(b2);
                  tanque2.setDisparar(false);
                } 
                }else{
                if (tanque2.ismA()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar() ){
                    Bala b= new Bala(tanque2.getX()+12,tanque2.getY(),"Arriba");
                  tanque2.getBalas().add(b);
                  tanque2.setDisparar(false);
                  
                }    
                if (tanque2.ismAB()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX()+12,tanque2.getY()+30,"Abajo");
                  tanque2.getBalas().add(b);
                  tanque2.setDisparar(false);

                } 
                if (tanque2.ismI()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX(),tanque2.getY()+12,"Izquierda");
                  tanque2.getBalas().add(b);
                  tanque2.setDisparar(false);

                } 
                if (tanque2.ismD()&& pulsacionteclado.contains("SPACE")&& tanque2.isDisparar()){
                    Bala b= new Bala(tanque2.getX()+30,tanque2.getY()+12,"Derecha");
                  tanque2.getBalas().add(b);
                  tanque2.setDisparar(false);

                } 
                }
                Shape s1= new Rectangle(tanque.getX(),tanque.getY(),30,30); 
                Shape s2= new Rectangle(tanque2.getX(),tanque2.getY(),30,30); 
                
                lapiz.setFill(Color.BLUE);
                for (int t=0; t<this.poder.size();t++){
                    
                   
                    lapiz.drawImage(caja,this.poder.get(t).getX(),this.poder.get(t).getY() ,20 , 20);
                    Shape boo=new Rectangle(this.poder.get(t).getX(),this.poder.get(t).getY() ,20 , 20);
                
                    

                    
                    Shape interp1= SVGPath.intersect(boo, s1);
                    
                    Shape interp2= SVGPath.intersect(boo, s2);
                
                    
                    
                    

                
                if(interp1.getLayoutBounds().getWidth()!= -1&& !tanque.isPoder()){
                     this.poder.remove(t);
                    tanque.setPoder(true);
                int numeroR =(int) (Math.random() * 8) + 1;   
                    System.out.println(numeroR);
                switch(numeroR){
                    
                    case 1:
                        tanque.setFast(true);

                        break;
                    case 2:
                        tanque.setDoble(true);

                        break;
                    case 3:
                        tanque.setChorro(true);
                        break;
                    case 4:
                       tanque.setSalud(200);
                       tanque.setSaludmax(200);
                       break;
                    case 5:
                        tanque.setDanio(50);
                        break;
                    case 6:
                        tanque.setSalud(tanque.getSalud()/2);
                        break;
                    case 7:
                      tanque.setLento(true);
                      break;
                    case 8:
                       tanque.setAtras(true);
                       break;
                        
                }
                   


                }
                if(interp2.getLayoutBounds().getWidth()!= -1 && !tanque2.isPoder()){
                    this.poder.remove(t);
                    tanque2.setPoder(true);
                    int numeroS =(int) (Math.random() * 8) + 1;   
                    System.out.println(numeroS);
                switch(numeroS){
                    
                    case 1:
                        tanque2.setFast(true);  
                        break;
                    case 2:
                        tanque2.setDoble(true);
                        break;
                    case 3:
                        tanque2.setChorro(true);
                        break;
                    case 4:
                        tanque2.setSalud(200);
                        tanque2.setSaludmax(200);
                        break;
                    case 5:
                        tanque2.setDanio(50);
                        break;
                    case 6:
                        tanque2.setSalud(tanque2.getSalud()/2);
                        break;
                    case 7:
                        tanque2.setLento(true);
                        break;
                        case 8:
                       tanque2.setAtras(true);
                       break;
                }
                
                
                
                
                
                }
                }
                
                
                

    
                
                
                
                 for (int s=0;s<tanque.getBalas().size();s++){
                   
                     boolean k=false;
                    Shape b1= new Rectangle(tanque.getBalas().get(s).getX(),tanque.getBalas().get(s).getY(),15,15);
                    Shape inter= SVGPath.intersect(b1, s2);
                    
                    Image bala= new Image("Imagenes/bala.png");
                    lapiz.drawImage(bala, tanque.getBalas().get(s).getX(),tanque.getBalas().get(s).getY(),7,7);
                
                    for(int w=0; w< this.obstaculos.length;w++){
                        if(this.obstaculos[w] instanceof Pared ){
                        Pared p= (Pared)this.obstaculos[w];    
                        Shape o= new Rectangle(p.getPosX(),p.getPosY(),p.getWidth(),p.getHeight());
                        Shape intero=SVGPath.intersect(o, b1);
                        if(intero.getLayoutBounds().getWidth()!= -1){
                            tanque.getBalas().remove(s);
                            k=true;
                            break;
                        }
                    }
                    }
                    
                    
                    if(!k){
                    if(tanque.getBalas().get(s).ismA())
                    tanque.getBalas().get(s).moverArriba();
                 if(tanque.getBalas().get(s).ismAB())
                    tanque.getBalas().get(s).moverAbajo();  
                 if(tanque.getBalas().get(s).ismI())
                    tanque.getBalas().get(s).moverIzquierda();
                 if(tanque.getBalas().get(s).ismD())
                    tanque.getBalas().get(s).moverDerecha();
                  if(tanque.getBalas().get(s).getX()>754||tanque.getBalas().get(s).getX()<1||tanque.getBalas().get(s).getY()>579||tanque.getBalas().get(s).getY()<1){
                        tanque.getBalas().remove(s);
                    }
                if(inter.getLayoutBounds().getWidth()!= -1){

                        tanque2.setSalud(tanque2.getSalud()-tanque.getDanio());
                        System.out.println(tanque2.getSalud());
                tanque.getBalas().remove(s);
                }
                
                    }
                } 
                
                
                
                
                
                
                
                for (int i=0;i<tanque2.getBalas().size();i++){
                   
                    boolean n=false;
                 
                    Shape b1= new Rectangle(tanque2.getBalas().get(i).getX(),tanque2.getBalas().get(i).getY(),15,15);
                    Shape inter= SVGPath.intersect(b1, s1);
                    
                    
                    Image bala= new Image("Imagenes/bala.png");
                    lapiz.drawImage(bala, tanque2.getBalas().get(i).getX(),tanque2.getBalas().get(i).getY(),7,7);
                     for(int q=0; q< this.obstaculos.length;q++){
                        if(this.obstaculos[q] instanceof Pared ){
                        Pared p= (Pared)this.obstaculos[q];    
                        Shape o= new Rectangle(p.getPosX(),p.getPosY(),p.getWidth(),p.getHeight());
                        Shape intero=SVGPath.intersect(o, b1);
                        if(intero.getLayoutBounds().getWidth()!= -1){
                            tanque2.getBalas().remove(i);
                            n=true;
                            break;
                        }
                    }
                    }                                      

                      
                  if (!n){  
                if(tanque2.getBalas().get(i).ismA())
                    tanque2.getBalas().get(i).moverArriba();
                 if(tanque2.getBalas().get(i).ismAB())
                    tanque2.getBalas().get(i).moverAbajo();  
                 if(tanque2.getBalas().get(i).ismI())
                    tanque2.getBalas().get(i).moverIzquierda();
                 if(tanque2.getBalas().get(i).ismD())
                    tanque2.getBalas().get(i).moverDerecha();
                  if(tanque2.getBalas().get(i).getX()>754||tanque2.getBalas().get(i).getX()<1||tanque2.getBalas().get(i).getY()>579||tanque2.getBalas().get(i).getY()<1){
                        tanque2.getBalas().remove(i);
                   
                  }
                
                  if(inter.getLayoutBounds().getWidth()!= -1){
                        tanque.setSalud(tanque.getSalud()-tanque2.getDanio());
                tanque2.getBalas().remove(i);
                }
                  }
                }
                
                lapiz.drawImage(anim, tanque.getX(), tanque.getY(),30,30);
                lapiz.drawImage(anim2, tanque2.getX(),tanque2.getY(),30,30);
  
                
                
                if(tanque.isDisparar()==false)
                {
                   numerot1++;  
                }
               
                if(tanque2.isDisparar()==false)
                {
                    numerot2++;
 
                }
                if(tanque.isPoder()==true){
                    numeroP1++;
                }
                if(tanque2.isPoder()==true){
                    numeroP2++;
                }
                
                for(int j=0;j<this.obstaculos.length;j++ ){
                    if (this.obstaculos[j] instanceof Cactus){
                        Shape c= new Ellipse(this.obstaculos[j].getPosX()+15,this.obstaculos[j].getPosY()+15,15,15);
                        Shape interC1= SVGPath.intersect(c, s1);
                        Shape interC2= SVGPath.intersect(c, s2);
                     if(interC1.getLayoutBounds().getWidth()!= -1)  {
                         tanque.setSalud(tanque.getSalud()-0.2);
                     }     
                     if(interC2.getLayoutBounds().getWidth()!= -1)  {
                         tanque2.setSalud(tanque2.getSalud()-0.2);
                     }
                     
                    }
                }

                
                       Image exp =new Image("Imagenes/explosion.png");
                       
          lapiz.setFill(Color.BLACK);
        lapiz.fillRect(50, 550, tanque.getSaludmax(),20 );
        lapiz.fillRect(500, 550, tanque2.getSaludmax(), 20);
        lapiz.setFill(Color.ORANGE);
        lapiz.fillRect(50,550, tanque.getSalud(), 20);
        lapiz.setFill(Color.GREEN);
        lapiz.fillRect(500, 550, tanque2.getSalud(), 20);  
      
        
        
        
        
  if(tanque.getSalud()<=0){
  
 lapiz.drawImage(exp, tanque.getX()-20,tanque.getY()-20,70,70);
 ganador=2;
finish=true;
        lapiz.setFont(Font.font("Old English Text MT", 40));
        lapiz.setFill(Color.BLUE);
 lapiz.fillText("Gana Verde", 250, 250);
 



    }
    
    if(tanque2.getSalud()<=0){
      
  lapiz.drawImage(exp, tanque2.getX()-20,tanque2.getY()-20,70,70);

  ganador=1;
  finish=true;
   lapiz.setFont(Font.font("Old English Text MT", 40));
        lapiz.setFill(Color.BLUE);
 lapiz.fillText("Gana Naranja", 250, 250);
 


    }
  
    }
    
    
    
    
    
    
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }


    
    
    
    
    
    
 @Override
    public Scene getScene() {
     return this.escena;
    }   
}
    
    
    
    
    
    
    
    





   

