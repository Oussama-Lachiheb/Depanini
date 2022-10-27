/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ayoub
 */
public class MaConnexion {
    //Const
    final String URL = "jdbc:mysql://localhost:3306/depanini";
    final String USR = "root";
    final String PWD = "";
    
    //var
    Connection cnx;
    public static MaConnexion instance;
    
    
    //constructeur
    
    private MaConnexion(){
     try {
         cnx = DriverManager.getConnection(URL,USR,PWD);
         System.out.print("Connexion etablie!");
     } catch (SQLException ex){
         System.out.print(ex.getMessage());
     }
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
    public static MaConnexion getInstance(){
        if(instance == null)
        {
            instance = new MaConnexion();
        }
        return instance;
        
    }
    
    
    
}
    

