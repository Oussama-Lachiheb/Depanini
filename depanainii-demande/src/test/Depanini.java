/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import util.MaConnexion;
import entities.Demande;
import entities.Demande_CRUD;
import entities.Reclamation;
import entities.Reclamation_CRUD;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class Depanini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
               MaConnexion cnx;
        
      //  cnx = new MaConnexion();
        
       
       // Demande d=new Demande(1485,new Date(2029,9,9),"en attente","demande de mintenace climatisuer",142,111,123,141);
        Demande_CRUD ddd=new Demande_CRUD();
        //System.out.println(ddd.Afficher_demande());
                
        //ddd.ajouter_Demande(new Demande(29,new Date(2025,12,26),"en cours","demande de mintenace des robinets",109));
        //ddd.modifier_demande(d, 22,3, 2018, "en attente","demande de mintenace du jardin",8);
        //ddd.supprimer_demande(1485);
        
        //ddd.chercher_demande(31);
        //ddd.ajouter_Demande(d);
        //ddd.consulter_demande();
        //ddd.updateDemande(31,new Date(2033,11,3),"fini","sssssssss");
        //d.jours_restants(d);
        //ddd.modifier_demande(d,);
        //ddd.ajouter_Demande(d);
        // ddd.ajouter_Demande(d);
        //ddd.consulter_demande();
        //Reclamation_CRUD rr = new Reclamation_CRUD();
        Reclamation r = new Reclamation(1,"gggg","hhhhh");
        //rr.ajouterReclamation(r);
        //rr.updateReclamation(r);
        //rr.chercher_reclamation(1);
        //rr.supprimer_reclamation(1);
        //System.out.println(rr.Consulter_Reclamation());
        
       // System.out.println(ddd.afficher_Demande()); 
        
    }
   
    }
