/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.Escena1;
import Vista.Escena2;
import Vista.Escena3;
import Vista.Escena5;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Rincon
 */
public class Controlador5 {
  private Escena5 vista;
    
    
    
    
    public Controlador5(int i) {
      
       
        this.vista=new Escena5(i);
    this.vista.getContinuar().setOnAction(new Controlador5.Evento());

    
    
    }

    public Escena5 getVista() {
        return vista;
    }

    public void setVista(Escena5 vista) {
        this.vista = vista;
    }
 
    
        private class Evento implements EventHandler<ActionEvent>{

        @Override
      
        
        
        
        
        public void handle(ActionEvent t) {
           
        
         Singleton singleton= Singleton.getSingleton();
         Stage stage= singleton.getStage();
         Controlador1 controlador = new 
               Controlador1();
            Escena1 escena =
                   controlador.getEscena();

           stage.setScene( escena.getScene());
           stage.show();

        }
        
    }
   
    
    
}
