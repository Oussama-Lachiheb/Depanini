 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import util.MaConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Demande {
    private int id_demande ;
    private Date date_demande;
    private String description_demande;  
    private int id_client;
    private int id_categorie;
    private int id_prestataire;
   private int id_service;
    public Demande(int id, Date date_demande,  String description ,int id_client,int id_categorie,int id_prestataire,int id_service) {
        this.id_demande = id;
        this.date_demande = date_demande;
        this.description_demande = description;
        this.id_client = id_client;
        this.id_prestataire = id_prestataire;
        this.id_categorie = id_categorie;
        this.id_service = id_service;
    }


    @Override
    public String toString() {
        return "Demande{" + "id_demande=" + id_demande + ", date_demande=" + date_demande +  ", description_demande=" + description_demande + ", id_client=" + id_client + ", id_categorie=" + id_categorie + ", id_prestataire=" + id_prestataire + ", id_service=" + id_service + '}';
    }
    

    public Demande(int id, Class<? extends DatePicker> date, String desdem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    Demande(int aInt, Date date, String string, String string0, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    public int getId_demande() {
        return id_demande;
    }
    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }
    public Date getDate_demande() {
        return date_demande;
    }
    public void setDate_demande(Date date_demande) {
        this.date_demande = date_demande;
    }
    public String getDescription_demande() {
        return description_demande;
    }
    public void setDescription_demande(String description_demande) {
        this.description_demande = description_demande;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public Demande (){  
    }
    public int getId_client() {
        return id_client;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public int getId_prestataire() {
        return id_prestataire;
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public Demande(Date date_demande, String description_demande) {
        this.date_demande = date_demande;
        this.description_demande = description_demande;
        
    }
     /*public void jours_restants(Demande d){
      LocalDate now;
      now = LocalDate.now();
      long diff = ChronoUnit.DAYS.between(now,d.getDate());
      System.out.println ("Days: " + Math.abs(diff));

      
       
   }*/
    
}
