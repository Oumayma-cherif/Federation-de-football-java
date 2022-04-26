/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.UserService;
import utils.session;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class SignInFormController implements Initializable {

    @FXML
    private TextField tf_in_username;
    @FXML
    private Button btn_in;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_up_username;
    @FXML
    private TextField tf_up_password;
    @FXML
    private TextField tf_up_email;
    @FXML
    private Button btn_up;
    
    UserService us = new UserService();
    @FXML
    private AnchorPane ap;
    
    	Alert alert = new Alert(Alert.AlertType.NONE);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_in_action(ActionEvent event) throws IOException {
        if(us.signIn(tf_in_username.getText(), tf_password.getText())) {
            if(session.getSession().getRole().equals("client")){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/frontofficeForm.fxml"));
                ap.getChildren().setAll(pane);
            }
            else {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/backofficeForm.fxml"));
                ap.getChildren().setAll(pane);
            }   
        }
        else {
            Alert alertA = new Alert(Alert.AlertType.NONE,"Check username or password!",ButtonType.APPLY);
            alertA.show();
        }
    }

    @FXML
    private void btn_up_action(ActionEvent event) {
        if(!tf_up_username.getText().equals("") && !tf_up_password.getText().equals("") && !tf_up_email.getText().equals("")) {
            User u = new User(tf_up_username.getText(), tf_up_password.getText(), "client", tf_up_email.getText()); 
            us.ajouter(u);
            tf_up_username.setText("");
            tf_up_password.setText("");
            tf_up_email.setText("");
            Alert alertA = new Alert(Alert.AlertType.NONE,"Sign up successful!",ButtonType.APPLY);
            alertA.show();
        }
        else {
            Alert alertA = new Alert(Alert.AlertType.NONE,"Empty field!",ButtonType.APPLY);
            alertA.show();
        }
        
    }
    
}
