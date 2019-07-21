/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import javafx.event.ActionEvent;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

/**
 *
 * @author Miguel Rincon
 */
public class Escena1 implements Vista{
private Scene escena; 
private Image fondo=null;
private Image fondo1=null;
private Button jugar;
 private GraphicsContext lapiz;
 private Button salir;

    public Escena1() {
        DropShadow ds= new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0, 0, 0));
        AnchorPane panel= new AnchorPane();
         this.fondo= new Image("Imagenes/tank_002.png");
        this.fondo1= new Image ("Imagenes/fondo.jpg");      
        this.jugar=new Button("JUGAR");
        this.salir=new Button("SALIR");
        AnchorPane.setBottomAnchor(jugar, 120.00);
        AnchorPane.setLeftAnchor(jugar, 370.00);
         AnchorPane.setBottomAnchor(salir, 80.00);
        AnchorPane.setLeftAnchor(salir, 430.00);
        Canvas tablero=new Canvas(1000,1000);
        this.lapiz=tablero.getGraphicsContext2D();
        lapiz.drawImage(fondo1, 0, 0);
        lapiz.drawImage(fondo,60,130);
        lapiz.setEffect(ds);
        lapiz.setFont(Font.font("Old English Text MT", 70));
        lapiz.setFill(Color.BROWN);
        lapiz.fillText("CALL OF TANKS", 330, 200);
        lapiz.setFont(Font.font("Old English Text MT", 30));
        lapiz.fillText("Unal Edition", 500, 250);
        jugar.setFont(Font.font("Old English Text MT", 50));
        jugar.setBackground(Background.EMPTY);
        jugar.setTextFill(Color.BROWN);
        jugar.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                jugar.setTextFill(Color.CHOCOLATE);
            }

        });
        jugar.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                jugar.setTextFill(Color.BROWN);
            }
            

        });
        salir.setFont(Font.font("Old English Text MT", 30));
        salir.setBackground(Background.EMPTY);
        salir.setTextFill(Color.BROWN);
        salir.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                salir.setTextFill(Color.CHOCOLATE);
            }

        });
        salir.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                salir.setTextFill(Color.BROWN);
            }
            

        });
        
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        
        panel.getChildren().addAll(tablero,jugar,salir);

        escena= new Scene(panel,1000,1000);
        
        
    }

    public Button getJugar() {
        return jugar;
    }


    
    
    
    
    public Scene getScene() {
  
        
       return escena;
       
    }
    
}
