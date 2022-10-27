
package depanini;

import Interfaces.ServiceImpl;
import Interfaces.ServiceInterface;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Service;
import models.TopService;
import util.DBConnection;
import util.EmailSender;


public class Depanini extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        //Parent root;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainService.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Depanini.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Eroooooooooooor");
        }
        
        
    }
    

    public static void main(String[] args) {
        launch(args);
        
        //List<TopService> TopService()
       /* 
        Connection cnx = DBConnection.getConnection();
        if(cnx == null)
        {
            System.out.println("No Connection");
        }else{
            System.out.println("YES Connection");
        }
       */
       // ServiceInterface serviceinter = new ServiceImpl();
       // serviceinter.TopService().forEach(System.out::println);
        //serviceinter.findAll().forEach(System.out::println);
       /* 
        Service service = new Service(10,"Jardinnage", "fast", "HomeWork");
        Service service2 = new Service("Jardinnage", "fast", "home");
        Service service3 = new Service("ciné", "slow", "HomeWork");
       
        //serviceinter.addService(service3);
       serviceinter.updateService(service2);
     //  serviceinter.addService(service2);
       //serviceinter.delete(12);
       //Service ser = serviceinter.findById(8);
      //serviceinter.delete(15);
      //System.out.println(ser);
      serviceinter.findAll().forEach(System.out::println);
        
       
    }
    */
    }
}
