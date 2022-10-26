/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author THINKPAD
 */
public interface RateInterface {
    public void ajouterRate(Rate R,int id_Prestataire,int id_Client);
    public void UpdateRate(Rate R);
    public ObservableList<Rate> afficherRate();
    public void TopRated();
    public ObservableList<Rate> YourRate(int id);
    public String MoyRate(int id);
    
}
