/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbodevs_java;

import entite.Arbitre;
import service.ArbitreService;
import util.MyDB;

/**
 *
 * @author Ahmed.A.Hsouna
 */
public class TurboDevs_java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          MyDB.getInstance();
          
          Arbitre A =new Arbitre(10,"hsouna","aaaaaaaa","arbitre");
          Arbitre A1 =new Arbitre(30,10,"hsouna","aaaaaaaa","arbitre");
          ArbitreService ar= new ArbitreService();
          
        //  ar.ajouter(A);
         // ar.afficher();
         // ar.supprimer(31);
         ar.modifier(A1);
          System.out.println(ar.afficher());
    }
    
}
