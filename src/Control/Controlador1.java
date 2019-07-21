/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Vista.Escena1;
import Vista.Escena2;

/**
 *
 * @author Estudiante
 */
public class Controlador1 {
    private Escena1 escena;


    public Escena1 getEscena() {
        return escena;
    }

    
    public Controlador1() {
      this.escena = 
              new Escena1();
      this.escena.getJugar()
                .setOnAction(new Evento());
    }
    
    private class Evento 
      implements EventHandler<ActionEvent>{
       @Override
        public void handle(ActionEvent event) {
           Singleton singleton=
                   Singleton.getSingleton();
           Stage stage = singleton.getStage();
         
         

          Controlador2 controlador = new 
               Controlador2();
         Escena2 escena =
                   controlador.getVista();
           stage.setScene( escena.getScene());
           stage.show();
        }
    }
    
    
    
    
}
