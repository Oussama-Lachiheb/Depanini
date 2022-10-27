
package models;

public class Service {
    private int id_Service;
    private String nom_Service;
    private String service_Description;
    private String Categorie;


    public Service(int id_Service, String nom_Service, String service_Description, String Categorie) {
        this.id_Service = id_Service;
        this.nom_Service = nom_Service;
        this.service_Description = service_Description;
        this.Categorie = Categorie;
    }

    public Service(String nom_Service, String service_Description, String Categorie) {
        this.nom_Service = nom_Service;
        this.service_Description = service_Description;
        this.Categorie = Categorie;
    }

    public int getId_Service() {
        return id_Service;
    }

    public void setId_Service(int id_Service) {
        this.id_Service = id_Service;
    }

    public String getNom_Service() {
        return nom_Service;
    }

    public void setNom_Service(String nom_Service) {
        this.nom_Service = nom_Service;
    }

    public String getService_Description() {
        return service_Description;
    }

    public void setService_Description(String service_Description) {
        this.service_Description = service_Description;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    @Override
    public String toString() {
        return "Service{" + "id_Service=" + id_Service + ", nom_Service=" + nom_Service + ", service_Description=" + service_Description + ", Categorie=" + Categorie + '}';
    }
    
    
}
