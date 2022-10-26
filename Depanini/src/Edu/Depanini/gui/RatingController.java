/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.Depanini.gui;

import Models.Rate;
import Services.RateService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author THINKPAD
 */
public class RatingController implements Initializable {

    @FXML
    private TextField R_id_p;
    @FXML
    private TextField R_id_c;
    @FXML
    private Button RATE;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r4;
    @FXML
    private RadioButton r3;
    @FXML
    private RadioButton r5;
    @FXML
    private ToggleGroup rate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RATING(ActionEvent event) {
        String ID_PRE= R_id_p.getText(); 
        String ID_CL = R_id_c.getText(); 
        String rate = get_rate(event); 
        Rate r = new Rate(Integer.parseInt(rate),Integer.parseInt(ID_PRE),Integer.parseInt(ID_CL));
        RateService rs = new RateService();
             rs.ajouterRate(r,Integer.parseInt(ID_PRE),Integer.parseInt(ID_CL));
    }

    @FXML
    private String get_rate(ActionEvent event) {
        String rate=null;
       if(r1.isSelected()){
        rate= r1.getText();
       }
       else if(r2.isSelected()){
           rate=r2.getText();
       }
       else if(r3.isSelected()){
           rate=r3.getText();
       }
       else if(r4.isSelected()){
           rate=r4.getText();
       }
       else if(r5.isSelected()){
           rate=r5.getText();
       }
       return rate;
    }
    }
    
    
