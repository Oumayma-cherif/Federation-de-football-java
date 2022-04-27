/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Rewards;
import entities.Tournoi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceRewards;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author oumayma
 */
public class AjoutRewardsController implements Initializable {

    @FXML
    private TextField rank;
    @FXML
    private TextField trophe;
    @FXML
    private TextField prix;
    @FXML
    private Button btf;
    @FXML
    private ComboBox<String> tournoi;
    @FXML
    private ImageView img;
    @FXML
    private Label tih;
 String cat1="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ObservableList<String> listc =  FXCollections.observableArrayList();
             ServiceTournoi pst=new ServiceTournoi();
    for (Tournoi cc : pst.affichTournoi())
    {
         listc.add(cc.getNomt());
                
    }
       
        
        tournoi.setItems(listc);
        // TODO
    }    

    @FXML
    private void photoupload(MouseEvent event) throws FileNotFoundException {
        
        FileChooser filechooser =new FileChooser();
File file=filechooser.showOpenDialog(new Stage());
   Image image = new Image(new FileInputStream(file));
               img.setImage(image);
               int index=file.getName().indexOf('.');
               tih.setText(file.toString());
    }

    @FXML
    private void ajoutR(ActionEvent event) {
          
         String nomt= trophe.getText();
        
      
            String datef= rank.getText();
              String typet= prix.getText();
          String nbrc= tih.getText();
           
       Tournoi m=new Tournoi();
      
             ServiceTournoi pst=new ServiceTournoi();
    for (Tournoi cc : pst.affichTournoi())
    {
          if(cat1.equals(cc.getNomt()))
                {
                    m =new Tournoi(cc.getId(),cc.getNomt());
                }
                
    }
       
       
   
            Rewards t= new Rewards(Integer.parseInt(datef),nomt,Float.parseFloat(typet),nbrc,m);
            ServiceRewards st=new ServiceRewards();
            st.addReward(t);
             Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affichRewards.fxml"));
          Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
      } catch(IOException ex){
      System.err.println(ex.getMessage());}
        
    }

    @FXML
    private void selectTournoi(ActionEvent event) {
        
       cat1 =tournoi.getSelectionModel().getSelectedItem().toString();
        
        
    }
    
}