
package Interfaces;

import GUI.CategorieClientController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Service;
import models.TopService;
//import models.TopService;
import util.DBConnection;


public class ServiceImpl implements ServiceInterface {

    @Override
    public ObservableList<Service> findAll() {
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return null;
        }
        
        ObservableList<Service> services =  FXCollections.observableArrayList();
        
        
        String requete = "SELECT * FROM service;";
        
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Service service = new Service(resultSet.getInt("id_service"),resultSet.getString("nom_service"),resultSet.getString("description"),resultSet.getString("categorie"));
                services.add(service);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return services;
    }

    @Override
    public Service findById(int id_Service) {
         Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return null;
        }
        
        String requete = "SELECT * FROM service WHERE id_service =?;";
        
        try(PreparedStatement prepareStatement = cnx.prepareStatement(requete)){
            
            prepareStatement.setInt(1,id_Service);
            ResultSet resultSet = prepareStatement.executeQuery();
            if(resultSet.next()){
                Service service = new Service(resultSet.getInt("id_service"),resultSet.getString("nom_service"),resultSet.getString("description"),resultSet.getString("categorie"));
                return service;
            }
                  
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
        
       return null;
    }

    @Override
    public void addService(Service service) {
        
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return ;
        }
        else{
                                  //CREATE
            String requete = "INSERT INTO service(nom_service,description,categorie)VALUES (?,?,?);";
            try(PreparedStatement prepareStatement = cnx.prepareStatement(requete)) {
               // prepareStatement.setInt(0, service.getId_Service());
                prepareStatement.setString(1, service.getNom_Service());
                prepareStatement.setString(2, service.getService_Description());
                prepareStatement.setString(3, service.getCategorie());
                
                prepareStatement.executeUpdate();
                System.out.println("Added successfully");
              //  prepareStatement.close();   We can incomment it with draging PrepareStatement initializing out of try()
                 
            } catch (SQLException ex) {
               ex.printStackTrace();
            }finally {
                try {
                    cnx.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
       
    }
    
    public void updateService(Service service){
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return;
        }
        else{
            if(service.getId_Service()>0){
            //UPDATE
            String requete = "UPDATE service SET nom_service=?, description=?, categorie=? WHERE id_service=?;";
            try(PreparedStatement prepareStatement = cnx.prepareStatement(requete)) {
         
                prepareStatement.setString(1, service.getNom_Service());
                prepareStatement.setString(2, service.getService_Description());
                prepareStatement.setString(3, service.getCategorie());
                prepareStatement.setInt(4, service.getId_Service());
                
                prepareStatement.executeUpdate();
                System.out.println("Updated successfully");
              //  prepareStatement.close();   We can incomment it with draging PrepareStatement initializing out of try()
                 
            } catch (SQLException ex) {
               ex.printStackTrace();
            }finally {
                try {
                    cnx.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }



            
        }
        }
    }
   

    @Override
    public void delete(int id_Service) {
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return ;
        }
        
        String requete = "DELETE FROM service WHERE id_service=?;";
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            
            preparedStatement.setInt(1,id_Service);
            preparedStatement.executeUpdate();
            
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
                
        }
    }
  
    @Override
    public ObservableList<TopService> TopService(){
        Connection cnx = DBConnection.getConnection();
        if(cnx == null)
            return null;
        
        ObservableList<TopService> topservices = FXCollections.observableArrayList();
        
        
        String requete = "SELECT nom_service, COUNT(nom_service) FROM service GROUP BY nom_service ORDER BY DESC;";
        
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                TopService topservice = new TopService(resultSet.getString("nom_service"),resultSet.getInt("COUNT(nom_service)"));
                topservices.add(topservice);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return topservices;
       
    }
    
    ////MARKETLIST
    @Override
    public List<Service> findAllMarket() {
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return null;
        }
        
        List<Service> marketservices =  new ArrayList();
        
        
        String requete = "SELECT nom_service,description,categorie FROM service;";
        
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Service service = new Service(resultSet.getString("nom_service"),resultSet.getString("description"),resultSet.getString("categorie"));
                marketservices.add(service);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return marketservices;
    }
    
    
     @Override
    public List<Service> findByCategorie() {
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return null;
        }
        CategorieClientController ccc = new CategorieClientController();
        List<Service> marketCategorie =  new ArrayList();
        
        
        String requete = "SELECT nom_service,description,categorie FROM service WHERE categorie = ?;";
        
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            preparedStatement.setString(1, ccc.id_categorie);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Service service = new Service(resultSet.getString("nom_service"),resultSet.getString("description"),resultSet.getString("categorie"));
                marketCategorie.add(service);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return marketCategorie;
    }
    
    
    
    
     @Override
    public ObservableList<String> comboList() {
        Connection cnx = DBConnection.getConnection();
        if(cnx == null){
            return null;
        }
        
        ObservableList<String> categories =  FXCollections.observableArrayList();
        
        
        String requete = "SELECT categorie FROM service;";
        
        try(PreparedStatement preparedStatement = cnx.prepareStatement(requete)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String s = (resultSet.getString("categorie"));
                categories.add(s);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            try{
                cnx.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return categories;
    }
    
}
