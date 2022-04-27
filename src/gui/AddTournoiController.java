/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Tournoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author oumayma
 */
public class AddTournoiController implements Initializable {

    @FXML
    private TextField id_nomt;
    @FXML
    private DatePicker id_dated;
    @FXML
    private DatePicker id_datef;
    @FXML
    private TextField id_typet;
    @FXML
    private TextField id_nbrc;
    @FXML
    private ImageView id_img;
    @FXML
    private Button btnt;
    @FXML
    private Button parc;
     @FXML
    private Label id_lab;
    @FXML
    private Button bth;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML           
      public  void parcourir(ActionEvent ev) throws FileNotFoundException, IOException{
      // File file
//Image image new Image(newimage3.setImage(image);
FileChooser filechooser =new FileChooser();
File file=filechooser.showOpenDialog(new Stage());
   Image image = new Image(new FileInputStream(file));
               id_img.setImage(image);
               int index=file.getName().indexOf('.');
               id_lab.setText(file.getName().toString());
               
             }
    @FXML
    private void saveTournoi(ActionEvent event) {
     String nomt= id_nomt.getText();
        
       LocalDate format= id_dated.getValue();
              
          String dated= format.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate form= id_datef.getValue();
              
          String datef= form.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            //String datef= id_datef.getText();
              String typet= id_typet.getText();
          String nbrc= id_nbrc.getText();
      
       
    
            String img= id_lab.getText();
            Tournoi t= new Tournoi(nomt,dated.toString(),datef.toString(),typet,Integer.parseInt(nbrc),img);
            ServiceTournoi st=new ServiceTournoi();
            st.addTournoi(t);
             Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affichTournoi.fxml"));
          Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
      } catch(IOException ex){
      System.err.println(ex.getMessage());}
        
    }

    @FXML
    private void back(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("affichTournoi.fxml"));
          Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
      } catch(IOException ex){
      System.err.println(ex.getMessage());}
        
    }
   
}