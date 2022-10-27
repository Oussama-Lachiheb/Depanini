/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.users;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.usersCRUD;
import dipannini.Dipannini;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.session;

/**
 * FXML Controller class
 *
 * @author Ayoub
 */
public class FirstFormController implements Initializable {
    
    private static String currentMailReset;
    @FXML
    private TextField tfemail;
    @FXML
    private PasswordField tfpwd;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField resetcodeField;
    @FXML
    private TextField tfnpass;
    @FXML
    private TextField tfcpass;
    @FXML
    private Label ForgotPassword;
    @FXML
    private Button btnlogin;
    @FXML
    private Button signup;
    @FXML
    private Button btnsendcode;
    @FXML
    private Button verifyButton;
    @FXML
    private Button btnapply;
    @FXML
    private Button goback;
    @FXML
    private ImageView client;
    @FXML
    private ImageView servicepro;
    
     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        users u = new users();
        usersCRUD ucd = new usersCRUD();
        
        
    public void Login(MouseEvent event) throws IOException {
        String email = tfemail.getText();
        String pwd = tfpwd.getText();
        if (email.isEmpty() || pwd.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Veuillez remplir tous les champs obligatoires");
            alert.showAndWait();
        } else {
            u.setEmail(email);
            u.setPassword(pwd);
            ucd.login(u);
        if (session.getUser().getRoles().contains("ROLE_ADMIN")) {
                Parent root = FXMLLoader.load(getClass().getResource("Areyou.fxml"));
                Dipannini.primaryStage.setScene(new Scene(root));
                Dipannini.primaryStage.show();
            } else if (!session.getUser().getRoles().contains("ROLE_ADMIN")) {

                Parent root = FXMLLoader.load(getClass().getResource("promotion1.fxml"));
                Dipannini.primaryStage.setScene(new Scene(root));
                Dipannini.primaryStage.show();
            }     
        }
    }
    
    
    
    public void LinkToResetPassword() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sendresetcode.fxml"));
        Dipannini.primaryStage.setScene(new Scene(root));
        Dipannini.primaryStage.show();

    }
  

    
    public void sendcode(MouseEvent event) {
        FirstFormController.currentMailReset = userEmail.getText();

        if (userEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Veuillez saisir votre e-mail");
            alert.showAndWait();
        } else {
            if (ucd.sendresetCode(FirstFormController.currentMailReset)) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("verifyresetcode.fxml"));
                    Dipannini.primaryStage.setScene(new Scene(root));
                    Dipannini.primaryStage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FirstFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    
    public void verifyresetCode() throws IOException, Exception {
        String resetCode = resetcodeField.getText();
        int code = Integer.parseInt(resetCode);
        if (resetCode.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Veuillez entrer le code de réinitialisation");
            alert.showAndWait();
        } else if (code != usersCRUD.code) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Veuillez vérifier le code de réinitialisation");
            alert.showAndWait();
        } else {
            if (code == usersCRUD.code) {
                Parent root = FXMLLoader.load(getClass().getResource("resetpassword.fxml"));
                Dipannini.primaryStage.setScene(new Scene(root));
                Dipannini.primaryStage.show();
            }

        }

    }
    
    public void Apply() throws IOException, Exception {
        String npass = tfnpass.getText();
        String cpass = tfcpass.getText();

        if (npass.isEmpty() || cpass.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("Veuillez remplir tous les champs obligatoires");
            alert.showAndWait();
        } else if (!npass.equals(cpass)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("les mot de passes ne correspondent pas");
            alert.showAndWait();

        } else 
        {
             ucd.resetPassword(FirstFormController.currentMailReset, npass);
        }

    }

    @FXML
    private void goback() {
         try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FirstForm.fxml"));
            Parent root1=fxmlloader.load();
            Stage stage = new Stage();
            
            stage.setTitle("Dipannini");
            stage.setScene(new Scene(root1) );
            stage.show();
            
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
    }
        
    }
    
    
    @FXML
    private void signup(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Areyou.fxml"));
            Parent root1=fxmlloader.load();
            Stage stage = new Stage();
            
            stage.setTitle("Areyou");
            stage.setScene(new Scene(root1) );
            stage.show();
            
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
    }
    }

    @FXML
    private void client(MouseEvent event) {
         try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("promotion1.fxml"));  // Signe up page for client
            Parent root1=fxmlloader.load();
            Stage stage = new Stage();
            
            stage.setTitle("Areyou");
            stage.setScene(new Scene(root1) );
            stage.show();
            
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
    }
        
    }
    
    @FXML
    private void servicepro(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("promotion1.fxml"));  // Signe up page for service provider
            Parent root1=fxmlloader.load();
            Stage stage = new Stage();
            
            stage.setTitle("Areyou");
            stage.setScene(new Scene(root1) );
            stage.show();
            
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
    }
    }
    
}
