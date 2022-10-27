/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import models.Demande;
import models.Demande_CRUD;
import models.Reclamation;
import models.Reclamation_CRUD;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReclamationAdminController implements Initializable {
    Reclamation R=new Reclamation();
    Reclamation_CRUD rrr=new Reclamation_CRUD();
    ObservableList<Reclamation> oblist = FXCollections.observableArrayList();
    

    @FXML
    private TableView<Reclamation> tablereclamationadmin;
    @FXML
    private TableColumn<Reclamation, Integer> idreclamation;
    @FXML
    private TableColumn<Reclamation, String> typereclamation;
    @FXML
    private TableColumn<Reclamation, String> descriptionreclamation;
    @FXML
    private Button affreclamation;
    @FXML
    private Button serch_rec;
    @FXML
    private Button deleteclamation;
    int id_selected_rec_admin=0;
    @FXML
    private TextField id_search_dhia;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void affreclamation(ActionEvent event) {
       
    }
    ObservableList<Reclamation> Tabll = FXCollections.observableArrayList();
    @FXML
    private void affrtableclamation(ActionEvent event) {
        tablereclamationadmin.getItems().clear();

        Reclamation_CRUD rrr=new Reclamation_CRUD();
        List<Reclamation> li = rrr.Consulter_Reclamation();
           
        li.forEach(e-> Tabll.add(e));

            idreclamation.setCellValueFactory(new PropertyValueFactory<>("Id_Reclamation"));
            typereclamation.setCellValueFactory(new PropertyValueFactory<>("type"));
            descriptionreclamation.setCellValueFactory(new PropertyValueFactory<>("description"));
            
            
        tablereclamationadmin.setItems(Tabll);}

    @FXML
    private void selected_reclamation(MouseEvent event) {
        id_selected_rec_admin=tablereclamationadmin.getSelectionModel().getSelectedItem().getId_Reclamation();

    }

    @FXML
    private void search_rec_dhia(ActionEvent event) {
        int id=Integer.parseInt(id_search_dhia.getText());
        tablereclamationadmin.getItems().clear();

        Reclamation_CRUD rrr=new Reclamation_CRUD();
        List<Reclamation> li = rrr.Consulter_Reclamation(id);
           
        li.forEach(e-> Tabll.add(e));

            idreclamation.setCellValueFactory(new PropertyValueFactory<>("Id_Reclamation"));
            typereclamation.setCellValueFactory(new PropertyValueFactory<>("type"));
            descriptionreclamation.setCellValueFactory(new PropertyValueFactory<>("description"));
            
            
        tablereclamationadmin.setItems(Tabll);
        
        
        
    }

    @FXML
    private void dell_rec_dhia(ActionEvent event) {
        Reclamation_CRUD dc = new Reclamation_CRUD();
        dc.supprimer_reclamation(id_selected_rec_admin);
        id_selected_rec_admin=0;
     
    }
    }
    

