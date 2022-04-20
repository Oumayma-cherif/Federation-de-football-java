/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import entities.Article;
import entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceArticle;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author ksaay
 */
public class ArticleController implements Initializable {

    @FXML
    private TableColumn<Article, Integer> id;
    @FXML
    private TableColumn<Article, String> user_id;
    @FXML
    private TableColumn<Article,String > titre;
    @FXML
    private TableColumn<Article, String> descr;
    @FXML
    private TableColumn<Article, String> datea;
    @FXML
    private TableColumn<Article, String> img;
    @FXML
    private TextField tatitre;
    @FXML
    private TextField tadescr;
    @FXML
    private ComboBox<String> user_c;
    @FXML
    private Button upload;
    @FXML
    private TableView<Article> taba;
     ServiceArticle psm = new ServiceArticle();
     ServiceUser psu = new ServiceUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> listc =  FXCollections.observableArrayList();
         for(User c :  psu.recuperer())
        {
           
            listc.add(c.getUsername());
        }
        
        user_c.setItems(listc);
    }    
/*
    private void onupdatetitre(TableColumn.CellEditEvent<Article,String> articleStringCellEditEvent) {
        Article a = taba.getSelectionModel().getSelectedItem();
a.setTitre(articleStringCellEditEvent.getNewValue());
psm.modifier(a);
    }


    @FXML
    private void onupload(ActionEvent event) {
    }

    

    private void onupdatedescr(TableColumn.CellEditEvent<Article,String> articleStringCellEditEvent) {
        Article a = taba.getSelectionModel().getSelectedItem();
a.setDescr(articleStringCellEditEvent.getNewValue());
psm.modifier(a);
    }

    private void onupdateimg(TableColumn.CellEditEvent<Article,String> articleStringCellEditEvent) {
        Article a = taba.getSelectionModel().getSelectedItem();
a.setImg(articleStringCellEditEvent.getNewValue());
psm.modifier(a);
    }*/
     public void showArticles()
    {
        /*
         this.nomB = nomB;
        this.nb = nb;
        this.logoB = logoB;
        */
        
        
        id.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<Article,String>("titre"));
        descr.setCellValueFactory(new PropertyValueFactory<Article,String>("descr"));
        img.setCellValueFactory(new PropertyValueFactory<Article,String>("img"));
         datea.setCellValueFactory(new PropertyValueFactory<Article,String>("datea"));
        taba.setItems(psm.recuperer(0));
        /*
         private TableColumn<Article, Integer> id;
    @FXML
    private TableColumn<Article, String> user_id;
    @FXML
    private TableColumn<Article,String > titre;
    @FXML
    private TableColumn<Article, String> descr;
    @FXML
    private TableColumn<Article, String> datea;
    @FXML
    private TableColumn<Article, String> img;
        */
    }

    @FXML
    private void onupload(ActionEvent event) {
    }

 

    

   

    
    
}
