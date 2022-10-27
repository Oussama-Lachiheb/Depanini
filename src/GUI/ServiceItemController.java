
package GUI;

import depanini.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Service;



public class ServiceItemController implements Initializable {

    @FXML
    private Label ServiceItemLabel;
    @FXML
    private Label ServiceCategoryLabel;
    @FXML
    private Label ServiceDescriptionLabel;

   private Service service;
    @FXML
    private AnchorPane ServiceItem;
    private MyListener myListener;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
     public void setData(Service service, MyListener myListener){
       this.service = service;
       this.myListener = myListener;
       ServiceItemLabel.setText(service.getNom_Service());
       ServiceCategoryLabel.setText(service.getCategorie());
       ServiceDescriptionLabel.setText(service.getService_Description());
   }
//MainServiceController msc = new MainServiceController();
    @FXML
    private void OnServiceItemClicked(MouseEvent mouseEvent) {
        
        myListener.onClickListener(service);
            /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/MainService.fxml"));
            MainServiceController msc = loader.getController();
            msc.ServiceContenue.setVisible(true);*/
    }
    
}
