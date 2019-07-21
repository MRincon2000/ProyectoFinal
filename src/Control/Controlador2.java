/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import Vista.Escena1;
import Vista.Escena2;
import Vista.Escena3;
import java.io.FileNotFoundException;

/**
 *
 * @author Estudiante
 */
public class Controlador2 {
     private Escena2 vista;


    
     
     public Controlador2() {
    this.vista=new Escena2();

    this.vista.getTwo().setOnAction(new Evento());
    }

    public Escena2 getVista() {
        return vista;
    }

    public void setVista(Escena2 vista) {
        this.vista = vista;
    }


    
    private class Evento implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           
         try{   
         Singleton singleton= Singleton.getSingleton();
         Stage stage= singleton.getStage();
  Controlador3 controlador = new 
               Controlador3();
         Escena3 escena =
                   controlador.getVista();
         escena.start();
           stage.setScene( escena.getScene());
           stage.show();
         }catch(FileNotFoundException s){
             System.out.println("Fallo en el sistema de puntaje");
             System.exit(1);
         }
        }
        
    }
     
     
}
