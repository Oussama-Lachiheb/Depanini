package Interfaces;

import models.Demande;
import java.sql.Date;
import java.text.ParseException;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public interface DemandeInterface {
     public void ajouter_Demande(Demande C ) throws ParseException;
     public void supprimer_demande (int identt);
public ObservableList<Demande> Consulter_Demande();
public void updateUser(Demande c);
    public void updateUser(int i, Date date, String en_cours, String demande_de_mince);
    public void consulterDemande() ;
    public ObservableList<Demande> afficher_Demande();
}
