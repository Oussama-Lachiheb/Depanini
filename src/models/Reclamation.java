/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author asus
 */
public class Reclamation {
    private int Id_Reclamation;
    private String description;
    private String service;
    

    public Reclamation() {
    }

    public Reclamation(String description, String type) {
        this.description = description;
        this.service = type;
    }

    public Reclamation(int Id_Reclamation, String description, String type) {
        this.Id_Reclamation = Id_Reclamation;
        this.description = description;
        this.service = type;
        
        
    }

    public int getId_Reclamation() {
        return Id_Reclamation;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return service;
    }

    public void setId_Reclamation(int Id_Reclamation) {
        this.Id_Reclamation = Id_Reclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.service = type;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "Id_Reclamation=" + Id_Reclamation + ", description=" + description + ", type=" + service + '}';
    }

    
    
    
}
