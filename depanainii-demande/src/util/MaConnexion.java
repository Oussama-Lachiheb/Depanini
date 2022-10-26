/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.Demande;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class MaConnexion {
      final String URL="jdbc:mysql://localhost:3306/depanini";
        final String USER="root";
        final String PDW="";
        
        
        Connection con ;

    public Connection getCon() {
        return con;
    }        
           public MaConnexion(){
          try {
              con= DriverManager.getConnection(URL,USER,PDW);
              System.out.printf("systhem connect");
          } catch (SQLException ex) {
              Logger.getLogger(MaConnexion.class.getName()).log(Level.SEVERE, null, ex);
              System.out.printf("systhem nest pasconnect");
          }

           }
        

} 

