/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import Models.Rate;
import Services.RateService;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class FXML_top_ratedController implements Initializable {
    Rate r = new Rate();
    RateService rss = new RateService();
    ObservableList<Rate> li = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> ff_rt;
    @FXML
    private TableView<?> f_top;
    @FXML
    private TableColumn<?, ?> ff_id_rate;
    @FXML
    private TableColumn<?, ?> ff_id_client;
    @FXML
    private TableColumn<?, ?> ff_id_prestataire;
    @FXML
    private Button F_actualiser_ouss;
    @FXML
    private Button ff_Retour;
    @FXML
    private RadioButton F_to_ouss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void ActualiserTableRate(ActionEvent event) {
        
        
        String sql="SELECT prestataire.nom,prestataire.Prenom,AVG(rate) as rt FROM rate JOIN prestataire ON rate.id_Prestataire=prestataire.id_Prestataire GROUP BY rate.id_Prestataire ORDER BY AVG(rate) DESC;";
        PreparedStatement prp; 
        try {
            prp = new MyConnection().getCnx().prepareStatement(sql);
            ResultSet res=prp.executeQuery(sql);
            while(res.next()){
            System.out.println("   "+ res.getString("nom") +"   "+ res.getString("prenom")+"   " + res.getString("rt")+" !! "); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        /* f_top.setEditable(true);
          ObservableList li ;
          li = (ObservableList) rss.afficherRate();
          
            ff_id_rate.setCellValueFactory(new PropertyValueFactory<>("id"));
            ff_rt.setCellValueFactory(new PropertyValueFactory<>("rate"));
            ff_id_prestataire.setCellValueFactory(new PropertyValueFactory<>("id_Prestataire"));
            ff_id_client.setCellValueFactory(new PropertyValueFactory<>("id_Client"));      
            f_top.setItems(li);*/
            
    }

    @FXML
    private void Retour_ouss(ActionEvent event) throws IOException {
        ff_Retour.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("Affichage.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         scene.getStylesheets().add("/Css/app.css");
         mainStage.setScene(scene);
         mainStage.show();
    }
    
}
