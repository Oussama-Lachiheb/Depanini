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
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EspaceClienDemandeController implements Initializable {
    // Demande d=new Demande();
  //  Demande_CRUD dd=new Demande_CRUD();
  //  ObservableList<Demande> oblist = FXCollections.observableArrayList();

    @FXML
    private TextField datej;
    @FXML
    private TextField datem;
    @FXML
    private TextField datey;
    @FXML
    private TextField descriptionDemandedh;
    @FXML
    private Button ModifierDemandedh;
    @FXML
    private Button SupprimerDemandedh;
    @FXML
    private Button AjouterDemandedh;
    private TextField EtatDemandedh;
    @FXML
    private TableView<Demande> afftableDemande;
    @FXML
    private TableColumn<Demande, Date> DateDemandedh;
    private TableColumn<Demande, String> Etatdemandedh;
    @FXML
    private TableColumn<Demande, String> descreptionDemandedh;
    @FXML
    private Button affdemande;
    @FXML
    private TextField id_client_field;
    @FXML
    private TableColumn<Demande, String> id_column;
    int id_selected=0;
    @FXML
    private Pane modif_pane_dhia;
    @FXML
    private TextField day_mdf;
    @FXML
    private TextField descrp_mdf;
    @FXML
    private TextField year_mdf;
    @FXML
    private TextField month_mdf;
    @FXML
    private Button conf_modif_dhia;
    @FXML
    private Label erreur_dem;
    @FXML
    private Label addedd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ModifierDemandedh(ActionEvent event) {
        modif_pane_dhia.setVisible(true);
       
    }

    @FXML
    private void SupprimerDemandedh(ActionEvent event) {
        Demande_CRUD dc = new Demande_CRUD();
        dc.supprimer_demande(id_selected);
        id_selected=0;
      
    }
    @FXML
    private void AjouterDemandedh(ActionEvent event) {
        //int id = Integer.parseInt(iddemande.getText());
        if (datej.getText().equals("")||datem.getText().equals("")||datey.getText().equals("")||descriptionDemandedh.getText().equals("")){
            erreur_dem.setVisible(true);
        }
       else{
                        erreur_dem.setVisible(false);

            try {
                int dny = Integer.parseInt(datey.getText());
                dny=dny-1900;
                int dnm = Integer.parseInt(datem.getText());
                dnm=dnm-1;
                int dnj = Integer.parseInt(datej.getText());
                //  Class<? extends DatePicker> date = Calendrier.getClass();
                //  LocalDate date= LocalDate.of(Integer.parseInt(anneefield.getText()),Integer.parseInt(moisfield.getText()),Integer.parseInt(jourfield.getText()));
                
                String desdem = descriptionDemandedh.getText();
                //int id_client=Integer.parseInt(idclientfield.getText());
                
                Demande d = new Demande(new Date(dny,dnm,dnj),desdem);
                Demande_CRUD dc = new Demande_CRUD();
                
                
                dc.ajouter_Demande(d);
                
                addedd.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(EspaceClienDemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
      
    }
     ObservableList<Demande> Tab = FXCollections.observableArrayList();   
    @FXML
    private void afficherdemande(ActionEvent event) {
        afftableDemande.getItems().clear();
        int id_cl=Integer.parseInt(id_client_field.getText());
        Demande_CRUD d=new Demande_CRUD();
        List <Demande> dem = d.afficher_Demande(id_cl);
        dem.forEach(e->Tab.add(e));
        DateDemandedh.setCellValueFactory(new PropertyValueFactory<>("date_demande"));
        descreptionDemandedh.setCellValueFactory(new PropertyValueFactory<>("description_demande"));
        afftableDemande.setItems(Tab);

    }
    @FXML
    private void selected_item_dhia(MouseEvent event) {
        id_selected=afftableDemande.getSelectionModel().getSelectedItem().getId_demande();
    }
    @FXML
    private void conf_modiff(ActionEvent event) {
        Demande_CRUD d=new Demande_CRUD();
        int iddd=id_selected;
        int yearr=Integer.parseInt(year_mdf.getText());
        yearr=yearr-1900;
        int monthh=Integer.parseInt(month_mdf.getText());
        monthh=monthh-1;
        int dayy=Integer.parseInt(day_mdf.getText());
        Date datee=new Date(yearr,monthh, dayy );
        String desccc=descrp_mdf.getText();
        d.updateDemande(iddd, datee, desccc);
        modif_pane_dhia.setVisible(false);

    }
}
    

