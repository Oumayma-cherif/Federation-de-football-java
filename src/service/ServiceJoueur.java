/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Joueur;
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
public class ServiceJoueur implements IService<Joueur> {
    
Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Joueur e) {
        try {
            String req = "INSERT INTO joueur (cin, age, nbm, nba , nom ,prenom) VALUES ('" + e.getCin() + "','" + e.getAge() + "','" + e.getNbm() + "','" + e.getNba() + "','" + e.getNom() + "','" + e.getPrenom() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur ajoutée !");
            // JavaMailUtil.sendMail("adem.wertani@esprit.tn");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ServiceJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Joueur e) {
        try {
            String req = "DELETE  FROM joueur where cin=" + e.getCin();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Joueur e) {
        try {
            String req = "UPDATE joueur SET cin='"+e.getCin()+"',age='" + e.getAge() + "',nbm='" + e.getNbm()  + "',nba='" + e.getNba() + "',nom='" + e.getNom() + "',prenom='" + e.getPrenom() + "' WHERE cin_joueur =" + e.getCin();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Joueur modifé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Joueur> afficher() {
        List<Joueur> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM joueur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Joueur(rs.getInt(1),rs.getString("nom"), rs.getString("prenom"), rs.getString("age"), rs.getString("nbm"), rs.getString("nba")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void Trier() {
        ServiceJoueur se = new ServiceJoueur();
        List<Joueur> Trier = se.afficher().stream().sorted(Comparator.comparing(Joueur::getNom)).collect(Collectors.toList());
        Trier.forEach(System.out::println);
    }

    public void rechercher(String nom_ev) {
        List<Joueur> result = afficher().stream().filter(line -> nom_ev.equals(line.getNom())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);

    }

    @Override
    public List<Joueur> recherche(Joueur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

