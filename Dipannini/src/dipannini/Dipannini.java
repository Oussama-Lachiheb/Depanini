/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dipannini;

import entities.promotion;
import entities.users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.promoCRUD;
import services.usersCRUD;
import util.MaConnexion;

/**
 *
 * @author Ayoub
 */
public class Dipannini extends Application {

    
      public static Stage primaryStage;

   

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        

        Dipannini.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/FirstForm.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        launch(args);
        // TODO code application logic here
        MaConnexion mc = MaConnexion.getInstance();
       // usersCRUD ucd = new usersCRUD();
       // users u = new users("00000","ayoub", "hamzaoui", "ayoub.hamzaoui@esprit.tn","admin", 99098672, "nkhilet", "");
       // ucd.login(u);
       // ucd.getRole();
//           users u6 = new users("00555","ayoub", "hamzaoui", "ayoub.hmz@esprit.tn","admin", 99098672, "nkhilet", "");
//        users u2 = new users("11111", "Hassan", "Hannachi", "hssan.hannachi@esprit.tn", "prestataire", 53268457, "ariena", "");
//        ucd.createuser(u);
        //ucd.createuser(u2);
        //ucd.deleteuser(4);
        //ucd.deleteuser(5);
          //ucd.login(u);
          //ucd.logout();
          //ucd.login(u6);
          //ucd.logout();
        //System.out.println(ucd.Afficherusers());
        //ucd.findbyid(4);
        
       //promoCRUD pcd = new promoCRUD();
       // promotion p = new promotion(322, "aaaa", 60, 40);
//        promotion p2 = new promotion(155, "plomberie", 70, 15);
//        promotion p3 = new promotion(203, "jardinage", 60, 40);
       // promotion p4 = new promotion(155, "bricolage", 80, 20);
//        promotion p5 = new promotion(111, "esprt", 66, 5);
        //promotion p9 = new promotion(155, "bricolage", 80, 20);

        //pcd.createpromo(p);
        //pcd.createpromo(p2);
        //pcd.createpromo(p3);
        //pcd.createpromo(p4);
       // System.out.println(pcd.afficherpromo());
        //pcd.deletepromo(3);
        //pcd.findbyname("messi");
         //pcd.createpromo(p5);
       // pcd.modifier_promotion(p9,5);
    }
    
    
}
