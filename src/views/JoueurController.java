/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Joueur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ServiceJoueur;
import util.DataSource;

/**
 * FXML Controller class
 *
 * @author oumaymacherif
 */
public class JoueurController implements Initializable {

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
    private TableView<Joueur> table;
    @FXML
    private TableColumn<Joueur, Integer> col_cin;
    @FXML
    private TableColumn<Joueur, ?> col_nom;
    @FXML
    private TableColumn<Joueur, ?> col_prenom;
    @FXML
    private TableColumn<Joueur, Integer> col_age;
    @FXML
    private TableColumn<Joueur, Integer> col_nbm;
    @FXML
    private TableColumn<Joueur, Integer> col_nba;
    @FXML
    private TextField age;
    @FXML
    private TextField chercher;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;
    @FXML
    private Button refresh;
    @FXML
    private TextField nba;
    @FXML
    private TextField nbm;
    @FXML
    private TextField prenom;
    ObservableList<Joueur> List = FXCollections.observableArrayList();
    ObservableList<Joueur> dataList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void update(MouseEvent event) {
        ServiceJoueur sp = new ServiceJoueur();
        sp.modifier(new Joueur(Integer.parseInt(cin.getText()), nom.getText(), prenom.getText(), age.getText(),nbm.getText(),nba.getText()));
        JOptionPane.showMessageDialog(null, "Joueur modifié !");
        refresh();
        
    
    }

    @FXML
    private void update(ActionEvent event) {
ServiceJoueur sp = new ServiceJoueur();
        sp.modifier(new Joueur(Integer.parseInt(cin.getText()), nom.getText(), prenom.getText(), age.getText(),nbm.getText(),nba.getText()));
        JOptionPane.showMessageDialog(null, "Joueur modifié !");
        refresh();
        
    
    }

    @FXML
    private void delete(MouseEvent event) {
         Connection cnx = DataSource.getInstance().getCnx();
        String sql = "DELETE  FROM joueur where cin= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setString(1, cin.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "delete");
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
            table.refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        refresh();
    }

    @FXML
    private void delete(ActionEvent event) {
         Connection cnx = DataSource.getInstance().getCnx();
        String sql = "DELETE  FROM joueur where cin= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setString(1, cin.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "delete");
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
            table.refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        refresh();
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
        }
    }

    @FXML
    private void add(MouseEvent event) {
        ServiceJoueur sp = new ServiceJoueur();
        sp.ajouter(new Joueur(Integer.parseInt(cin.getText()), nom.getText(), prenom.getText(), age.getText(),nbm.getText(),nba.getText()));
        JOptionPane.showMessageDialog(null, "Joueur ajoutée !");
        refresh();
    }

    @FXML
    private void add(ActionEvent event) {
        ServiceJoueur sp = new ServiceJoueur();
        sp.ajouter(new Joueur(Integer.parseInt(cin.getText()), nom.getText(), prenom.getText(), age.getText(),nbm.getText(),nba.getText()));
        JOptionPane.showMessageDialog(null, "Joueur ajoutée !");
        refresh();
    }

    @FXML
    private void getSelected(MouseEvent event) {
        int index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        cin.setText(col_cin.getCellData(index).toString());
        nom.setText((String) col_nom.getCellData(index));
        prenom.setText((String) col_prenom.getCellData(index));
        age.setText(col_age.getCellData(index).toString());
        nbm.setText(col_nbm.getCellData(index).toString());
        nba.setText(col_nba.getCellData(index).toString());

    }

    

    @FXML
    private void refresh() {
         try {
            Connection cnx = DataSource.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM joueur");
            while (rs.next()) {
                List.add(new Joueur(rs.getInt(1),rs.getString("nom"), rs.getString("prenom"), rs.getString("age"), rs.getString("nbm"), rs.getString("nba")));
            }
        } catch (SQLException ex) {
        }

        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_nba.setCellValueFactory(new PropertyValueFactory<>("nba"));
        col_nbm.setCellValueFactory(new PropertyValueFactory<>("nbm"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
      
        table.setItems(List);
   
    }

    @FXML
    private void pdf(ActionEvent event) {
    }

}
