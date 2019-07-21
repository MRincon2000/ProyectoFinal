/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Miguel Rincon
 */
public class Escena5 implements Vista{

  private Scene escena;  
  private Image fondo=null;
private Image fondo1=null;
private GraphicsContext lapiz;
private Button continuar;
private int ganador;
  
  
  
  public Escena5(int i) {
      ganador=i;
        DropShadow ds= new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0, 0, 0));
        AnchorPane panel= new AnchorPane();
        this.fondo= new Image("Imagenes/tank_002.png");
        this.fondo1= new Image ("Imagenes/fondo.jpg");   
        this.continuar= new Button("Continuar");
        AnchorPane.setBottomAnchor(continuar, 120.00);
        AnchorPane.setLeftAnchor(continuar, 370.00);
        Canvas tablero=new Canvas(1000,1000);
        this.lapiz=tablero.getGraphicsContext2D();
        lapiz.drawImage(fondo1, 0, 0);
        lapiz.drawImage(fondo,60,130);
        lapiz.setEffect(ds);
        lapiz.setFont(Font.font("Old English Text MT", 70));
        
        continuar.setFont(Font.font("Old English Text MT", 50));
        continuar.setBackground(Background.EMPTY);
        continuar.setTextFill(Color.BROWN);    
         continuar.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                continuar.setTextFill(Color.CHOCOLATE);
            }

        });
        continuar.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                continuar.setTextFill(Color.BROWN);
            }
            

        });
     if(ganador==1){
        lapiz.setFont(Font.font("Old English Text MT", 70));
        lapiz.setFill(Color.CHOCOLATE);
        lapiz.fillText("GANA NARANJA", 300, 200);
     }
     if (ganador==2){
         lapiz.setFont(Font.font("Old English Text MT", 70));
          lapiz.setFill(Color.GREEN);
        lapiz.fillText("GANA VERDE", 300, 200); 
     }   
        
        
        
        
        
          panel.getChildren().addAll(tablero,continuar);

        escena= new Scene(panel,1000,1000);
        
              
        
        
        
    
    }

    public Button getContinuar() {
        return continuar;
    }
    
    
    
    
    
    
    
    
    
    
    @Override
 
    public Scene getScene() {
    
        return this.escena;
        
    }
    
}
