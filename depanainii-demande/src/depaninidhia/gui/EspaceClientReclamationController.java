/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depaninidhia.gui;

import entities.Reclamation;
import entities.Reclamation_CRUD;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EspaceClientReclamationController implements Initializable {

    @FXML
    private TextField typerec;
    @FXML
    private TextField descrecl;
    @FXML
    private Button ajouterreclamation;
    @FXML
    private Label erreur_rec;
    @FXML
    private Label addedlbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterreclamationdhia(ActionEvent event) {
        
      //  Class<? extends DatePicker> date = Calendrier.getClass();
    //  LocalDate date= LocalDate.of(Integer.parseInt(anneefield.getText()),Integer.parseInt(moisfield.getText()),Integer.parseInt(jourfield.getText()));
      if (typerec.getText().equals("")||descrecl.getText().equals("")){
          erreur_rec.setVisible(true);
      }
      else{
      erreur_rec.setVisible(false);

      String tyrec = typerec.getText();
      String desrecl = descrecl.getText();
      //int id_client=Integer.parseInt(idclientfield.getText());
        
        Reclamation r = new Reclamation(tyrec,desrecl);
        Reclamation_CRUD rc = new Reclamation_CRUD();
        rc.ajouterReclamation(r);
        addedlbl.setVisible(true);
        
      }
    }

    
}
