/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed.A.Hsouna
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void liste_arb(ActionEvent event) {
        
          try {
                        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("afficher_arbitre.fxml"));
                        Parent root = LOADER.load();
                        Scene sc = new Scene(root);
                        Afficher_arbitreController cntr = LOADER.getController();
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(sc);
                        window.show();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
          
           
    }

    @FXML
    private void liste_stade(ActionEvent event) {
         try {
                        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("afficher_stade.fxml"));
                        Parent root = LOADER.load();
                        Scene sc = new Scene(root);
                        Afficher_stadeController cntr = LOADER.getController();
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(sc);
                        window.show();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
    }
    
}
