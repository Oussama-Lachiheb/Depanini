/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depanini;

import JavaMail.javaMailUtil;
import Models.Rate;
import Services.PrestataireService;
import util.MyConnection;
import Models.prestataire;
import Services.RateService;

/**
 *
 * @author THINKPAD
 */
public class Depanini {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //MyConnection mac = MyConnection.getInstance();
       //MaConnexion mac1 = MyConnection.getInstance();
           PrestataireService ps = new PrestataireService();
           prestataire ps1,ps2,ps3,ps4,ps5,ps6,psu;
         //ps1 = new prestataire("ffff","llfffl","dssfd","pelofk","dvcndv",15,3,87654321);
         //ps2 = new prestataire("ffff","llfffl","dssfd","pelofk","dvcndv",0,0,87654322);
        // ps3 = new prestataire("ariana","llfffl","dssfd","pelofk","dvcndv",0,0,87654323);
        // ps4 = new prestataire("ffff","llfffl","dssfd","pelofk","dvcndv",0,0,87654324);
         //ps5 = new prestataire("ffff","llfffl","dssfd","pelofk","dvcndv",0,0,87654325);
         //ps6 = new prestataire("ffff","llfffl","dssfd","pelofk","dvcndv",0,0,87654326);
           //ps.ajouterPrestataire();
          /* ps.ajouterPrestataire2(ps1);
           ps.ajouterPrestataire2(ps2);
           ps.ajouterPrestataire2(ps3);
           ps.ajouterPrestataire2(ps4);
           ps.ajouterPrestataire2(ps5);
           ps.ajouterPrestataire2(ps6);*/
           //psu = new prestataire("ariana","llfffl","dssfd","pelofk","dvcndv",10,10,87654323);
           //psu = new prestataire(87654323);
           //ps.findPrestataire(87654321);
          //UpdatePrestataire(psu);
        //System.out.println(ps.afficherPrestataire());
        //ps.SuprimerPrestataire(ps3);
       //ps.Toprated();
       //ps.UpdatePrestataire(ps1);
        //System.out.println(ps.afficherPrestataire());
        //ps.findPrestataire(87654321);
        //ps1 = new prestataire(87654321,"esprit","nnn","dssfd","pelofk","dvcndv",15,3);
        //ps.ajouterPrestataire(ps1);
        //ps.SuprimerPrestataire(ps1);
       // ps.UpdatePrestataire(ps1);
       //ps.Toprated();
    //ps.findPrestataire(87654321);
        RateService rt = new RateService();
        Rate r1;
        r1 = new Rate((float)2.2,1);
        //rt.ajouterRate(r1);
              ps1 = new prestataire("ffff","llfffl","dssfd","llfffl","dssfd","pelofk","d87654321",12.5);
              ps2 = new prestataire("hatem","deux","dssfd","llfffl","dssfd","pelofk","d87654321",12.5,87654329);
             // ps.ajouterPrestataire(ps1);
            //ps.findPrestataire(87654328);
            //ps.UpdatePrestataire(ps2);
            //System.out.println(ps.afficherPrestataire());
           //Rate r2 = new Rate((float) 2.5,1);
           //rt.UpdateRate(r2);
           //System.out.println(rt.afficherRate());
           /*String email = "oussama-la@gmail.com";
           if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")){ 
        System.out.println("the service provider is added");
        }else{
          System.out.println("verifier ton email!!");}*/
          //rt.ajouterRate(r1,87654328,12345678);
          //rt.TopRated();
          //rt.UpdateRate(r1);
          //ps.SuprimerPrestataire(ps2);
           //System.out.println(ps.afficherPrestataire());
           //System.out.println(ps.findPrestataire(87654330));
           //ps.SuprimerPrestataire(87654330);
           //javaMailUtil.sendMail("oussama.lachiheb@esprit.tn","frfref","ffrfrf");
           //rt.YourRate(87654331);
           //rt.TopRated();
          //rt.TopRated();
    //rt.MoyRate(87654331);
      //System.out.println(ps.TopRated1());
        //System.out.println(rt.afficherRate());
        //ps.getIDDps("oussama.lachiheb@esprit.tn");
      //ps.UpdatePrestataire("ffff","llfffl","dssfd","llfffl","amin@gmail.tn","pelofk","d87654321", (float) 12.5);
    rt.TopRated();
    }
    
    
}
