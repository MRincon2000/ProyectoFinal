/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Tanquemovimiento;
import Vista.Escena3;
import Vista.Escena4;
import Vista.Escena5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Rincon
 */
public class Controlador4 {
    private Escena4 vista;
    private  int puntaje1; 
    private int puntaje2;
    private File puntaje;


    
     
     public Controlador4() throws FileNotFoundException {
    
    this.puntaje= new File("Puntaje.txt");
    
    Scanner imput= new Scanner(puntaje);

   
     
    this.puntaje1=imput.nextInt();
    this.puntaje2=imput.nextInt();     
         
         
         
         this.vista=new Escena4(this,puntaje1,puntaje2);
        
    
    
    }

    public Escena4 getVista() {
        return vista;
    }

    public void setVista(Escena4 vista) {
        this.vista = vista;
    }


    


        public void handle() throws FileNotFoundException {
       
            
            
            
            if (this.getVista().getGanador()==1){
             this.puntaje1++;
         }
         else if(this.getVista().getGanador()==2){
             this.puntaje2++;
         } 
         
         Tanquemovimiento.esperar(2);   
         this.vista.stop();
          
         
          
         PrintStream salida= new PrintStream(puntaje);
        
         
         if(puntaje1==5){
          this.puntaje1=0;
          this.puntaje2=0;
          salida.println(puntaje1);
          salida.println(puntaje2);
          Singleton singleton= Singleton.getSingleton();
         Stage stage= singleton.getStage();
  Controlador5 controlador = new 
               Controlador5(1);
         Escena5 escena =
                   controlador.getVista();

           stage.setScene( escena.getScene());
           stage.show();
          
          
         }
         else if(puntaje2==5){
          this.puntaje1=0;
          this.puntaje2=0;
          salida.println(puntaje1);
          salida.println(puntaje2);  
 Singleton singleton= Singleton.getSingleton();
         Stage stage= singleton.getStage();
  Controlador5 controlador = new 
               Controlador5(2);
         Escena5 escena =
                   controlador.getVista();

           stage.setScene( escena.getScene());
           stage.show();
                
         
         
         
         
         }
       
         
         
         else{
         salida.println(puntaje1);
          salida.println(puntaje2);    
         Singleton singleton= Singleton.getSingleton();
         Stage stage= singleton.getStage();
  Controlador3 controlador = new 
               Controlador3();
         Escena3 escena =
                   controlador.getVista();
         escena.start();
           stage.setScene( escena.getScene());
           stage.show();
        }
        
    }
}


