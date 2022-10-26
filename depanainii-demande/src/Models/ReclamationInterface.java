/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entities.Demande;
import entities.Reclamation;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public interface ReclamationInterface {
    public void ajouterReclamation(Reclamation R);
    public void updateReclamation(Reclamation R);
    
    public void supprimer_reclamation(int id);
    public Reclamation chercher_reclamation(int id);
    public ObservableList<Reclamation> Consulter_Reclamation();
}
