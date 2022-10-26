
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depaninidhia.gui;

import entities.Demande;
import entities.Demande_CRUD;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EspaceAdminDemandeController implements Initializable {
    //Demande d=new Demande();
    //Demande_CRUD dd=new Demande_CRUD();
   // ObservableList<Demande> oblist = FXCollections.observableArrayList();
    @FXML
    private Button affichertabldhia ;
    @FXML
    private AnchorPane Afficher_dhia;
    @FXML
    private TableView<Demande> TableauAffichaged;
    
    @FXML
    private TableColumn<Demande,Date> DateDemande;
    @FXML
    private TableColumn<Demande, String> DescriptionDemande;
    @FXML
    private TableColumn<Demande, Integer> IdClients;
    @FXML
    private TableColumn<Demande, Integer> IdPrestataire;
    @FXML
    private TableColumn<Demande, Integer> IdService;
    @FXML
    private TableColumn<Demande, Integer> Idcategorie;
    @FXML
    private TableColumn<Demande, Integer> IdD;
    @FXML
    private Button suppdemande;
    @FXML
    private Button cherdemande;
    @FXML
    private TextField iddd_filed_dhia;
    int    id_selected_admin=0; 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    ObservableList<Demande> Tab = FXCollections.observableArrayList();
    @FXML
    private void AfficherTabl(ActionEvent event) {
        TableauAffichaged.getItems().clear();

        Demande_CRUD d=new Demande_CRUD();
        List <Demande> dem = d.afficher_Demande();
        dem.forEach(e->Tab.add(e)); 
        IdD.setCellValueFactory(new PropertyValueFactory<>("id_demande"));
        DateDemande.setCellValueFactory(new PropertyValueFactory<>("date_demande"));
        DescriptionDemande.setCellValueFactory(new PropertyValueFactory<>("description_demande"));
        IdClients.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        IdPrestataire.setCellValueFactory(new PropertyValueFactory<>("id_prestataire"));
        IdService.setCellValueFactory(new PropertyValueFactory<>("id_service"));
        Idcategorie.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
 

        TableauAffichaged.setItems(Tab);
        
    }

    @FXML
    private void afficherTAbleauDemandeAdmin(MouseEvent event) {
    }

    @FXML
    private void search_dem_dhia(ActionEvent event) {
        Demande_CRUD d=new Demande_CRUD();
        int iddd=Integer.parseInt(iddd_filed_dhia.getText());
        List <Demande> dem = d.afficher_Demande(iddd);
        dem.forEach(e->Tab.add(e)); 
        IdD.setCellValueFactory(new PropertyValueFactory<>("id_demande"));
        DateDemande.setCellValueFactory(new PropertyValueFactory<>("date_demande"));
        DescriptionDemande.setCellValueFactory(new PropertyValueFactory<>("description_demande"));
        IdClients.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        IdPrestataire.setCellValueFactory(new PropertyValueFactory<>("id_prestataire"));
        IdService.setCellValueFactory(new PropertyValueFactory<>("id_service"));
        Idcategorie.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
        
        TableauAffichaged.setItems(Tab);
        
        
        
    }

    @FXML
    private void select_admin_dhia(MouseEvent event) {
                id_selected_admin=TableauAffichaged.getSelectionModel().getSelectedItem().getId_demande();

    }

    @FXML
    private void del_dem_dhia(ActionEvent event) {
            Demande_CRUD dc = new Demande_CRUD();
        dc.supprimer_demande(id_selected_admin);
        id_selected_admin=0;
    }
    
}
