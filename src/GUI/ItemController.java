/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import models.Categorie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import Interfaces.MyListenerCategorie;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ItemController {
    @FXML
    private Label categorieName;

  

    private ImageView categorieImage;
    @FXML
    private AnchorPane CategoryItem;
   

    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(categorie);
    }

    private Categorie categorie;
    private MyListenerCategorie myListener;

    public void setData(Categorie categorie, MyListenerCategorie myListener) {
        this.categorie = categorie;
        this.myListener = myListener;
        categorieName.setText(categorie.getNom());
 
         FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("C:\\Users\\Mohamed\\Documents\\image\\" + categorie.getImage());
            Image image = new Image(inputstream, 100, 100, false, false);
            categorieImage.setImage(image);
        } catch (FileNotFoundException ex) {
            
        }
         System.out.println("zzzz");
    }

    @FXML
    private void CategoryItemClicked(MouseEvent mouseEvent) {
        
        myListener.onClickListener(categorie);
    }
}