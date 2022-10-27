/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ayoub
 */
public class promotion {
    
    private int id_promo;
    private int id_service;
    private String nom_service;
    private double prix_heure_pres;
    private int taux_promo;
    private double prix_heure_final;

    public promotion() {
    }

    public promotion(int id_promo, int id_service, String nom_service, double prix_heure_pres, int taux_promo, double prix_heure_final) {
        this.id_promo = id_promo;
        this.id_service = id_service;
        this.nom_service = nom_service;
        this.prix_heure_pres = prix_heure_pres;
        this.taux_promo = taux_promo;
        this.prix_heure_final = prix_heure_final;
    }

    public promotion(int id_service, String nom_service, double prix_heure_pres, int taux_promo, double prix_heure_final) {
        this.id_service = id_service;
        this.nom_service = nom_service;
        this.prix_heure_pres = prix_heure_pres;
        this.taux_promo = taux_promo;
        this.prix_heure_final = prix_heure_final;
    }

    public promotion(int id_service, String nom_service, double prix_heure_pres, int taux_promo) {
        this.id_service = id_service;
        this.nom_service = nom_service;
        this.prix_heure_pres = prix_heure_pres;
        this.taux_promo = taux_promo;
    }
    
    

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    public double getPrix_heure_pres() {
        return prix_heure_pres;
    }

    public void setPrix_heure_pres(double prix_heure_pres) {
        this.prix_heure_pres = prix_heure_pres;
    }

    public int getTaux_promo() {
        return taux_promo;
    }

    public void setTaux_promo(int taux_promo) {
        this.taux_promo = taux_promo;
    }

    public double getPrix_heure_final() {
        return prix_heure_final;
    }

    public void setPrix_heure_final(double prix_heure_final) {
        this.prix_heure_final = prix_heure_final;
    }

    @Override
    public String toString() {
        return "promotion{" + "id_promo=" + id_promo + ", id_service=" + id_service + ", nom_service=" + nom_service + ", prix_heure_pres=" + prix_heure_pres + ", taux_promo=" + taux_promo + ", prix_heure_final=" + prix_heure_final + '}';
    }
    
    public double prix_final(int taux_promo, double prix_heure_pres){
       
       double s = prix_heure_pres-(prix_heure_pres*taux_promo)/100;
       
        return s ;
    }
    
    
    
    
    
    
}
