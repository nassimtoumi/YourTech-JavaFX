
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author zcart
 */
public class ReclamationService {
     private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection cnx; 
    
    public ReclamationService()
    { cnx= MyDB.getInstance().getCnx();
    }
    
    
    public void ajoutereclamation(Reclamation c)
    {
        String req = "insert into reclamation (nom, prenom, email,sujet,message) values  ('" + c.getNom()+"','" + c.getPrenom()+  "','" + c.getEmail()+ "','" + c.getSujet()+"','" + c.getMessage() +"')"; 
   
    try 
    {
        ste=cnx.createStatement(); 
        ste.executeUpdate(req); 
    }
    
    catch (SQLException ex)
    {
    Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public List <Reclamation> readAll()
    {
        String req = "select * from reclamation"; 
        
       List <Reclamation> list = new ArrayList<>(); 
       try {
       ste = cnx.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
            Reclamation r = new Reclamation(); 
            r.setId(rs.getInt("id")); 
            r.setNom(rs.getString("nom"));
            r.setEmail(rs.getString("email"));
            r.setSujet(rs.getString("sujet"));
            r.setMessage(rs.getString("message"));
            
            
            list.add(r);
            
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    public List <Reclamation> liste2()
    {
        String req = "select id, nom, prenom, email, sujet, message from reclamation"; 
        
       List <Reclamation> list = new ArrayList<>(); 
       try {
       ste = cnx.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Reclamation(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("subject"),rs.getString("message"))); 
       }
       
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    
     public void supprimerreclamation(int id) {
       try {
            Statement stm=cnx.createStatement();
            String query="delete from reclamation where id = '"+id+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
       
//      public void modifierreclamation ( int id , Reclamation c){
//         String requete="UPDATE reclamation SET (nom, prenom, email,sujet,message) values  ('" + c.getNom()+"','" + c.getPrenom()+  "','" + c.getEmail()+ "','" + c.getSujet()+"','" + c.getMessage() +"') where id = '"+id+"'";
//         
//
//         
//         try{
//             ste = cnx.createStatement();
//            ste.executeUpdate(requete);
//            System.out.println("reclamation modifié");
//        } catch (SQLException ex) {
//            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     }
     
     public ObservableList<Reclamation> getReclamationList() throws SQLException {
           
        ObservableList<Reclamation> reclamationlist = FXCollections.observableArrayList();
        
         List <Reclamation> rec = new ArrayList<>(); 
        Statement stm = cnx.createStatement();
        String query = "select id, nom, prenom, email, sujet, message from reclamation";

        //ResultSet rs;
        rs = stm.executeQuery(query);
        Reclamation reclamation;
        while (rs.next()) {
           reclamation = new Reclamation(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("sujet"), rs.getString("message")); 
            //System.out.println(events);
            reclamationlist.add(reclamation);

        }
        return reclamationlist;

    }
     
    //public ObservableList<Reclamation> getReclamationListnew() throws SQLException {
    //    String req = "select  id,nom, prenom, email,subject,message etat from reclamation";
    //    ObservableList<Reclamation> list = FXCollections.observableArrayList();
//
  //      try {
    //        rs = ste.executeQuery(req);
       //     while (rs.next()) {
         //       Reclamation r = new Reclamation();
           //     r.setId(rs.getInt("id"));
             //   r.setEtat(rs.getInt("etat"));
               // list.add(r);
//
  //          }
//
  //      } catch (SQLException ex) {
    //            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
      //  }
        //return list;

    //}

    public boolean modifierreclamation(Reclamation recm) {
//Connection cnx =null;
//        Statement st = null;
//        
//        
//        String requette = "UPDATE reclamation SET nom='"+recm.getNom()+"',prenom='"+recm.getPrenom()+"',email='"+recm.getEmail()+"',sujet='"+recm.getSujet()+"',message='"+recm.getMessage()+"' WHERE id="+recm.getId()+"";
//        try {
//  cnx = MyDB.getInstance().getCnx();            st = cnx.createStatement();
//            st.executeUpdate(requette);
//            return true;
//            
//           
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }finally {
//    
//    if (st != null) {
//        try {
//            st.close();
//        } catch (SQLException e) { /* Ignored */}
//    }
//    }}
//
//    
//}
