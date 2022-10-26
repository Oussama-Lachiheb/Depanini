/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import JavaMail.javaMailUtil;
import Models.Rate;
import Models.prestataire;
import Services.PrestataireService;
import Services.RateService;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class Dashboard_PrestataireController implements Initializable {
    Rate r = new Rate();
    RateService rss = new RateService();
    prestataire p = new prestataire();
    PrestataireService ps =new PrestataireService();
    ObservableList<Rate> li = FXCollections.observableArrayList();

    @FXML
    private TextField F_idd;
    @FXML
    private Button f_refrech;
    @FXML
    private TableView<?> table_col;
    @FXML
    private Button modif_ouss;
    @FXML
    private Button rateonepres;
    @FXML
    private Button decc_ouss;
    @FXML
    private TableColumn<?, ?> F_rt;
    @FXML
    private Label F_ratee;
    @FXML
    private Button F_del_Accou;
    //int id= Integer.parseInt(F_idd.getText());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           // int id= Integer.parseInt(F_idd.getText());

    }    
//int id= Integer.parseInt(F_idd.getText());
    @FXML
    private void Update_Acc(ActionEvent event) throws IOException {
        
        modif_ouss.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("WidowUpdate.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         scene.getStylesheets().add("/Css/app.css");
         mainStage.setScene(scene);
         mainStage.show();
        /*int id= Integer.parseInt(F_idd.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WidowUpdate.fxml"));
        Parent root = loader.load();
        modif_ouss.getScene().getWindow().hide();
         //Parent root = FXMLLoader.load(getClass().getResource("WindowUpdate.fxml"));
         Stage mainStage = new Stage();
         Scene scene = new Scene(root);
         mainStage.setScene(scene);
         mainStage.show();*/
    }

    @FXML
    private void Rate(ActionEvent event) {
        String id  = F_idd.getText();
        F_ratee.setText(rss.MoyRate(parseInt(id)));
        
    }

    @FXML
    private void Deconnexion_pre(ActionEvent event) {
    }

    @FXML
    private void Refrech_rate(ActionEvent event) {
         table_col.setEditable(true);
          ObservableList li ;
          String id  = F_idd.getText();
          li = (ObservableList) rss.YourRate(parseInt(id));
            F_rt.setCellValueFactory(new PropertyValueFactory<>("rate"));      
            table_col.setItems(li);
    }

    @FXML
    private void Delete_Account_pres(ActionEvent event) {
        try {
            String id  = F_idd.getText();
            String email = p.getEmail();
            String pass = p.getMot_de_passe();
            ps.SuprimerPrestataire(parseInt(id));
            javaMailUtil.sendMail(email,"Inscription","vous avez inscri au depanini !\n\n votre mot de passe est : "+pass);
        } catch (MessagingException ex) {
            Logger.getLogger(Dashboard_PrestataireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
