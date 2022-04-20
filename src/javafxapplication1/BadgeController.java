/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import entities.Badge;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javax.imageio.ImageIO;
import services.ServiceBadge;

/**
 * FXML Controller class
 *
 * @author ksaay
 */
public class BadgeController implements Initializable {

    @FXML
    private TableColumn<Badge, Integer> idB;
    @FXML
    private TableColumn<Badge, String> nomB;
    @FXML
    private TableColumn<Badge, Number> nbB;
    @FXML
    private TableColumn<Badge, String> logoB;
    @FXML
    private TextField tanomB;
    @FXML
    private TextField tanbB;
    @FXML
    private Label badgeimg;
 ServiceBadge psm = new ServiceBadge();
    @FXML
    private TableView<Badge> tabB;
    
    private byte[] person_image = null;
    @FXML
    private Button remove;
    @FXML
    private ImageView imgv;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showBadges();
        tabB.setEditable(true);
        nomB.setCellFactory(TextFieldTableCell.forTableColumn());
        /*
        try {
            //logoB.setCellFactory(TextFieldTableCell.forTableColumn());
            // Image myImage = new Image(new FileInputStream("C:/Users/ksaay/Desktop/4882066.jpg"));
            Image image = new Image(new FileInputStream("C:/Users/ksaay/Desktop/4882066.jpg"));
             imgv.setImage(image);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BadgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
  
       
    } 
    //onEditChangelogoB
    //onremove
    
    
    @FXML
    private void onremove(ActionEvent event) {
       Badge b = tabB.getSelectionModel().getSelectedItem();
       psm.supprimer(b.getId());
      showBadges();
//b.setLogoB(badgeStringCellEditEvent.getNewValue());

    }
        public void onEditChangelogoB(TableColumn.CellEditEvent<Badge,String> badgeStringCellEditEvent)
{
Badge b = tabB.getSelectionModel().getSelectedItem();
b.setLogoB(badgeStringCellEditEvent.getNewValue());
psm.modifier(b);
}
    public void onEditChangenomB(TableColumn.CellEditEvent<Badge,String> badgeStringCellEditEvent)
{
Badge b = tabB.getSelectionModel().getSelectedItem();
b.setNomB(badgeStringCellEditEvent.getNewValue());
psm.modifier(b);
}
//onEditChangenbB
    public void onEditChangenbB(TableColumn.CellEditEvent<Badge,Number> badgeStringCellEditEvent)
{


 if(badgeStringCellEditEvent.getNewValue().intValue()>0)
 {
     Badge b = tabB.getSelectionModel().getSelectedItem();
b.setNb(badgeStringCellEditEvent.getNewValue().intValue());
psm.modifier(b);
 }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Error");
alert.setHeaderText("Update Error");
alert.setContentText("Error !");

alert.showAndWait();
         }
}
     @FXML
    private void save(ActionEvent event) {
        if(tanomB.getText() == "" || badgeimg.getText() == "" || tanbB.getText() == "")
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Error");
alert.setHeaderText("Add Error");
alert.setContentText("all fields must  not be empty !");

alert.showAndWait();
        }
        else
        {
            
             Badge b = new Badge(tanomB.getText(),badgeimg.getText(),Integer.parseInt(tanbB.getText()));
             System.out.print(b.toString());
        ServiceBadge sb = new ServiceBadge(); 
        sb.ajouter(b);
        showBadges();
        }
       
        
        
    }
    
    
    @FXML
    private void upload(ActionEvent event)
    {
         FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

         File f = fileChooser.showOpenDialog(new Stage());

         badgeimg.setText(f.toString());
         
    }
    public void showBadges()
    {
       
        
        
        idB.setCellValueFactory(new PropertyValueFactory<Badge,Integer>("id"));
        nomB.setCellValueFactory(new PropertyValueFactory<Badge,String>("nomB"));
        nbB.setCellValueFactory(new PropertyValueFactory<Badge,Number>("nb"));
        logoB.setCellValueFactory(new PropertyValueFactory<Badge,String>("logoB"));
        tabB.setItems(psm.recuperer(0));
    }


    
/*
    private void onEditStartlogoB(TableColumn.CellEditEvent<Badge, String> event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

         File f = fileChooser.showOpenDialog(new Stage());

        // badgeimg.setText(f.toString());
         Badge b = tabB.getSelectionModel().getSelectedItem();
         if(f.toString()=="")
         {
             b.setLogoB(f.toString());
psm.modifier(b);

         }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Error");
alert.setHeaderText("Update Error");
alert.setContentText("Error !");

alert.showAndWait();
         }
         showBadges();

    }*/

    private void onEditStartlogoB(TableColumn.CellEditEvent<Badge, String> event) {
         FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

         File f = fileChooser.showOpenDialog(new Stage());

        // badgeimg.setText(f.toString());
       // System.out.println(f.toString());
         Badge b = tabB.getSelectionModel().getSelectedItem();
         if(f.toString()!="")
         {
             b.setLogoB(f.toString());
psm.modifier(b);

         }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Error");
alert.setHeaderText("Update Error");
alert.setContentText("Error !");

alert.showAndWait();
         }
         showBadges();
    }
/*
    @FXML
    private void onclickid(TableColumn.CellEditEvent<Badge, Integer> event) {
        ObservableList<Badge> prod;
         prod=tabB.getSelectionModel().getSelectedItems();
        Image image;
        try {
            image = new Image(new FileInputStream(prod.get(0).getLogoB()));
            imgv.setImage(image);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BadgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }*/

   

   

    

   

  

   

   

   


    
    
}
