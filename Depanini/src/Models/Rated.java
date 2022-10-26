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
public class Rated {
    private String nom;
    private String prenom;
    private float rt;

    public Rated() {
    }

    
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getRt() {
        return rt;
    }

    public void setRt(float rt) {
        this.rt = rt;
    }

    public Rated(String nom) {
        this.nom = nom;
    }
    
}
