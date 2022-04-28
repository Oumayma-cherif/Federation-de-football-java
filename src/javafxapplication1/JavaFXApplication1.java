/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import util.sendmail;

/**
 *
 * @author ksaay
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     // sendmail.sendEmail("ksaay2000@gmail.com","Laporta","<h1>Laporta news</h1>","Degla");
        Parent root = FXMLLoader.load(getClass().getResource("MainGestionArticle.fxml"));
        Scene scene = new Scene(root);
      //  StackPane root = new StackPane();
       // root.getChildren().add(btn);
        
      //  Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
