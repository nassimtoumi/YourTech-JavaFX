/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Nassim
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfsujet;
    @FXML
    private TextField tfmessage;
    @FXML
    private Button btnenvoyer;
    @FXML
    private TableView<Reclamation> afficherreclamation;
    @FXML
    private Button btnsupprimer;
    ReclamationService recs = new ReclamationService();
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnexcel;
    @FXML
    private TableColumn<Reclamation, String > idrec;
    @FXML
    private TableColumn<Reclamation, String> nomrec;
    @FXML
    private TableColumn<Reclamation, String> prenomrec;
    @FXML
    private TableColumn<Reclamation, String> emailrec;
    @FXML
    private TableColumn<Reclamation, String> sujetrec;
    @FXML
    private TableColumn<Reclamation, String> messagerec;
    private int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //reclamationsujet.setItems(op);
                  afficherreclamation.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                id = recs.readAll()
                        .get(afficherreclamation.getSelectionModel().getSelectedIndex())
                        .getId();
                //System.out.println(iddd);
                
                nomrec.setText(recs.readAll()
                        .get(afficherreclamation.getSelectionModel()
                                .getSelectedIndex())
                        .getNom()
                ); 
                
                prenomrec.setText(recs.readAll()
                        .get(afficherreclamation.getSelectionModel().getSelectedIndex())
                        .getPrenom());
                
                emailrec.setText(recs.readAll()
                         .get(afficherreclamation.getSelectionModel().getSelectedIndex())
                        .getEmail());
                
                
                
                sujetrec.setText(recs.readAll()
                        .get(afficherreclamation.getSelectionModel()
                                .getSelectedIndex())
                        .getSujet());
                
                messagerec.setText(recs.readAll()
                        .get(afficherreclamation.getSelectionModel()
                                .getSelectedIndex())
                        .getMessage()
                );
                
  
                
               
                };
            
         
               
         }); 
       
         ObservableList<Reclamation> list = null;

         
        try {
            list = recs.getReclamationList(); // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         idrec.setCellValueFactory(new PropertyValueFactory<>("id"));
         nomrec.setCellValueFactory(new PropertyValueFactory<>("nom"));
         prenomrec.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         emailrec.setCellValueFactory(new PropertyValueFactory<>("email"));
         sujetrec.setCellValueFactory(new PropertyValueFactory<>("sujet"));
         messagerec.setCellValueFactory(new PropertyValueFactory<>("message"));
         //etatcolrec.setCellValueFactory(new PropertyValueFactory<>("etat"));
         afficherreclamation.setItems(list);
        // TODO
    }    

    
  @FXML
    private void ajouterreclamation(ActionEvent event) throws Exception {
        
          Reclamation rec = new Reclamation(tfnom.getText(),tfprenom.getText(),tfemail.getText(),tfsujet.getText(),tfmessage.getText());
        
        ReclamationService rs = new ReclamationService();
        rs.ajoutereclamation(rec);
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Addeded!");
                alert.show();
                
              
                
                afficherreclamation.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
             afficherreclamation.setItems(rs.getReclamationList());
            //mail.sendMail(reclamationemail.getText());
            
//    private void passToR2(ActionEvent event) {
//    try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation2.fxml"));
//            Parent root =loader.load();
//            Reclamation2Controller cc= loader.getController();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));  
//            stage.show();
//          //  stage.setTitle("Blocker/Deblocker Utilisateur");
//            
//                 
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    
    }

    @FXML
    private void supprimerrecbtn(ActionEvent event) {
        
        
        
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer cet reclamation  ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            ReclamationService rs = new ReclamationService();
            try {
                rs.supprimerreclamation(id);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText(" Done!");
                alert.show();
                afficherreclamation.setItems(rs.getReclamationList());
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec");
                alert.setHeaderText(null);
                alert.setContentText("Delete Failed !");
            }

        } else {
            alert2.close();
        }
    }

    @FXML
    private void modifierrecbtn(ActionEvent event) throws SQLException {
         Reclamation rec = new Reclamation(tfnom.getText(),tfprenom.getText(),tfemail.getText(),tfsujet.getText(),tfmessage.getText());
        
        ReclamationService rs = new ReclamationService();
        rs.modifierreclamation(rec);
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Modifier!");
                alert.show();
                
              
                
                afficherreclamation.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
             afficherreclamation.setItems(rs.getReclamationList());
    }
}
