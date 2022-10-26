/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.PrestataireInterface;
import Models.prestataire;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import util.MyConnection;

/**
 *
 * @author THINKPAD
 */
public class PrestataireService implements PrestataireInterface {
    
    /**
     *
     */
    @Override
    public void ajouterPrestataire(prestataire p) {
        try {
            String requete2 = "INSERT INTO `prestataire`(`nom`, `prenom`, `localisation`, `service`, `email`, `mot_de_passe`, `role`, `prix_heure`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
           // pst.setInt(1, p.getId_Prestataire());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getLocalisation());
            pst.setString(4, p.getService());
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getMot_de_passe());
            pst.setString(7, p.getRole());
            pst.setDouble(8, (float) p.getPrix_heure());
            pst.executeUpdate();
            System.out.println("the service provider is added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
       
    }

    @Override
    public void SuprimerPrestataire(int id) {
        try {
            String rq="DELETE FROM `prestataire` WHERE id_Prestataire="+id;
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(rq);
            //pst.setInt(1,p.getId_Prestataire());
            pst.executeUpdate();
                System.out.println("A service provider was deleted successfully!");
            } catch (SQLException ex) {      
            System.out.println(ex.getMessage());
        }
    }
@Override
    public ObservableList<prestataire> findPrestataire(int id) {
                   ObservableList<prestataire> myList = FXCollections.observableArrayList();

        String sql="select * from prestataire where id_Prestataire="+id;
             PreparedStatement prp; 
       prestataire p = new prestataire();
       p=null;
        try {
            prp = new MyConnection().getCnx().prepareStatement(sql);
             ResultSet res=prp.executeQuery(sql);
            while(res.next()){
                p=new prestataire(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9));
                myList.add(p);
                //System.out.println(p.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(prestataire.class.getName()).log(Level.SEVERE, null, ex);
        }
           

          return myList;

    }
    

    @Override
    public ObservableList<prestataire> afficherPrestataire() {
           ObservableList<prestataire> myList = FXCollections.observableArrayList();

        try {
            String requete3 = "SELECT * FROM prestataire";
            Statement st = new MyConnection().getCnx().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           prestataire p = new prestataire();
           p.setId_Prestataire(rs.getInt("id_Prestataire"));
           p.setNom(rs.getString("nom"));
           p.setPrenom(rs.getString("prenom"));
           p.setLocalisation(rs.getString("localisation"));
           p.setService(rs.getString("service"));
           p.setEmail(rs.getString("email"));
           p.setMot_de_passe(rs.getString("mot_de_passe"));
           p.setRole(rs.getString("role")); 
           p.setPrix_heure(rs.getDouble("prix_heure"));  
           myList.add(p);
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return myList;
    }

    @Override
    public void UpdatePrestataire(String nom,String prenom,String localisation,String service,String email,String mot_de_passe,String role,float prix_heure) {
       try
    {
        String sql = "UPDATE prestataire SET nom=?, prenom=?, Localisation=?, service=?, mot_de_passe=?, role=?, prix_heure=? WHERE email like '"+email+"'";
       
 
    PreparedStatement pst = new MyConnection().getCnx().prepareStatement(sql);
            pst.setString(1,nom);        
            pst.setString(2, prenom); 
            pst.setString(3, localisation);
            pst.setString(4, service);
            pst.setString(5, mot_de_passe);
            pst.setString(6, role);
            pst.setDouble(7, prix_heure);
            pst.executeUpdate();
            System.out.println("service provider updated");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
}
    }

    /*@Override
    public void Toprated() {
         

        try {
            String rqt = "SELECT * FROM prestataire order BY rate DESC;";
            Statement st = new MyConnection().getCnx().createStatement();
           ResultSet rs =  st.executeQuery(rqt);
           while(rs.next()){
           prestataire p = new prestataire();
           p.setId_Prestataire(rs.getInt("id_Prestataire"));
           p.setLocalisation(rs.getString("nom"));
           p.setLocalisation(rs.getString("prenom"));
           p.setLocalisation(rs.getString("localisation"));
           p.setService(rs.getString("service"));
           p.setEmail(rs.getString("email"));
           //p.setMot_de_passe(rs.getString("mot_de_passe"));
           p.setRole(rs.getString("role")); 
           p.setPrix_heure(rs.getDouble("prix_heure")); 
           System.out.println("   " + rs.getString("id_Prestataire")+" ! " + rs.getString("nom")+" ! " + rs.getString("prenom")+" ! " + rs.getString("localisation")+" ! " + rs.getString("service")+" ! " + rs.getString("email")+" ! "  + rs.getString("role")+" ! " + rs.getDouble("prix_heure")+" ! " + " ! ");
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    }

  }
    }*/
    
   public List<prestataire> TopRated1() {
        List<prestataire> myList = new ArrayList();
String sql="SELECT prestataire.nom,prestataire.Prenom,AVG(rate) as rt FROM prestataire JOIN rate Where prestataire.id_Prestataire=rate.id_Prestataire GROUP BY rate.id_Prestataire ORDER BY AVG(rate) DESC;";
         
        prestataire p = new prestataire();
       p=null;
        try {
            Statement prp;
            prp = new MyConnection().getCnx().createStatement();
            ResultSet res=prp.executeQuery(sql);
            while(res.next()){
                p=new prestataire();
                p.setNom(res.getString("nom"));
                p.setPrenom("prenom");
                p.setRate(res.getFloat("rt"));
                myList.add(p);
            //System.out.println("   "+ res.getString("nom") +"   "+ res.getString("prenom")+"   " + res.getString("rt")+" !! "); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return myList;
    }

    @Override
    public int getIDDps(String email) {
        int id=0;
        try {
            String requete3 = "SELECT id_Prestataire FROM prestataire where email="+email;
            Statement st = new MyConnection().getCnx().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           prestataire p = new prestataire();
           p.setId_Prestataire(rs.getInt("id_Prestataire"));
           id=p.getId_Prestataire();
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return id;
    
    }
    
}
