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
public class Escena2 implements Vista{

   private Scene escena;
   private Image fondo=null;
   private Image fondo1=null;
   private GraphicsContext lapiz;
   private Button two;
   private Button three;

    public Escena2() {
     DropShadow ds= new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0, 0, 0));
        AnchorPane panel= new AnchorPane();
    this.fondo=new Image("imagenes/fondo.jpg");
    this.fondo1=new Image("imagenes/tank_002.png");
    this.two= new Button("Dos jugadores");
    this.three= new Button("Atras");
    
    AnchorPane.setBottomAnchor(two, 130.00);
    AnchorPane.setLeftAnchor(two, 300.00);
    AnchorPane.setBottomAnchor(three, 70.00);
    AnchorPane.setLeftAnchor(three, 400.00);
        Canvas tablero=new Canvas(1000,1000);
        this.lapiz= tablero.getGraphicsContext2D();
         lapiz.drawImage(fondo, 0, 0);
        lapiz.drawImage(fondo1,60,130);
        lapiz.setEffect(ds);
        lapiz.setFont(Font.font("Old English Text MT", 50));
        lapiz.setFill(Color.BROWN);
        lapiz.fillText("SELECCIONE MODO", 330, 200);
        two.setFont(Font.font("Old English Text MT", 50));
        two.setBackground(Background.EMPTY);
        two.setTextFill(Color.BROWN);
        two.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                two.setTextFill(Color.CHOCOLATE);
            }

        });
        two.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                two.setTextFill(Color.BROWN);
            }
            

        });
        
        three.setFont(Font.font("Old English Text MT", 50));
        three.setBackground(Background.EMPTY);
        three.setTextFill(Color.BROWN);
    three.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                three.setTextFill(Color.CHOCOLATE);
            }

        });
        three.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                three.setTextFill(Color.BROWN);
            }
            

        });
     panel.getChildren().addAll(tablero,two,three);

        escena= new Scene(panel,1000,1000);
    
    }
    
    
    
    @Override
  
    public Scene getScene() {
    return this.escena;
    }

    public Button getTwo() {
        return two;
    }

    public void setTwo(Button two) {
        this.two = two;
    }

    public Button getThree() {
        return three;
    }
    
}
