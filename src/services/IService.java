/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Skander
 */
public interface IService<T> {
    public void addTournoi(T t);
    public void updateTournoi(T t);
    public void deleteTournoi(int id);
    public List<T> affichTournoi();
  
    
}
