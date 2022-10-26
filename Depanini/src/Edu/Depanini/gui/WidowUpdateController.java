/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import Models.prestataire;
import Services.PrestataireService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class WidowUpdateController implements Initializable {
    prestataire p = new prestataire();
    PrestataireService ps = new PrestataireService();

    @FXML
    private TextField U_name;
    @FXML
    private TextField U_last;
    @FXML
    private TextField U_pass;
    @FXML
    private TextField U_email;
    @FXML
    private TextField PU_localisation;
    @FXML
    private TextField U_prix;
    @FXML
    private RadioButton U_prestataire;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton U_client;
    @FXML
    private ChoiceBox<String> U_service;
    @FXML
    private Button BTN_update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        U_service.getItems().addAll(service);
        // TODO
    }    
    

    @FXML
    private void UpdatePrestataire(ActionEvent event) throws IOException {
       
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard_Prestataire.fxml"));
            //Parent root = loader.load();
            //Dashboard_PrestataireController dpc = loader.getController();
            String nom = U_name.getText();
            String prenom = U_last.getText();
            String mot_de_passe = U_pass.getText();
            String role = get_role(event);
            String service = getService(event);
            String email = U_email.getText();
            String localisation = PU_localisation.getText();
            String prix_heure = U_prix.getText();
                    prestataire p = new prestataire(nom,prenom,localisation,service,email,mot_de_passe,role,Integer.parseInt(prix_heure));
                    ps.UpdatePrestataire(nom,prenom,localisation,service,email,mot_de_passe,role,Integer.parseInt(prix_heure));
         
    }
    
    @FXML
    private String get_role(ActionEvent event) {
        String role=null;
       if(U_prestataire.isSelected()){
        role= U_prestataire.getText();
       }
       else if(U_client.isSelected()){
           role=U_client.getText();
       }
       return role;
    }
    private String[] service ={"jardinier","plombier","electrecien"};
    
    public String getService(ActionEvent event){
        String service = U_service.getValue();
    return service;
    }
}
