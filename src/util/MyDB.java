/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ksaay
 */
public class MyDB {

    private final String url = "jdbc:mysql://localhost:3306/turbodevs";
    private final String username = "root";
    private final String password = "";
    private Connection connection;
    private static MyDB instance;

    private MyDB() {
        try {
            connection = DriverManager.getConnection(url, username, password);
           // System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static MyDB getInstance(){
        if(instance == null)
            instance = new MyDB();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
   

}
