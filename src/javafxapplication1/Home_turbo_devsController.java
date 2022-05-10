/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.session;

/**
 * FXML Controller class
 *
 * @author ksaay
 */
public class Home_turbo_devsController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView articlevf;
    @FXML
    private Button loginb;
    @FXML
    private ImageView shopv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Image image1 = new Image("/AhmedImages/articlej.png");
            articlevf.setImage(image1);
            image1 = new Image("/AhmedImages/Shop.jpg");
             shopv.setImage(image1);
      //  articlevf.
      if(session.getSession().getId()!=0)
      {
          loginb.setText("Logged");
      }
    }    
   

    @FXML
    private void articlevf(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ArticleFront.fxml"));
   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
    }

    @FXML
    private void loginb(ActionEvent event) throws IOException {
        if(loginb.getText()=="Logged")
        {
            session.setSession(null);
            loginb.setText("Login");
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/signInForm.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.setTitle("Login");
   stage.show();
        }
                     
        
    }

    @FXML
    private void shopv(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.setTitle("Shop");
   stage.show();
        
    }
}
