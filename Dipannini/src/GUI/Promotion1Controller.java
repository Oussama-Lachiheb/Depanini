/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dipannini.Dipannini;
import entities.promotion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.promoCRUD;

/**
 * FXML Controller class
 *
 * @author Ayoub
 */
public class Promotion1Controller implements Initializable {

//    @FXML
//    private TextField tfidpromo;
    @FXML
    private TextField tfidser;
    @FXML
    private TextField tfnomser;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tftaux;
//    @FXML
//    private TextField tffinal;
    @FXML
    private Button btnadd;
    @FXML
    private Button btndelete;
    @FXML
    private TextArea screen;
    @FXML
    private TextField tffind;
    @FXML
    private Button btnfind;
    @FXML
    private Button Display;
    @FXML
    private Button Modify;
    
    promotion p = new promotion();
    promoCRUD pcd = new promoCRUD();
    
     ObservableList<promotion> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<promotion> promotiontable;
    @FXML
    private TableColumn<promotion, String> nomsercol;
    @FXML
    private TableColumn<promotion, Double> prixinitcol;
    @FXML
    private TableColumn<promotion, Integer> tauxcol;
    @FXML
    private TableColumn<promotion, Double> prixfinalcol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        promotiontable();
    }    

    private void promotiontable(){
        
        List<promotion> li = pcd.afficherpromo();

        li.forEach(e
                -> {
            oblist.add(e);
            nomsercol.setCellValueFactory(new PropertyValueFactory<>("nom_service"));
            prixinitcol.setCellValueFactory(new PropertyValueFactory<>("prix_heure_pres"));
            tauxcol.setCellValueFactory(new PropertyValueFactory<>("taux_promo"));
            prixfinalcol.setCellValueFactory(new PropertyValueFactory<>("prix_heure_final"));
              

        }
        );
        promotiontable.setItems(oblist);
    }
    
    @FXML
    private void add(MouseEvent event) {
        
        int ids = Integer.parseInt(tfidser.getText());
        screen.setText("Done");
        String nom = tfnomser.getText();
        double prix = Double.parseDouble(tfprix.getText());
        int taux = Integer.parseInt(tftaux.getText());
          promotion p = new promotion(ids, nom, prix, taux);
          p.setPrix_heure_final(p.prix_final(taux, prix));
        pcd.createpromo(p);
        screen.setText("Done");
        promotiontable.getItems().add(p);
        
        
        
    }

    @FXML
    private void delete(MouseEvent event) {
        
        promoCRUD pcd = new promoCRUD();
        promotion c =promotiontable.getSelectionModel().getSelectedItem();
        int id = c.getId_promo();
        pcd.deletepromo(id);
        screen.setText("Done");
        promotiontable.getItems().clear();
        promotiontable();
        
        
     
    }

    @FXML
    private void Find(MouseEvent event) {
       
      promotion p = null;
      String name = tffind.getText();
      p=pcd.findbyname(name);
      screen.setText("La promotion est de "+p.getTaux_promo()+"%");
      promotiontable.getItems().clear();
      promotiontable.getItems().add(p);
//      tfnomser.setText(p.getNom_service()); 
      tftaux.setText(""+p.getTaux_promo());
//      tfprix.setText(""+p.getPrix_heure_pres());
      
           
    }
    
    @FXML
    void modify(MouseEvent event) {
        
        promotion p = null;
        String name = tffind.getText();
        p=pcd.findbyname(name);
//        tftaux.setText(""+p.getTaux_promo());
        int taux = Integer.parseInt(tftaux.getText());
        p.setTaux_promo(taux);
        int id = p.getId_promo();
        pcd.modifier_promotion(p, id);
        screen.setText("La promotion est de "+p.getTaux_promo()+"%");
        
        
    }
    

    
    @FXML
    void refresh(MouseEvent event) {
       promotiontable.getItems().clear();
       promotiontable();
         
       
    }
    
    @FXML
    void remove(MouseEvent event) {
     
       promotiontable.getItems().clear();
       promotiontable();
       tffind.setText("");
       screen.setText("");
       tfnomser.setText("");
       tftaux.setText("");
       tfprix.setText("");
       
        
    }
    
}
