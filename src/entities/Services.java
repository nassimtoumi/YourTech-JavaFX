/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author zcart
 */
public class Services {
    private int id;
    private String titre; 
    private String description; 
    private String nom; 
    private String tel; 
    private String image;
    
    public Services()
    {
        
    }

    public Services(int id, String titre, String description, String nom, String tel, String image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.nom = nom;
        this.tel = tel;
        this.image = image;
    }

    public Services(String titre, String description, String nom, String tel, String image) {
        this.titre = titre;
        this.description = description;
        this.nom = nom;
        this.tel = tel;
        this.image = image;
    }

    public Services(String titre, String description, String nom, String tel) {
        this.titre = titre;
        this.description = description;
        this.nom = nom;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

    
    