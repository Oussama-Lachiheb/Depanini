/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import util.MaConnexion;
import entities.promotion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayoub
 */
public class promoCRUD {
    
    
    Connection cnx2;
    
    
    public promoCRUD(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }
    
    
    
    
    public void createpromo(promotion p){
        
        try {
            String req = "INSERT INTO `promotion`(`id_service`, `nom_service`, `prix_heure_pres`, `taux_promo`, `prix_heure_final`) VALUES (?,?,?,?,?)";
            PreparedStatement st = cnx2.prepareStatement(req);
            
            st.setInt(1, p.getId_service());
            st.setString(2, p.getNom_service());
            st.setDouble(3, p.getPrix_heure_pres());
            st.setInt(4, p.getTaux_promo());
            st.setDouble(5, p.prix_final(p.getTaux_promo(), p.getPrix_heure_pres()));
            
            st.executeUpdate();
            System.out.println(" User Added successfuly");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public List<promotion> afficherpromo(){
        List<promotion> Li = new ArrayList<>();
        try {
            
            
            String req = "SELECT * FROM promotion";
            Statement st = cnx2.createStatement();
            ResultSet rs =st.executeQuery(req);
            while(rs.next()){
                promotion p = new promotion();
                p.setId_promo(rs.getInt(1));
                p.setId_service(rs.getInt(2));
                p.setNom_service(rs.getString(3));
                p.setPrix_heure_pres(rs.getDouble(4));
                p.setTaux_promo(rs.getInt(5));
                p.setPrix_heure_final(rs.getDouble(6));
                
                Li.add(p);
                
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Li;
    }
    
    
    public void deletepromo(int id){
        try {
            String req = "delete from promotion where id_promo=?"; 
            PreparedStatement st = cnx2.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Done");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public promotion findbyname(String name){
        promotion p = null;
        try {
            
            String req = "select * from promotion where nom_service=?";
            PreparedStatement st = cnx2.prepareStatement(req);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                p= new promotion(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getInt(5),
                rs.getDouble(6)           
                 );}
            
            System.out.println("La promotion est de "+p.getTaux_promo()+"%");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
        
    }
   
    public void modifier_promotion(promotion p, int id){
         String sql="update promotion set taux_promo="+p.getTaux_promo()+",prix_heure_final="+p.prix_final(p.getTaux_promo(), p.getPrix_heure_pres())+" where id_promo="+id;
        try {
            PreparedStatement prp = cnx2.prepareStatement(sql);
//             System.out.println("===> "+sql);
            prp.executeUpdate();
//            System.out.println("OKKKKKK");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   }
    
    
 }

    
   

    
   
    

