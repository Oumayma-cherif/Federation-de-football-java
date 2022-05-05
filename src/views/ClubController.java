/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumaymacherif
 */
public class ClubController implements Initializable {

    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button home;
    @FXML
    private Button Club;
    @FXML
    private Button Joueur;
    @FXML
    private Button Sponsor;
    @FXML
    private Button add;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_sponsor;
    @FXML
    private TableColumn<?, ?> col_logo;
    @FXML
    private TableColumn<?, ?> col_age;
    @FXML
    private TableColumn<?, ?> col_nbm;
    @FXML
    private TableColumn<?, ?> col_nba;
    @FXML
    private TextField logo;
    @FXML
    private TextField chercher;
    @FXML
    private TextField nom;
    @FXML
    private TextField descr;
    @FXML
    private TextField id;
    @FXML
    private Button refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(MouseEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
        try {
            Parent exercices_parent = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            Scene ex_section_scene = new Scene(exercices_parent);
            Stage second_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            second_stage.setScene(ex_section_scene);
            second_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Club(ActionEvent event) {
        try {
            Parent exercices_parent = FXMLLoader.load(getClass().getResource("/views/Club.fxml"));
            Scene ex_section_scene = new Scene(exercices_parent);
            Stage second_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            second_stage.setScene(ex_section_scene);
            second_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void Sponsor(ActionEvent event) {
        try {
            Parent exercices_parent = FXMLLoader.load(getClass().getResource("/views/Sponsor.fxml"));
            Scene ex_section_scene = new Scene(exercices_parent);
            Stage second_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            second_stage.setScene(ex_section_scene);
            second_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SponsorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    private void Joueur(ActionEvent event) {
        try {
            Parent exercices_parent = FXMLLoader.load(getClass().getResource("/views/Joueur.fxml"));
            Scene ex_section_scene = new Scene(exercices_parent);
            Stage second_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            second_stage.setScene(ex_section_scene);
            second_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(JoueurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void add(MouseEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void refresh() {
        
        
        
        
    }

    @FXML
    private void refresh(ActionEvent event) {
    }
    
}
