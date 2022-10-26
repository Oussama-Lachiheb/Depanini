/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import Models.prestataire;
import Services.PrestataireService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class AffichageController implements Initializable {
prestataire p = new prestataire();
    PrestataireService pss = new PrestataireService();
    ObservableList OL =  pss.afficherPrestataire();
    @FXML
    private TableColumn<?, ?> F_nom;
    @FXML
    private TableColumn<?, ?> F_prenom;
    @FXML
    private TableColumn<?, ?> F_local;
    @FXML
    private TableColumn<?, ?> F_service;
    @FXML
    private TableColumn<?, ?> F_email;
    @FXML
    private TableColumn<?, ?> F_role;
    @FXML
    private TableColumn<?, ?> F_prix;
    ObservableList<prestataire> oblist = FXCollections.observableArrayList();
    @FXML
    private Button fadd;
    @FXML
    private Button fDEL;
    @FXML
     TableView<prestataire> F_Affichage;
    @FXML
    private TableColumn<?, ?> F_id;
    @FXML
    private TableColumn<?, ?> F_mdp;
    @FXML
    private TextField F_id_f;
    @FXML
    private Button F_find;
    @FXML
    private Button acctu;
    @FXML
    private Button FRTE;
    @FXML
    private RadioButton R_int;
    @FXML
    private RadioButton R_idd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         F_Affichage.setEditable(true);
          ObservableList li = pss.afficherPrestataire();

            F_id.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
            F_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            F_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            F_local.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
            F_service.setCellValueFactory(new PropertyValueFactory<>("Service"));
            F_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            F_mdp.setCellValueFactory(new PropertyValueFactory<>("Mot_de_passe"));
            F_role.setCellValueFactory(new PropertyValueFactory<>("Role"));
            F_prix.setCellValueFactory(new PropertyValueFactory<>("Prix_heure"));      
            F_Affichage.setItems(li);
    }
//@FXML
   /* private String GetMetode(ActionEvent event) {
         String metode=null;
       if(R_int.isSelected()){
        metode= R_int.getText();
       }
       else if(R_idd.isSelected()){
           metode=R_idd.getText();
       }
       return metode;
    }*/
    @FXML
    private void AddPRES(ActionEvent event) throws IOException {
        fadd.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("First_oussa.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         scene.getStylesheets().add("/Css/app.css");
         mainStage.setScene(scene);
         mainStage.show();}
    


    @FXML
    private void DELETE_PRES(ActionEvent event) {
        int mr = F_Affichage.getSelectionModel().getSelectedItem().getId_Prestataire();
          PrestataireService ps = new PrestataireService();
        ObservableList PV =  ps.afficherPrestataire();
        ps.SuprimerPrestataire(mr);
        F_Affichage.setEditable(true);
        ps.afficherPrestataire();
         F_id.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
            F_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            F_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            F_local.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
            F_service.setCellValueFactory(new PropertyValueFactory<>("Service"));
            F_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            F_mdp.setCellValueFactory(new PropertyValueFactory<>("Mot_de_passe"));
            F_role.setCellValueFactory(new PropertyValueFactory<>("Role"));
            F_prix.setCellValueFactory(new PropertyValueFactory<>("Prix_heure"));
       
        PV =  ps.afficherPrestataire();
        F_Affichage.setItems(PV);
    }

    @FXML
    private void Find_Prestataire(ActionEvent event) {
        
        if(R_int.isSelected()){
            F_Affichage.setEditable(true);
            
           FilteredList<prestataire> filteredData = new FilteredList<>(OL, b -> true);
         //2. Set the filter Predicate whenever the filter changes.
         F_id_f.textProperty().addListener((observable, oldValue, newValue) -> {
         filteredData.setPredicate(p -> {
         // If filter text is empty, display all persons.
         if (newValue == null || newValue.isEmpty()) {
         return true;
         }
         // Compare first name and last name of every person with filter text.
         String lowerCaseFilter = newValue.toLowerCase();
         if (p.getNom().toLowerCase().contains(lowerCaseFilter)) {
         return true; // Filter matches last name.
         }
         else if (p.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
         return true;}
          else if (p.getLocalisation().toLowerCase().contains(lowerCaseFilter)) {
         return true;}
         //else if (String.valueOf(p.getId_Prestataire()).indexOf(lowerCaseFilter)!=-1){
         //return true;}
         else return String.valueOf(p.getId_Prestataire()).contains(lowerCaseFilter);
         });
         });
         SortedList<prestataire> sortedData = new SortedList<>(filteredData);
         // 4. Bind the SortedList comparator to the TableView comparator.
         // 	  Otherwise, sorting the TableView would have no effect.
         sortedData.comparatorProperty().bind(F_Affichage.comparatorProperty());
         // 5. Add sorted (and filtered) data to the table.
         F_Affichage.setItems(sortedData);}
        else if(R_idd.isSelected()){
            F_Affichage.setEditable(true);
        ObservableList li = pss.afficherPrestataire();
        int id = Integer.parseInt(F_id_f.getText());
        li =  pss.findPrestataire(id);
            F_id.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
            F_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            F_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            F_local.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
            F_service.setCellValueFactory(new PropertyValueFactory<>("Service"));
            F_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            F_mdp.setCellValueFactory(new PropertyValueFactory<>("Mot_de_passe"));
            F_role.setCellValueFactory(new PropertyValueFactory<>("Role"));
            F_prix.setCellValueFactory(new PropertyValueFactory<>("Prix_heure"));
            F_Affichage.setItems(li);}
        else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("your method !");
            alert.showAndWait();
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
        F_Affichage.setEditable(true);
          ObservableList li = pss.afficherPrestataire();

            F_id.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
            F_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            F_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            F_local.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
            F_service.setCellValueFactory(new PropertyValueFactory<>("Service"));
            F_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            F_mdp.setCellValueFactory(new PropertyValueFactory<>("Mot_de_passe"));
            F_role.setCellValueFactory(new PropertyValueFactory<>("Role"));
            F_prix.setCellValueFactory(new PropertyValueFactory<>("Prix_heure"));      
            F_Affichage.setItems(li);
    }

    @FXML
    private void Consulter_Rate(ActionEvent event) throws IOException {
        fadd.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("FXML_Top_rated.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         scene.getStylesheets().add("/Css/app.css");
         mainStage.setScene(scene);
         mainStage.show();
    }

    @FXML
    private void GetMetode(ActionEvent event) {
    }
    }



