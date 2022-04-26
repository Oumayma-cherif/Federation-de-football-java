/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.User;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.session;


/**
 *
 * @author Houcem
 */
public class UserService {
	
	Connection cnx = DataSource.getInstance().getCnx();

	public void ajouter(User t) {
		try {
                
            String requete = "INSERT INTO user (badge_id,username,mdp,nbp,email,role,img) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, "1");
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getMdp());
            pst.setString(4,"1");
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getRole());
            pst.setString(7, "avatar.png");
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
	}


	public void supprimer(User t) {
		  try {
            String requete = "DELETE FROM user WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,t.getId());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
	}


	public void modifier(User t) {
		   try {
            String requete = "UPDATE user SET username=?, email=?, role=?, mdp=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(5, t.getId());
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getRole());
            pst.setString(4, t.getMdp());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
	}

	public List<User> afficher() {
		 ObservableList <User> ListProject =FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM user";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ListProject.add(new User(rs.getInt("id"),rs.getString("username"),rs.getString("mdp"),rs.getString("role"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
        return ListProject;
	}
        
	public List<User> search(String x,String y) {
		 ObservableList <User> ListProject = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM User where username like ? or email like ? or role like ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, "%"+x+"%");
			pst.setString(2, "%"+x+"%");
			pst.setString(3, "%"+x+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ListProject.add(new User(rs.getInt("id"),rs.getString("username"),rs.getString("mdp"),rs.getString("role"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
        return ListProject;
	}
        
        public boolean signIn(String username,String mdp) {
        try {
            String requete = "SELECT * FROM User where username = ? and mdp = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, username);
			pst.setString(2, mdp);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                session s = new session(new User(rs.getInt("id"),rs.getString("username"),rs.getString("mdp"),rs.getString("role"), rs.getString("email")));
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                    return false;

      	}
	
}
