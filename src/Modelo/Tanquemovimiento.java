/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Controlador1;
import Control.Controlador2;
import Control.Controlador3;
import Control.Controlador4;
import Vista.Escena3;
import Vista.Escena4;
import Vista.Vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Control.Singleton;

/**
 *
 * @author Miguel Rincon
 */
public class Tanquemovimiento extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    Controlador1 controlador = new 
               Controlador1();
       Controlador2 controlador1= new Controlador2();
       
       Controlador3 controlador2= new Controlador3();
       
       Controlador4 controlador3= new Controlador4();
       Vista vista = controlador.getEscena();
       Scene esc = vista.getScene();
       Singleton singleton = Singleton.getSingleton();
       singleton.setStage(stage);
       
       stage.setTitle("Escena 1");
       stage.setScene(esc);
       stage.show(); 
    }
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }  
}
