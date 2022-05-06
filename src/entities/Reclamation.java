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
public class Reclamation {
    
    private int id; 
    private String nom; 
    private String prenom; 
    private String email; 
    private String sujet;
    private String message;

    
    
    public Reclamation()
    {
        
    }
    public Reclamation( int id, String nom, String prenom, String email, String sujet, String message)
    {
        this.id=id; 
        this.nom=nom; 
        this.prenom=prenom; 
        this.email=email; 
        this.sujet=sujet; 
        this.message=message; 
        //this.etat=etat;
    }

    
      public Reclamation( String nom, String prenom, String email, String sujet, String message)
    {
        this.nom=nom; 
        this.prenom=prenom; 
        this.email=email; 
        this.sujet=sujet; 
        this.message=message; 
        
    }
      
    

       public int getId()
     {return id;}
   
   public String getNom()
   {return nom; }
   
   public  String getPrenom()
   {return prenom;}
   
   public String getEmail()
   { return email; }
   
   public String getSujet()
   { return sujet; }
      public String getMessage()
   { return message;}
      
  public void setId(int id) {
        this.id = id;
    }

   
   public void setNom(String nom)
   {this.nom=nom; }
   
   public void setPrenom(String prenom)
   {this.prenom=prenom;}
   
   public void setEmail(String email)
   {this.email=email;}
   
   public void setSujet(String subject)
   {this.sujet=sujet ;}
   
   
   
   public void setMessage(String message)
   {this.message=message ;}
   

   
   
  @Override 
  public String toString()
  {
      return "article{" + "id=" +id + ", nom=" + nom + ", prenom=" + prenom +  "email=" + email +", subject=" + sujet + ",message=" + message + '}'; 
  }
    
}
