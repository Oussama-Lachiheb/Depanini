/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import JavaMail.javaMailUtil;
import Models.prestataire;
import Services.PrestataireService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class First_oussaController implements Initializable {

    @FXML
    private Button BTN_Sign;
    @FXML
    private TextField PF_nom;
    @FXML
    private TextField PF_prenom;
    @FXML
    private TextField PF_mdp;
    private TextField PF_role;
    @FXML
    private ChoiceBox<String> PF_service;
    @FXML
    private TextField PF_email;
    @FXML
    private TextField PF_localisation;
    @FXML
    private TextField PF_prix;
    private RadioButton PF_role1;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton prestataire;
    @FXML
    private RadioButton client;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PF_service.getItems().addAll(service);
        
        
    }    

    @FXML
    private void SavePrestataire(ActionEvent event) throws IOException, MessagingException {
        //Save BD
        String nom = PF_nom.getText(); 
        String prenom = PF_prenom.getText(); 
        String mot_de_passe = PF_mdp.getText(); 
        String role = get_role(event); 
        String service = getService(event); 
        String email = PF_email.getText(); 
        String localisation = PF_localisation.getText();
        String prix_heure = PF_prix.getText();
        
        prestataire p = new prestataire(nom,prenom,localisation,service,email,mot_de_passe,role,Integer.parseInt(prix_heure));
         if (nom.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre nom !!");
            alert.showAndWait();
        } 
         else if (prenom.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre prenom !!");
            alert.showAndWait();
        }
         else if (localisation.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre localisation !!");
            alert.showAndWait();
        }
         else if (service.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre service !!");
            alert.showAndWait();
        }
         else if (email.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre email !!");
            alert.showAndWait();
        }
         else if (mot_de_passe.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre mot de passe !!");
            alert.showAndWait();
        }
         else if (role.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Votre role !!");
            alert.showAndWait();
        }
         else if (prix_heure.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Prix heure !!");
            alert.showAndWait();
        }
         
        else if (email.matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" )){
        PrestataireService ps = new PrestataireService();
             ps.ajouterPrestataire(p);
            javaMailUtil.sendMail(email,"Inscription","vous avez inscri au depanini !\n\n votre mot de passe est : "+mot_de_passe);

        System.out.println("the service provider is added");}
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Email non valide !");
            alert.showAndWait();
        }
//}
       
        //JOptionPane.showConfirmDialog(this,null);
        
        //Redirection fadd.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("Affichage.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         scene.getStylesheets().add("/Css/app.css");
         mainStage.setScene(scene);
         mainStage.show();
        
    }

    @FXML
    private String get_role(ActionEvent event) {
        String role=null;
       if(prestataire.isSelected()){
        role= prestataire.getText();
       }
       else if(client.isSelected()){
           role=client.getText();
       }
       return role;
    }
    
    private String[] service ={"jardinier","plombier","electrecien"};
    
    public String getService(ActionEvent event){
        String service = PF_service.getValue();
    return service;
    }
    
}
