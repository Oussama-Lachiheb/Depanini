/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Interfaces.DemandeInterface;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import util.MaConnexion;

/**
 *
 * @author asus
 */
public class Demande_CRUD {
    
    public void ajouter_Demande(Demande C ) throws ParseException{ 
        String sql="insert into Demande values (?,?,?,?,?,?,?)";
       
        PreparedStatement prp; //t3awedh les poin d interogation
        try {
            prp = new MaConnexion().getCon().prepareStatement(sql); //bech t3abi requette
            prp.setInt(1, C.getId_demande());
            prp.setDate(2,C.getDate_demande());
            prp.setString(3, C.getDescription_demande());            
            prp.setInt(4, C.getId_client());
            prp.setInt(5, C.getId_prestataire());
            prp.setInt(6, C.getId_service());
            prp.setInt(7, C.getId_categorie());
            prp.executeUpdate();
            System.out.println("Demande ajoutée avec succés");



        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Probleme de connexion", null, JOptionPane.ERROR_MESSAGE);
        }
}
    
   public void supprimer_demande (int identt){
        //int ident =Integer.parseInt(JOptionPane.showInputDialog("Veuillez enter l'identifent de la demande a supprimer"));

        String sql="DELETE FROM Demande WHERE id_demande=?";
         PreparedStatement prp;
        try {
            prp = new MaConnexion().getCon().prepareStatement(sql);
            prp.setInt(1, identt);
            prp.executeUpdate();
            System.out.println("Demande supprimé avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Probleme de connexion");
        }
    }
    public Demande chercher_demande(int id){
        String sql="select * from Demande where id_demande="+id;
        PreparedStatement prp; 
        LinkedList <Demande> l=new LinkedList<>();
        Demande x=null;

        try {
            prp = new MaConnexion().getCon().prepareStatement(sql);
             ResultSet res=prp.executeQuery(sql);
            while(res.next()){
                x=new Demande(res.getInt(1),res.getDate(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getInt(7));
                l.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
        }
           for (int i=0;i<l.size();i++){
              if (l.get(i).getId_demande()==id){
                  System.out.println("client trouvé");
                  x=l.get(i);
              }
          }
           
          return x;
     }  
    
     public ObservableList<Demande> Consulter_Demande() {
           ObservableList<Demande> myList = FXCollections.observableArrayList();

        try {
            String requete3 = "SELECT * FROM demande";
            Statement st = new MaConnexion().getCon().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           Demande D = new Demande();
           D.setId_demande(rs.getInt("id_demande"));
           D.setDate_demande(rs.getDate("date_demande"));
           D.setDescription_demande(rs.getString("description_demande"));
           D.setId_client(rs.getInt("id_client"));
           D.setId_categorie(rs.getInt("id_categorie"));
           D.setId_prestataire(rs.getInt("id_prestataire"));
           D.setId_service(rs.getInt("id_service"));
           myList.add(D);
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());   
        }
    
    return myList;
    }
    
    
       public void updateDemande(int id,Date date, String descreption ) {
        String req="UPDATE demande SET  date_demande =?,description_demande=? WHERE id_demande=?";
        try{
            PreparedStatement pst;
            pst = new MaConnexion().getCon().prepareStatement(req);
           // pst = cnx2.prepareStatement(req);
            
            pst.setDate(1, (Date) date);
            pst.setString(2, descreption);
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Modified successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

     public ObservableList<Demande> afficher_Demande(int id_client){
        String sql="select * from Demande where id_client="+id_client;
        ObservableList <Demande> l=FXCollections.observableArrayList();

        PreparedStatement prp;
        try {
            prp = new MaConnexion().getCon().prepareStatement(sql);
            ResultSet res=prp.executeQuery(sql);

           // System.out.println("====================Liste Des Client========================");
            Demande x=null;
            while(res.next()){
             //   System.out.println(res.getString("nom")+"|"+res.getString("prenom")+"|"+res.getString("email")+"|"+res.getString("mot_de_passe")+"|"+res.getString("adresse")+"|"+res.getString("telephone")+"|"+res.getString("id"));
                x=new Demande(res.getInt("id_demande"),res.getDate("date_demande"),res.getString("description_demande"),res.getInt("id_client"),res.getInt("id_prestataire"),res.getInt("id_service"),res.getInt("id_categorie"));
                l.add(x);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return l;
    }
     public ObservableList<Demande> afficher_Demande(){
        String sql="select * from Demande";
        ObservableList <Demande> l=FXCollections.observableArrayList();

        PreparedStatement prp;
        try {
            prp = new MaConnexion().getCon().prepareStatement(sql);
            ResultSet res=prp.executeQuery(sql);

           // System.out.println("====================Liste Des Client========================");
            Demande x=null;
            while(res.next()){
             //   System.out.println(res.getString("nom")+"|"+res.getString("prenom")+"|"+res.getString("email")+"|"+res.getString("mot_de_passe")+"|"+res.getString("adresse")+"|"+res.getString("telephone")+"|"+res.getString("id"));
                x=new Demande(res.getInt("id_demande"),res.getDate("date_demande"),res.getString("description_demande"),res.getInt("id_client"),res.getInt("id_prestataire"),res.getInt("id_service"),res.getInt("id_categorie"));
                l.add(x);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return l;
    }

    
}

