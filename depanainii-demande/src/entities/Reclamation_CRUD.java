/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import Models.ReclamationInterface;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MaConnexion;

/**
 *
 * @author asus
 */
public class Reclamation_CRUD implements ReclamationInterface{

    @Override
    public void ajouterReclamation(Reclamation R) {
        try {
            String requete2 = "INSERT INTO `Reclamation`(`Description`,type) VALUES (?,?)";
            PreparedStatement pst = new MaConnexion().getCon().prepareStatement(requete2);
            pst.setString(1, R.getDescription());
            pst.setString(2,R.getType());
            //pst.setInt(3,R.getId_client());
            //pst.setInt(4,R.getId_prestataire());
            pst.executeUpdate();
            System.out.println("the rate is added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }

    
    public void updateReclamation(Reclamation r,String description,String service) {
        
               try
    {
        String sql = "UPDATE Reclamation SET Description=?, type=? WHERE id_Reclamation=?";
   
 
    PreparedStatement pst = new MaConnexion().getCon().prepareStatement(sql);
            pst.setString(1, description);        
            pst.setString(2, service);
            pst.setInt(3, r.getId_Reclamation());
            pst.executeUpdate();
            System.out.println("Reclamation updated");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
}
    }

    

    @Override
    public ObservableList<Reclamation> Consulter_Reclamation() {
           ObservableList<Reclamation> myList = FXCollections.observableArrayList();

        try {
            String requete3 = "SELECT * FROM Reclamation";
            Statement st = new MaConnexion().getCon().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           Reclamation R = new Reclamation();
           R.setId_Reclamation(rs.getInt("id_Reclamation"));
           R.setDescription(rs.getString("description"));
           R.setType(rs.getString("type"));
            
           myList.add(R);
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return myList;
    }
      public ObservableList<Reclamation> Consulter_Reclamation(int id) {
           ObservableList<Reclamation> myList = FXCollections.observableArrayList();

        try {
            String requete3 = "SELECT * FROM Reclamation where Id_Reclamation="+id;
            Statement st = new MaConnexion().getCon().createStatement();
           ResultSet rs =  st.executeQuery(requete3);
           while(rs.next()){
           Reclamation R = new Reclamation();
           R.setId_Reclamation(rs.getInt("id_Reclamation"));
           R.setDescription(rs.getString("description"));
           R.setType(rs.getString("type"));
            
           myList.add(R);
           }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    
    return myList;
    }

    @Override
    public void supprimer_reclamation(int id) {
        
        try {
            String rq="DELETE FROM reclamation WHERE id_reclamation="+id;
            PreparedStatement pst = new MaConnexion().getCon().prepareStatement(rq);
           // pst.setInt(1,p.getId_Reclamation());
            pst.executeUpdate();
                System.out.println("Reclamation was deleted successfully!");
            } catch (SQLException ex) {      
            System.out.println(ex.getMessage());
        }
    

    }
    @Override
    public Reclamation chercher_reclamation(int id){
        String sql="select * from reclamation where id_reclamation="+id;
        PreparedStatement prp; 
        LinkedList <Reclamation> l=new LinkedList<>();
        Reclamation x=null;

        try {
            prp = new MaConnexion().getCon().prepareStatement(sql);
             ResultSet res=prp.executeQuery(sql);
            while(res.next()){
                x=new Reclamation(res.getInt(1),res.getString(2),res.getString(3));
                l.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demande.class.getName()).log(Level.SEVERE, null, ex);
        }
           for (int i=0;i<l.size();i++){
              if (l.get(i).getId_Reclamation()==id){
                  System.out.println("Reclamation trouvé");
                  x=l.get(i);
              }
          }

          return x;
     } 

    @Override
    public void updateReclamation(Reclamation R) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
    
    

