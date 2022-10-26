/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import Models.Rate;
import Models.prestataire;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class TOPRATEDADMIN_oussamaController implements Initializable {

    @FXML
    private TableColumn<prestataire,String> F_Name_OUSS;
    @FXML
    private TableColumn<prestataire,String> F_LA_oussa;
    @FXML
    private TableColumn<Rate,String> F_rate_ouss;
    @FXML
    private Button F_ref;
    @FXML
    private TableView<?> F_top_r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void REFRESH(ActionEvent event) {
        
    }
    
}
