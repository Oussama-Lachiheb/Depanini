/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author THINKPAD
 */
public class Rate {
    private int id;
    private float rate;
   private int id_Prestataire; 
   private int id_Client; 
    //private String nom;
    //private String prenom;

    public Rate() {
    }

    
    /*public Rate(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }*/

    
    
    public Rate(int id, float rate,int id_Prestataire, int id_Client) {
        this.id = id;
        this.rate = rate;
        this.id_Prestataire=id_Prestataire;
        this.id_Client = id_Client;
    }
    public Rate(float rate, int id) {
        this.id = id;
        this.rate = rate;
        

    }
    

    public Rate(float rate,int id_Prestataire,int id_Client) {
        this.rate = rate;
        this.id_Prestataire= id_Prestataire;
        this.id_Client = id_Client;

    }
    public Rate(float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public float getRate() {
        return rate;
    }

    public int getId_Prestataire() {
        return id_Prestataire;
    }

    public int getId_Client() {
        return id_Client;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setId_Prestataire(int id_Prestataire) {
        this.id_Prestataire = id_Prestataire;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    @Override
    public String toString() {
        return "Rate{" + "id=" + id + ", rate=" + rate + ",id_Pres" + id_Prestataire + "id_Client"+id_Client+'}';
    }
    
}
