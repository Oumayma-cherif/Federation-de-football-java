/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Badge;
import entities.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MyDB;

/**
 *
 * @author ksaay
 */
public class ServiceUser {
   Connection cnx;

    public ServiceUser() {
        cnx = MyDB.getInstance().getConnection();
    }
    
    public ObservableList<User> recuperer() {
         ObservableList<User> users = FXCollections.observableArrayList();
       try {
          
           
           String       req= "select * from user";
           
           
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(req);
           
           while (rs.next()) {
               User u = new User();
                 u.setId(Integer.parseInt(rs.getString("id")));
               u.setUsername(rs.getString("username"));
               users.add(u);
               
           }
           
           
           return users;
       } catch (SQLException ex) {
           Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
       }
       return users;
    }

   
}
