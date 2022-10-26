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
public class prestataire {
    public int id_Prestataire;
    public String nom;
    public String prenom;
    public String localisation;
    public String service;
    public String email;
    public String mot_de_passe;
    public String role;
    public double prix_heure;
    public float rate;

    public void setRate(float rate) {
        this.rate = rate;
    }
    

    public prestataire() {
    }

    public prestataire(int id_Prestataire) {
        this.id_Prestataire = id_Prestataire;
    }

    public prestataire(String nom) {
        this.nom = nom;
    }

    public prestataire(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    

    
    public prestataire(int id_Prestataire,String nom, String prenom, String localisation, String service, String email, String mot_de_passe, String role, double prix_heure) {
        this.id_Prestataire = id_Prestataire;
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.service = service;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.prix_heure = prix_heure;
    }

    public prestataire(String nom, String prenom,String localisation, String service, String email, String mot_de_passe, String role, double prix_heure) {
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.service = service;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.prix_heure = prix_heure;
    }
 public prestataire(String nom, String prenom,String localisation, String service, String email, String mot_de_passe, String role, double prix_heure,int id_Prestataire) {
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.service = service;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.prix_heure = prix_heure;
        this.id_Prestataire = id_Prestataire;
    }
    public void setId_Prestataire(int id_Prestataire) {
        this.id_Prestataire = id_Prestataire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setPrix_heure(double prix_heure) {
        this.prix_heure = prix_heure;
    }
    
     

    public int getId_Prestataire() {
        return id_Prestataire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getService() {
        return service;
    }

    public String getEmail() {
        return email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getRole() {
        return role;
    }


    public double getPrix_heure() {
        return prix_heure;
    }
    
   
    @Override
    public String toString() {
        return "prestataire{" + "id_Prestataire=" + id_Prestataire + "nom" + nom + "prenom" + prenom + ", localisation=" + localisation + ", service=" + service + ", email=" + email + ", mot_de_passe=" + mot_de_passe + ", role=" + role +", prix_heure=" + prix_heure + '}';
    }
   
}
