package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {  
     static final String URL = "jdbc:mysql://localhost:3306/depanini";
   private static final String HOST = "127.0.0.1";
   private static final int PORT = 3306;
   private static final String DB_NAME = "depanini";
   private static final String USR = "root";
   private static final String PWD ="";
   
   private static Connection connection;
   
   public static Connection getConnection() {
       try {
           connection = DriverManager.getConnection(URL,USR,PWD);
       }catch (SQLException se){
           se.printStackTrace(); 
       }
       return connection;
               
   }
 
    
}
