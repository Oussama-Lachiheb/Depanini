
package Interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import models.Service;
import models.TopService;
//import models.TopService;

public interface ServiceInterface {
    ObservableList<Service> findAll();
    
    Service findById(int id_Service);
    
    void addService(Service service);
    
    void updateService(Service service);
    
    void delete(int id_Service);
    
    ObservableList<TopService> TopService();
    List<Service> findAllMarket();
    List<Service> findByCategorie();
    ObservableList<String> comboList();
}
