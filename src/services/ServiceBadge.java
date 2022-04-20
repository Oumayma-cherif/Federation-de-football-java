/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Badge;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MyDB;


/**
 *
 * @author ksaay
 */
public class ServiceBadge implements IService<Badge> {
  Connection cnx;

    public ServiceBadge() {
        cnx = MyDB.getInstance().getConnection();
    }
     @Override
    public void ajouter(Badge t) {
        try {
            String req = "insert into badge(nom_b,logo_b,nb)"
                    + "values( '" + t.getNomB()+ "','" + t.getLogoB()+ "',"
                    +  t.getNb()+ " )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Badge ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Badge t) {
        try {
            String req = "update badge set nom_b= ?, logo_b =?, nb =? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNomB());
            ps.setString(2, t.getLogoB());
            ps.setInt(3, t.getNb());
            ps.setInt(4, t.getId());
            ps.executeUpdate();
            System.out.println("Badge modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
       try {
           String req = "delete from  badge where id= ?";
           PreparedStatement ps = cnx.prepareStatement(req);
           ps.setInt(1, id);
            ps.executeUpdate();
       } catch (SQLException ex) {
          System.out.println(ex.getMessage());
       }
    }

    @Override
    public ObservableList<Badge> recuperer(int order) {
        
        ObservableList<Badge> badges = FXCollections.observableArrayList();   
        try {
            String req="";
            if(order == 1 )
            {
                req= "select * from badge order by id asc";
            }
            else
            {
                if(order == 2)
                {
                     req= "select * from badge order by id desc";
                }
                else
                {
                     req= "select * from badge";
                }
            }
             
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Badge p = new Badge();
                p.setId(rs.getInt(1));
                p.setNomB(rs.getString("nom_b"));
                p.setLogoB(rs.getString("logo_b"));
                p.setNb(rs.getInt("nb"));
                badges.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return badges;
    }
    
    @Override
    public List<Badge> rec_search(String x) {
        List<Badge> badges = new ArrayList<>();
        try {
            String req="select * from badge where nom_b "
                    + "like '%" + x+ "%' ";
                
            
             
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Badge p = new Badge();
                p.setId(rs.getInt(1));
                p.setNomB(rs.getString("nom_b"));
                p.setLogoB(rs.getString("logo_b"));
                p.setNb(rs.getInt("nb"));
                badges.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return badges;
    }
}
