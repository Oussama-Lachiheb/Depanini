/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Rate;
import Models.RateInterface;
import Models.prestataire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MyConnection;

/**
 *
 * @author THINKPAD
 */
public class RateService implements RateInterface{

    @Override
    public void ajouterRate(Rate R,int id_Prestataire,int id_Client) {
 try {
            String requete2 = "INSERT INTO `Rate`(`rate`,id_Prestataire,id_Client) VALUES (?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            pst.setFloat(1, R.getRate());
            pst.setInt(2,id_Prestataire);
            pst.setInt(3, id_Client);
            pst.executeUpdate();
            System.out.println("the rate is added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @Override
    public void UpdateRate(Rate R) {
   try
    {
        String sql = "UPDATE Rate SET rate=? WHERE id =?";
   
    PreparedStatement pst = new MyConnection().getCnx().prepareStatement(sql);
            pst.setFloat(1, R.getRate());
            pst.setInt(2, R.getId());
            pst.executeUpdate();
            System.out.println("rate updated");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
}    
    }

    @Override
    public ObservableList<Rate> afficherRate() {
           ObservableList<Rate> myList = FXCollections.observableArrayList();

        try {
            String requete3 = "SELECT * FROM Rate";
            Statement st = new MyConnection().getCnx().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           Rate r = new Rate();
           r.setId(rs.getInt("id"));
           r.setRate(rs.getFloat("rate"));
           r.setId_Prestataire(rs.getInt("id_Prestataire"));
           r.setId_Client(rs.getInt("id_Client"));
           myList.add(r);
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return myList;    }

    @Override
    public void TopRated() {
String sql="SELECT prestataire.nom,prestataire.Prenom,AVG(rate) as rt FROM rate JOIN prestataire ON rate.id_Prestataire=prestataire.id_Prestataire GROUP BY rate.id_Prestataire ORDER BY AVG(rate) DESC;";
        PreparedStatement prp; 
        try {
            prp = new MyConnection().getCnx().prepareStatement(sql);
            ResultSet res=prp.executeQuery(sql);
            while(res.next()){
            System.out.println("   "+ res.getString("nom") +"   "+ res.getString("prenom")+"   " + res.getString("rt")+" !! "); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public ObservableList<Rate> YourRate(int id) {
                   ObservableList<Rate> myList = FXCollections.observableArrayList();

        String sql="select rate from Rate where id_Prestataire="+id;
             PreparedStatement prp; 
       Rate r = new Rate();
       r=null;
        try {
            prp = new MyConnection().getCnx().prepareStatement(sql);
             ResultSet res=prp.executeQuery(sql);
            while(res.next()){
                r=new Rate(res.getFloat("rate"));
                myList.add(r);
                //System.out.println(r.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(prestataire.class.getName()).log(Level.SEVERE, null, ex);
        }
           

          return myList;

    }
    @Override
     public String MoyRate(int id) {
         String re=null;
String sql="SELECT AVG(rate) as rt FROM rate where id_Prestataire="+id;
        PreparedStatement prp; 
        try {
            prp = new MyConnection().getCnx().prepareStatement(sql);
            ResultSet res=prp.executeQuery(sql);
            while(res.next()){
           re=String.valueOf(res.getFloat("rt")); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return re;
    }

    
}
