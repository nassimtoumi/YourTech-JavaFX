/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TextField tfsubject;
    @FXML
    private TextField tfmessage;
    @FXML
    private Button btnenvoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void passToR2(java.awt.event.ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation2.fxml"));
            Parent root =loader.load();
            Reclamation2Controller cc= loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
          //  stage.setTitle("Blocker/Deblocker Utilisateur");
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
