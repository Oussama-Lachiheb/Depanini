/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Hannachi
 */
public class TopService {
    private String nom_Service;
    private int nb_demande;

    public TopService(String nom_Service, int nb_demande) {
        this.nom_Service = nom_Service;
        this.nb_demande = nb_demande;
    }

    public String getNom_Service() {
        return nom_Service;
    }

    public int getNb_demande() {
        return nb_demande;
    }

    public void setNom_Service(String nom_Service) {
        this.nom_Service = nom_Service;
    }

    public void setNb_demande(int nb_demande) {
        this.nb_demande = nb_demande;
    }

    @Override
    public String toString() {
        return "TopService{" + "nom_Service=" + nom_Service + ", nb_demande=" + nb_demande + '}';
    }
}
