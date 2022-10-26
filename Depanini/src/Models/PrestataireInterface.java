/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author THINKPAD
 */
public interface PrestataireInterface {
    public void ajouterPrestataire(prestataire p);
    public void SuprimerPrestataire(int id);
    public ObservableList<prestataire> findPrestataire(int id);
    public void UpdatePrestataire(String nom,String prenom,String localisation,String service,String email,String mot_de_passe,String role,float prix_heure);
    public List<prestataire> afficherPrestataire();
    public List<prestataire> TopRated1();
    public int getIDDps(String email);
}
