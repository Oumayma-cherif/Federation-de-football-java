/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Tournoi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
//import org.w3c.dom.Document;


import util.MyDB;
/**
 *
 * @author oumayma
 */
public class ServiceTournoi implements IService<Tournoi> {
    
     Connection cnx;
    
   

    public ServiceTournoi() {
         cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void deleteTournoi(int id) {
      //  throw new UnsupportedOperationException("Not supported yet.");
          try {
            String req = "delete from tournoi  where id=" + " '"+ id + "' ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();
         
          
            System.out.println("tournoi deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      @Override
    public void addTournoi(Tournoi t) {
         try {
            String req = "insert into tournoi(nomt,dated,datef,typet,nbrc,logo)"
                    + "values( '" + t.getNomt() + "','" + t.getDated()+ "','" + t.getDatef()+"','" + t.getTypet()+ "','" + t.getNbrc()+ "','"
                    + t.getLogo()+ " ')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tournoi ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void updateTournoi(Tournoi t) {
         try {
            String req = "update tournoi set nomt= ?, dated =?, datef =? , typet =?, nbrc =?, logo =? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNomt());
            ps.setString(2, t.getDated());
            ps.setString(3,t.getDatef());
             ps.setString(4,t.getTypet());
              ps.setInt(5, t.getNbrc());
               ps.setString(6,t.getLogo());
            ps.setInt(7, t.getId());
            ps.executeUpdate();
            System.out.println("Tournoi modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public ObservableList<Tournoi> affichTournoi(){
   
           

          ObservableList<Tournoi> tournois = FXCollections.observableArrayList();
        try {
            String req = "select * from tournoi";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Tournoi p = new Tournoi();
                p.setId(rs.getInt("id"));
                p.setNomt(rs.getString("nomt"));
                p.setDated(rs.getString("dated"));
                 p.setDatef(rs.getString("datef"));
                  p.setTypet(rs.getString("typet"));
                p.setNbrc(rs.getInt("nbrc"));
                 p.setLogo(rs.getString("logo"));
                   FileInputStream inputStream;
                try {
                    inputStream = new FileInputStream("../Federation-de-football-master (1)/Federation-de-football-master/public/uploads/" + rs.getString("logo"));
                    //   inputStream = new FileInputStream("src/voyagep.png");
                    Image image = new Image(inputStream);
                    //   imgViewV = new ImageView(image);
                    p.setImg(image);

                } catch (FileNotFoundException ex) {
                      System.out.println(ex.getMessage());

                }
                tournois.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournois;
    }
    


    public ObservableList<Tournoi> affichTournoiImg(Tournoi p){
   
           

          ObservableList<Tournoi> tournois = FXCollections.observableArrayList();
        try {
            String req = "select * from tournoi";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
               // Tournoi p = new Tournoi();
                 PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNomt());
            ps.setString(2, p.getDated());
            ps.setString(3,p.getDatef());
             ps.setString(4,p.getTypet());
              ps.setInt(5, p.getNbrc());
               ps.setString(6,p.getLogo());
            
              
               //  p.getLogo(rs.getString("logo"));
                   FileInputStream inputStream;
                try {
                    inputStream = new FileInputStream("../Federation-de-football-master (1)/Federation-de-football-master/public/uploads/" + rs.getString("logo"));
                    //   inputStream = new FileInputStream("src/voyagep.png");
                    Image image = new Image(inputStream);
                    //   imgViewV = new ImageView(image);
                    p.setImg(image);

                } catch (FileNotFoundException ex) {
                      System.out.println(ex.getMessage());

                }
                tournois.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournois;
    }
   
    
}