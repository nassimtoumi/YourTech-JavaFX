/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Services ; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author zcart
 */
public class ServicesService {
    private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection cnx; 
    
    public ServicesService()
    { 
        cnx= MyDB.getInstance().getCnx();
    }
    
    
    
    //fonction ajouter article
    public void ajouterservice(Services a)
    {
        String req = "insert into service (titre, description, nom, tel, image) values  ('" + a.getTitre() +"','" + a.getDescription() +  "','" + a.getNom() + "','" + a.getTel() +  "','" + a.getImage() + "')"; 
   
    try 
    {
        ste=cnx.createStatement(); 
        ste.executeUpdate(req); 
    }
    
    catch (SQLException ex)
    {
    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     public List <Services> readAll()
    {
        String req = "select * from service"; 
        
       List <Services> list = new ArrayList<>(); 
       try {
       ste = cnx.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Services(rs.getInt("id"), rs.getString("titre"), rs.getString("description"), rs.getString("nom"), rs.getString("tel"), rs.getString("image"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ServicesService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    public List <Services> liste2()
    {
        String req = "select id, nom, description, categorie, prix from service"; 
        
       List <Services> list = new ArrayList<>(); 
       try {
       ste = cnx.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Services(rs.getString("titre"), rs.getString("description"), rs.getString("nom"), rs.getString("tel"), rs.getString("image")));
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ServicesService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    
     public void supprimerService(int id) {
       try {
            Statement stm=cnx.createStatement();
            String query="delete from service where id = '"+id+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(ServicesService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
       
      public void modifierService (int id, String nom, String description,String categorie, int prix, String image){
         String requete="UPDATE service SET nom='"+nom+"', description='"+description+"', categorie='"+categorie+"',prix='"+prix+"',image='"+image+"'  WHERE id='"+id+"'";
         
         
         try{
             ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Service modifié");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesService.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}