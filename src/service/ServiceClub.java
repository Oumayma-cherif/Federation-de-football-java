package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import entity.Club;
import service.IService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import util.DataSource;

/**
 *
 * @author oumaymacherif
 */
public class ServiceClub implements IService<Club> {
    
Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Club e) {
        try {
            String req = "INSERT INTO club (id, nomc, descr, logo ) VALUES ('" + e.getId() + "','" + e.getNomc() + "','" + e.getDescr() + "','" + e.getLogo() +   "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur ajoutée !");
            // JavaMailUtil.sendMail("adem.wertani@esprit.tn");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ServiceClub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Club e) {
        try {
            String req = "DELETE  FROM club where id_club=" + e.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Club e) {
        try {
            String req = "UPDATE club SET id='"+e.getId()+"',nomc='" + e.getNomc() + "',descr='" + e.getDescr()  + "',logo='" + e.getLogo() +  "' WHERE id_club =" + e.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur modifé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Club> afficher() {
        List<Club> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM club";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Club(rs.getInt(1), rs.getString("logo"),rs.getString("nomc"), rs.getString("descr")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void Trier() {
        ServiceClub se = new ServiceClub();
        List<Club> Trier = se.afficher().stream().sorted(Comparator.comparing(Club::getNomc)).collect(Collectors.toList());
        Trier.forEach(System.out::println);
    }

    public void rechercher(String nomc) {
        List<Club> result = afficher().stream().filter(line -> nomc.equals(line.getNomc())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);

    }

    @Override
    public List<Club> recherche(Club t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

