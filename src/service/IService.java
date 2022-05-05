/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;

/**
 *
 * @author oumaymacherif
 */
public interface IService<T> {

    public void ajouter(T t);

    public void supprimer(T t);

    public void modifier(T t);

    public List<T> afficher();

    public List<T> recherche(T t);
    
}

