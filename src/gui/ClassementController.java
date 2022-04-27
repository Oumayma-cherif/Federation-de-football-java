/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Tournoi;
import entities.classement;
import entities.club;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceClassement;

/**
 * FXML Controller class
 *
 * @author oumayma
 */
public class ClassementController implements Initializable {
public int id;
    @FXML
    private TableView<classement> tab;
    @FXML
    private TableColumn<classement, club> club;
    @FXML
    private TableColumn<classement, Integer> pts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceClassement s= new ServiceClassement();
         ObservableList<Tournoi> tournois = FXCollections.observableArrayList();
      //  Tournoi t=list.getSelectionModel().getSelectedItem();
      
      s.affichcl(TournoiFrontController.selectedtournoi.getId());
       //  Tournoi t=new Tournoi();
       
          
       
        
         club.setCellValueFactory(new PropertyValueFactory<classement,club>("club"));
        pts.setCellValueFactory(new PropertyValueFactory<classement,Integer>("pts"));
          club.setCellFactory(param -> {
            //Set up the ImageView
            final ImageView imageview = new ImageView();
            imageview.setFitHeight(50);
            imageview.setFitWidth(50);

            //Set up the Table
            TableCell<classement, club> cell = new TableCell<classement, club>() {
                public void updateItem(club item, boolean empty) {
                    if (item != null) {
                        imageview.setImage(item.getImg());
                    setText(item.getNomc());
                    }
                }
            };
            
            // Attach the imageview to the cell
            club.setGraphic(imageview);
            // setText(it.getNomc());
            return cell;
        });        
          
             tab.setItems(s.affichcl(TournoiFrontController.selectedtournoi.getId()));
        System.out.println(s.affichcl(TournoiFrontController.selectedtournoi.getId()));
       
        //System.out.println(s.affichcl(t.getTournoi().getId()));
        
    }    
    
}
