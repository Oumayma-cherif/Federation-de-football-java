/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Tournoi;
import entities.Rewards;
import java.io.FileNotFoundException;
import services.ServiceTournoi;
import services.ServiceRewards;
import services.ServiceClassement;
/**
 *
 * @author Skander
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       /* MyDB db = MyDB.getInstance();
    MyDB db2 = MyDB.getInstance();
        
        System.out.println(db);
        System.out.println(db2);*/
    
       Tournoi t=new Tournoi(5,"champions League");
       Rewards r=new Rewards (27,1,"oumaima",1000,"barca.png",t);
       ServiceTournoi ps = new ServiceTournoi();
         ServiceRewards p = new ServiceRewards();
          ServiceClassement x = new ServiceClassement();
       //  ps.deleteTournoi(364);
        // p.updateReward(r);
      //  p.deleteReward(20);
     //  ps.updateTournoi(t);
    
       System.out.println(p.rechercheReward(5));
      //System.out.println(p.affichReward());
      //  Tournoi p =new Tournoi ();
    }

}
