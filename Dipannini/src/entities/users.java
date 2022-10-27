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
public class users {
    private int id;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String roles;
    private int phonenumber;
    private String adresse;
    private String service;

    public users() {
    }

    public users(int id, String password, String firstname, String lastname, String email, String roles, int phonenumber, String adresse, String service) {
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roles = roles;
        this.phonenumber = phonenumber;
        this.adresse = adresse;
        this.service = service;
    }

    public users(String password, String email) {
        this.password = password;
        this.email = email;
    }

    
    public users(String password, String firstname, String lastname, String email, String roles, int phonenumber, String adresse, String service) {
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roles = roles;
        this.phonenumber = phonenumber;
        this.adresse = adresse;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", roles=" + roles + ", phonenumber=" + phonenumber + ", adresse=" + adresse + ", service=" + service + '}';
    }

    
    
    
    
    
    
}
