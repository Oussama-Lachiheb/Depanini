/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.ServiceImpl;
import Interfaces.ServiceInterface;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import depanini.Depanini;
import depanini.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import models.Service;
import models.TopService;

/**
 * FXML Controller class
 *
 * @author Hannachi
 */
public class MainServiceController implements Initializable {
    
    @FXML
    private TextField ServiceName;
    
    @FXML
    private TextArea ServiceDescription; 

    @FXML
    private ComboBox<String> myCombo;
    
    //private String[] categories = {"Jardinnage","Plomberie","Electricté","Menage","Drug Store"};
    
    //private List<String> list ;    //categories
    ServiceInterface serviceinter = new ServiceImpl();
    @FXML
    private AnchorPane Slidepane;
    @FXML
    private AnchorPane ContenuePane;
    @FXML
    private JFXButton Down_Button;
    @FXML
    private JFXButton Add_button_view;
    @FXML
    private JFXButton View_button_view;
   
    
    @FXML
    private Label messagelabel;
    
    
    //ServiceTable
    @FXML
    private TableView<Service> ServiceTable;
    @FXML
    private TableColumn<Service, String> aff_Servicename;
    @FXML
    private TableColumn<Service, String> aff_servicecategory;
    @FXML
    private TableColumn<Service, String> aff_servicedescription;
    @FXML
    private TableColumn<Service, String> edit_col;
    
    
    //ObservableList<Service> ServiceList = FXCollections.observableArrayList();
    @FXML
    private JFXButton Return_Button;
    
    
    ////ACCOUNT SETTINGS
    @FXML
    private AnchorPane Account_Slide_Pane;
    @FXML
    private JFXButton Account_SettingsButton_down;
    @FXML
    private JFXButton Account_SettingsButton_up;
    @FXML
    private AnchorPane EditContenuePane;
    @FXML
    private JFXComboBox<String> myComboedit;
    //private String[] categories = {"Jardinnage","Plomberie","Electricté","Menage"};
    @FXML
    private JFXTextArea ServiceDescriptionedit;
    @FXML
    private JFXTextField ServiceNameedit;
    @FXML
    private Label messageEdit;
    @FXML
    private VBox SlideVBox;
    @FXML
    private JFXButton AddServiceButton;
    @FXML
    private JFXButton UpdateButton;
   
    @FXML
    private AnchorPane ServiceHomePane;
    @FXML
    private AnchorPane TopServicePane;
    @FXML
    private JFXButton ServiceHomeButton;
    @FXML
    private Label section_label;
    @FXML
    private JFXButton View_Button;
    @FXML
    private JFXButton Deconnexion_Button_Service;
    
    private MyListener myListener;
    
    
    
    
    
    ////TopServiceTable 
    @FXML
    private TableView<TopService> TopServiceTable;
    @FXML
    private TableColumn<TopService, String> TopServiceName;
    @FXML
    private TableColumn<TopService, String> TopNBDemandName;
    
    
    
    ////SERVICE MARKET
    
    @FXML
    private Pane SearchServicePane;
    @FXML
    private JFXTextField ServiceCategoryRequest;
    @FXML
    private JFXButton Add_Favorites_Button;
    @FXML
    private MaterialDesignIconView heartIconFavorite;
    @FXML
    private JFXButton RequestButton;
    @FXML
    private JFXButton CategoryButton;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane ServiceContenue;
    @FXML
    private JFXTextArea ServiceDescriptionedit1;
    @FXML
    private JFXTextField ServiceNameedit1;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //myCombo.getItems().addAll(list);
        myCombo.getItems().addAll(serviceinter.comboList());
        myComboedit.getItems().addAll(serviceinter.comboList());
        //myComboedit1.getItems().addAll(categories);
        Slidepane.setTranslateY(-100);
        Account_Slide_Pane.setTranslateY(-120);
        ServiceContenue.setVisible(false);
        ContenuePane.setVisible(false);
     ServiceHomePane.setVisible(true);
     TopServicePane.setVisible(true);
         ServiceTable.setVisible(false);
         SearchServicePane.setVisible(true);
     
        
       // Up_Button.setVisible(false);
        
        Return_Button.setVisible(false);
        EditContenuePane.setVisible(false);
        messageEdit.setVisible(false);
        section_label.setText("/ HOME");
        this.ServiceMarket();
       // Account_Slide_Pane.setVisible(false);
       
    }
    /////////
   // Combo List
   //public List<String> comboList ;
    
    ////CHOISEN SERVICE MARKET
    private void setChosenService(Service service){
      
        //ServiceContenue.setVisible(true);
         ServiceNameedit1.setText(service.getNom_Service());
         ServiceDescriptionedit1.setText(service.getService_Description());
         ServiceCategoryRequest.setText(service.getCategorie());
    }
       ////SERVICE MARKET
     public void ServiceMarket(){  
       serviceinter.findAllMarket().addAll(serviceinter.findAllMarket());
       
      // serviceinter.findAllMarket().addAll(serviceinter.findAllMarket());
       if(serviceinter.findAllMarket().size()>0){
           setChosenService(serviceinter.findAllMarket().get(0));
           myListener = new MyListener(){
               @Override
               public void onClickListener(Service service) {
                   setChosenService(service);
                   ServiceContenue.setVisible(true);
                   ServiceHomePane.setVisible(false);
                   TopServicePane.setVisible(false);
                   SearchServicePane.setVisible(false);
                   
               }
               
           };
       }
       int column = 1;
       int row = 1;
       try {
       for (int i=0 ; i< serviceinter.findAllMarket().size();i++){
           
           FXMLLoader fxmlloader = new FXMLLoader();
           fxmlloader.setLocation(getClass().getResource("/GUI/ServiceItem.fxml"));
           AnchorPane anchorPane = fxmlloader.load();
           ServiceItemController itemController = fxmlloader.getController();
           itemController.setData(serviceinter.findAllMarket().get(i), myListener);
           
           if(column ==4){
               column = 1;
               row++;
           }
           
            grid.add(anchorPane, column++, row);
            
           // grid.getChildren().
            ///set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            //USE_PREF_SIZE
            /// set grid hight
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
            
            GridPane.setMargin(anchorPane, new Insets(10));
            
                
            
       }
       } catch (IOException ex) {
                Logger.getLogger(MainServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }    
    
    @FXML
    private void OnClickedServiceButton(ActionEvent event){
        if(ServiceName.getText().isEmpty()== false && ServiceDescription.getText().isEmpty()== false && myCombo.getValue().isEmpty()== false){
            Service service = new Service(ServiceName.getText(), ServiceDescription.getText(), myCombo.getValue());
            serviceinter.addService(service);
            messagelabel.setText("Service added successfully ");
            ServiceName.clear();
            ServiceDescription.clear();
            myCombo.setValue("");
        }
        else{
            messagelabel.setText("Veuillez charger les champs !");
        }
    }
    
    
    ////ADDPAGE
@FXML
    private void OnAddScene(MouseEvent event) {
        ContenuePane.setVisible(true);
        ServiceHomePane.setVisible(false);
        TopServicePane.setVisible(false);
        this.slide_up(event);
        Return_Button.setVisible(true);
        ServiceTable.setVisible(false);
        this.OnACCOUNT_SETTING_Clicked_Button_up(event);
        EditContenuePane.setVisible(false);
        ServiceContenue.setVisible(false);
        SearchServicePane.setVisible(false);
        section_label.setText("/ ADD");
        
    }
/////VIEWPAGE
    @FXML
    private void OnViewClicked(MouseEvent event) {
        ServiceTable.setVisible(true);
        ServiceHomePane.setVisible(false);
        TopServicePane.setVisible(false);
        ServiceContenue.setVisible(false);
        SearchServicePane.setVisible(false);
        serviceinter.findAll();
        loadData();
       this.slide_up(event);
       this.OnACCOUNT_SETTING_Clicked_Button_up(event);
       Return_Button.setVisible(true);
       ContenuePane.setVisible(false);
       EditContenuePane.setVisible(false);
       section_label.setText("/ VIEW");
    }

    @FXML
    private void slide_down(MouseEvent event) {
        
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(Slidepane);
        
        slide.setToY(0);
        slide.play();
        
        Slidepane.setTranslateY(0);
        this.OnACCOUNT_SETTING_Clicked_Button_up(event);
        
        slide.setOnFinished((ActionEvent e) -> {
       // Up_Button.setVisible(true);
        //Down_Button.setVisible(false);
    });
        
        
    
    }

    public void slide_up(MouseEvent event) {
        
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(Slidepane);
        
        slide.setToY(-100);
        slide.play();
        
        Slidepane.setTranslateY(-100);
        
        slide.setOnFinished((ActionEvent e) -> {
        //Up_Button.setVisible(false);
        Down_Button.setVisible(true);
    });
        
    }
    private void refreshGrid(){
       // serviceinter.findAllMarket().clear();
       grid.getChildren().clear();
        ServiceMarket();
    }
     private void refreshTable(){
        serviceinter.findAll().clear();
        loadData();  
    }

    private void loadData() {
        //Service service;
        //ServiceList = serviceinter.findAll();
        ServiceTable.setItems(serviceinter.findAll());
        aff_Servicename.setCellValueFactory(new PropertyValueFactory<>("nom_Service"));
        aff_servicedescription.setCellValueFactory(new PropertyValueFactory<>("service_Description"));
        aff_servicecategory.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        
        
        Callback<TableColumn<Service, String>, TableCell<Service, String>> cellFoctory = (TableColumn<Service, String> param) -> {
            // make cell containing buttons
            final TableCell<Service, String> cell = new TableCell<Service, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            Service service = ServiceTable.getSelectionModel().getSelectedItem();
                            serviceinter.delete(service.getId_Service());
                            refreshTable();
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            EditContenuePane.setVisible(true);
                            ServiceTable.setVisible(false);
                            Service service = ServiceTable.getSelectionModel().getSelectedItem();
                            
                            ServiceNameedit.setText(service.getNom_Service());
                            ServiceDescriptionedit.setText(service.getService_Description());
                            myComboedit.setValue(service.getCategorie());
                            

                           

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         edit_col.setCellFactory(cellFoctory);
         ServiceTable.setItems(serviceinter.findAll());
        
    }

    @FXML
    private void On_Return_Button_Clicked(MouseEvent event) {
       
        
    }

    @FXML
    private void OnACCOUNT_SETTING_Clicked_Button(MouseEvent event) {
        
        
    }

    @FXML
    private void OnACCOUNT_SETTING_Clicked_Button_down(MouseEvent event) {
         TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(Account_Slide_Pane);
        
        slide.setToY(0);
        slide.play();
        
        Account_Slide_Pane.setTranslateY(75);
        
        this.slide_up(event);
        
        slide.setOnFinished((ActionEvent e) -> {
        Account_SettingsButton_up.setVisible(true);
        Account_SettingsButton_down.setVisible(false);
    });}

    @FXML
    private void OnACCOUNT_SETTING_Clicked_Button_up(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(Account_Slide_Pane);
        
        slide.setToY(-150);
        slide.play();
        
        Account_Slide_Pane.setTranslateY(-100);
        
        slide.setOnFinished((ActionEvent e) -> {
        Account_SettingsButton_up.setVisible(false);
        Account_SettingsButton_down.setVisible(true);
    });
        
    }

    @FXML
    private void OnClickedUpdateButton(MouseEvent event) {
        
        if(ServiceNameedit.getText().isEmpty()== false && ServiceDescriptionedit.getText().isEmpty()== false && myComboedit.getValue().isEmpty()== false){
            Service serviceselected = ServiceTable.getSelectionModel().getSelectedItem();
            Service service = new Service(ServiceNameedit.getText(), ServiceDescriptionedit.getText(), myComboedit.getValue());
            service.setId_Service(serviceselected.getId_Service());
            serviceinter.updateService(service);
            messageEdit.setText("Service updated successfully ");
            
            ServiceNameedit.clear();
            ServiceDescriptionedit.clear();
            myComboedit.setValue("");
            this.OnViewClicked(event);
            EditContenuePane.setVisible(false);
        }
        else{
            messagelabel.setText("Veuillez charger les champs !");
        }
        
    }
////HOMEPAGE
    @FXML
    public void ServiceHomeButton_onClickedButton(MouseEvent event) {
        SearchServicePane.setVisible(true);
       ServiceHomePane.setVisible(true);
       TopServicePane.setVisible(true);
       this.slide_up(event);
       this.OnACCOUNT_SETTING_Clicked_Button_up(event);
       ServiceTable.setVisible(false);
       ContenuePane.setVisible(false);
       EditContenuePane.setVisible(false);
       ServiceContenue.setVisible(false);
       section_label.setText("/ HOME");
       refreshGrid();
       
       /////
       ///TopServiceTable
       
       TopServiceTable.setVisible(true);
       
       TopServiceTable.setItems(serviceinter.TopService());
        TopServiceName.setCellValueFactory(new PropertyValueFactory<>("nom_Service"));
        TopNBDemandName.setCellValueFactory(new PropertyValueFactory<>("nb_demande"));
        TopServiceTable.setItems(serviceinter.TopService());
        
       
    }

    @FXML
    public void Deconnection_ServicePrestataireAccount(MouseEvent event) {
        
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
            
            
         
        } catch (IOException ex) {
            Logger.getLogger(Depanini.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Eroooooooooooor");
        }
         
    }

    @FXML
    private void On_ServiceFavorite_Clicked(MouseEvent event) {
        if(heartIconFavorite.isVisible()==true){
            heartIconFavorite.setVisible(false);
        }else
        {
            heartIconFavorite.setVisible(true);
        }
    }

    @FXML
    private void OnRequestButtonService_clicked(MouseEvent event) {
        heartIconFavorite.getScene().getWindow().hide();
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/EspaceClienDemande.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            //stage.getScene(scene)
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Depanini.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Eroooooooooooor");
        }
    }

    @FXML
    private void CategorySlide_on_clicked(MouseEvent event) {
      this.ServiceHomeButton_onClickedButton(event);
    }

    

    ////////////////////////////////////////////////////////////////
    
    /*
    public void ServiceMarket(){  
       serviceinter.findAllMarket().addAll(serviceinter.findAllMarket());
       if(serviceinter.findAllMarket().size()>0){
           setChosenService(serviceinter.findAllMarket().get(0));
           myListener = new MyListener(){
               @Override
               public void onClickListener(Service service) {
                   setChosenService(service);
                   ServiceContenue.setVisible(true);
                   ServiceHomePane.setVisible(false);
                   TopServicePane.setVisible(false);
                   SearchServicePane.setVisible(false);
                   
               }
               
           };
       }
       int column = 1;
       int row = 1;
       try {
       for (int i=0 ; i< serviceinter.findAllMarket().size();i++){
           
           FXMLLoader fxmlloader = new FXMLLoader();
           fxmlloader.setLocation(getClass().getResource("/GUI/ServiceItem.fxml"));
           AnchorPane anchorPane = fxmlloader.load();
           ServiceItemController itemController = fxmlloader.getController();
           itemController.setData(serviceinter.findAllMarket().get(i), myListener);
           
           if(column ==4){
               column = 1;
               row++;
           }
           
            grid.add(anchorPane, column++, row);
            
           // grid.getChildren().
            ///set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            //USE_PREF_SIZE
            /// set grid hight
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
            
            GridPane.setMargin(anchorPane, new Insets(10));
            
                
            
       }
       } catch (IOException ex) {
                Logger.getLogger(MainServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }    
    
    */
    ///////////////////
    
}
